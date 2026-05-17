# Developer Guide — Scala Runtime

## Type Mapping Table

| TypeSpec Type        | Scala Type       | Notes                                                |
|----------------------|------------------|------------------------------------------------------|
| `boolean`            | `Boolean`        |                                                      |
| `int8`               | `Byte`           | Cast from `readInt32()`                              |
| `int16`              | `Short`          | Cast from `readInt32()`                              |
| `int32`              | `Int`            | Direct                                               |
| `int64`              | `Long`           | Direct                                               |
| `uint8`              | `Long`           | No unsigned types — stored as `Long`                 |
| `uint16`             | `Long`           | No unsigned types — stored as `Long`                 |
| `uint32`             | `Long`           | No unsigned types — stored as `Long`                 |
| `uint64`             | `Long`           | No unsigned types — stored as `Long`                 |
| `float32`            | `Float`          | Single precision                                     |
| `float64`            | `Double`         | Double precision                                     |
| `string`             | `String`         |                                                      |
| `bytes`              | `Array[Byte]`    |                                                      |

**Unsigned types**: Scala (like Java/JVM) lacks native unsigned types. All unsigned values are stored as `Long`. The `SpecReader.readUint32()` returns `Long`, `readUint64()` returns `Long`. Unsigned comparisons use `java.lang.Long.compareUnsigned`. Unsigned remainder uses `java.lang.Integer.remainderUnsigned`.

## Model Representation

**Models** are emitted as Scala `case class` types with **all fields having defaults** (Scala style):

```scala
case class Person(
  name: String = "",
  age: Int = 0,
  nickname: Option[String] = None
)
```

Every field (including required) gets a default value. This enables the idiomatic Scala decode pattern of accumulating into mutable variables and passing them to the constructor at the end.

## Optional / Nullable

- **Optional fields** use Scala **`Option[T]`** (`Some`/`None`).
- Default value `= None` for optional fields.
- Required reference types get `= ""` or similar defaults.
- Generated encode:
  ```scala
  v.nickname match {
    case Some(nn) =>
      w.writeField("nickname")
      w.writeString(nn)
    case None => ()
  }
  ```
- `SpecUndefined` is a `case object`: `case object SpecUndefined`

## Union Representation

Discriminated unions use **`sealed trait`** with **`case class`** variants and a **`case object Undefined`**:

```scala
sealed trait Shape
object Shape {
  case object Undefined extends Shape
  case class Circle(radius: Double) extends Shape
  case class Rectangle(width: Double, height: Double) extends Shape
}
```

## Enum Representation

Scala 3 uses **native `enum`** syntax:

```scala
enum Color(val value: Int):
  case Red extends Color(0)
  case Green extends Color(1)
  case Blue extends Color(2)
```

For extensible enums, the emitter can include a fallback. When used as `String`-based, the value is a string label.

## Ryu Implementation

Package `specodec.ryu`:

| File            | Purpose                                           |
|-----------------|---------------------------------------------------|
| `RyuF32.scala`  | `float32` → shortest decimal string               |
| `RyuF64.scala`  | `float64` → shortest decimal string               |
| `RyuMath.scala` | Shared integer math                               |
| `TablesF32.scala`| F32 lookup tables                                |
| `TablesF64.scala`| F64 lookup tables                                |

**Bit extraction:**
- F32: `java.lang.Float.floatToRawIntBits(f)`
- F64: `java.lang.Double.doubleToRawLongBits(d)`

**Unsigned operations:** Uses JVM methods directly:
```scala
java.lang.Long.compareUnsigned(a, b)
java.lang.Long.divideUnsigned(a, b)
java.lang.Integer.remainderUnsigned(a, b)  // for modulo
```

**Table sizes:** Same as Java:
- `FLOAT_POW5_INV_SPLIT`: 27 × `Long`
- `FLOAT_POW5_SPLIT`: 48 × `Long`
- `DOUBLE_POW5_INV_SPLIT`: ~342 × `Array[Long]`
- `DOUBLE_POW5_SPLIT`: ~309 × `Array[Long]`

## MsgPack Reader / Writer

**Reader** (`MsgPackReader.scala`):
- Accumulation: counter-based. `ArrayBuffer[Int] containerCount`.
- `private val data: Array[Byte]`, `private var pos: Int`.
- Byte masking: `data(pos) & 0xFF`.
- **uint32 reading**: `readU32()` returns `Long` to avoid Java signed int overflow:
  ```scala
  private def readU32(): Long = {
    val v = ((data(pos).toLong & 0xFF) << 24) | ...
  }
  ```
- Unsigned interpretation for `readUint32()`: `readInt() & 0xFFFFFFFFL` (returns `Long`).
- Float: `java.lang.Float.intBitsToFloat`, `java.lang.Double.longBitsToDouble`.
- NaN/Inf: raw IEEE 754 bits.

**Writer** (`MsgPackWriter.scala`):
- Accumulation: `ArrayBuffer[Byte]`.
- **uint64 comparisons** use `java.lang.Long.compareUnsigned`:
  ```scala
  if (java.lang.Long.compareUnsigned(value, 0x7FL) <= 0) w8(value.toInt)
  ```
- uint32: `w32(value.toLong & 0xFFFFFFFFL)` — masking to long.
- Float: `java.lang.Float.floatToRawIntBits`, `java.lang.Double.doubleToRawLongBits`.
- Field tracking: no writer-side state needed (MsgPack header encodes count).

## JSON Reader / Writer

**Reader** (`JsonReader.scala`):
- Converts `Array[Byte]` to `String` via `new String(data, "UTF-8")`.
- **Unicode escape**: `\uXXXX` with surrogate pair support.
- Number parsing: character-level validation, then `.toInt`, `.toLong`, etc.
- int64/uint64: both bare and quoted.
- NaN/Inf: quoted strings.
- Bytes: `java.util.Base64.getDecoder.decode(s)`.

**Writer** (`JsonWriter.scala`):
- Accumulation: `StringBuilder`.
- Escape: standard set + `\u00XX` for control chars.
- int64/uint64: quoted strings.
- NaN/Inf: quoted strings.

## Gron Reader / Writer

**Reader** (`GronReader.scala`):
- Line-based parsing of `path = value;`.
- Context stack with case class.
- Path prefix matching for nesting.
- Unescape with `\uXXXX` surrogate pair support.

**Writer** (`GronWriter.scala`):
- Segment stack starting with `"json"`.
- Nesting tracked via inner class / tuple.
- Final: `lines.mkString("\n") + "\n"` → `.getBytes("UTF-8")`.

## State Management

Scala uses **mutable** state in the runtime layer (`var pos`, `ArrayBuffer`). Generated models are `case class` (immutable). Decode accumulators use `var` with defaults, then constructor assembly.

## SpecReader / SpecWriter Interfaces

**SpecReader** (`SpecReader.scala:1-24`) — a `trait`:
```scala
trait SpecReader {
  def beginObject(): Unit; def hasNextField(): Boolean; def readFieldName(): String; def endObject(): Unit
  def beginArray(): Unit; def hasNextElement(): Boolean; def endArray(): Unit
  def readString(): String; def readBool(): Boolean
  def readInt32(): Int; def readInt64(): Long
  def readUint32(): Long; def readUint64(): Long    // Returns Long (no unsigned type)
  def readFloat32(): Float; def readFloat64(): Double
  def readNull(): Unit; def readBytes(): Array[Byte]; def readEnum(): String
  def isNull(): Boolean; def skip(): Unit
}
```

**SpecWriter** (`SpecWriter.scala:1-22`) — a `trait`:
```scala
trait SpecWriter {
  def writeString(value: String): Unit; def writeBool(value: Boolean): Unit
  def writeInt32(value: Int): Unit; def writeInt64(value: Long): Unit
  def writeUint32(value: Long): Unit; def writeUint64(value: Long): Unit  // Takes Long
  def writeFloat32(value: Float): Unit; def writeFloat64(value: Double): Unit
  def writeNull(): Unit; def writeBytes(value: Array[Byte]): Unit; def writeEnum(value: String): Unit
  def beginObject(fieldCount: Int): Unit; def writeField(name: String): Unit; def endObject(): Unit
  def beginArray(elementCount: Int): Unit; def nextElement(): Unit; def endArray(): Unit
  def toBytes(): Array[Byte]
}
```

Note: `writeUint32(value: Long)` / `writeUint64(value: Long)` — both take `Long` since Scala/JVM has no unsigned primitives.

**SpecCodec** (`SpecCodec.scala`): case class wrapping encode/decode functions with `FormatRegistry` for dispatch/respond.

## Emitter Generation Pattern

```scala
// Generated:
case class Person(
  name: String = "",
  age: Int = 0,
  nickname: Option[String] = None
)

object Person {
  val codec: SpecCodec[Person] = SpecCodec[Person](
    encode = (w, v) => {
      w.beginObject(if (v.nickname.isDefined) 3 else 2)
      w.writeField("name")
      w.writeString(v.name)
      w.writeField("age")
      w.writeInt32(v.age)
      v.nickname match {
        case Some(nn) =>
          w.writeField("nickname")
          w.writeString(nn)
        case None => ()
      }
      w.endObject()
    },
    decode = r => {
      var __name = ""
      var __age = 0
      var __nickname: Option[String] = None
      r.beginObject()
      while (r.hasNextField()) {
        r.readFieldName() match {
          case "name" => __name = r.readString()
          case "age" => __age = r.readInt32()
          case "nickname" => __nickname = Some(r.readString())
          case _ => r.skip()
        }
      }
      r.endObject()
      Person(__name, __age, __nickname)
    }
  )
}
```

## Known Quirks / Bugs

1. **No unsigned types**: Scala has no native unsigned integer types. All unsigned values are stored as `Long`. This means uint32 values occupy 8 bytes instead of 4. Unsigned comparisons use JVM methods: `java.lang.Long.compareUnsigned`, `java.lang.Long.divideUnsigned`, `java.lang.Integer.remainderUnsigned`.

2. **uint32 reading**: `readUint32()` internally calls `readU32()` (returns `Long`) to avoid Java signed overflow. The raw `readU32()` helper returns `Long` not `Int`: `v.toLong & 0xFF` per byte.

3. **All fields have defaults**: Unlike other languages where only optional fields have defaults, Scala codec models give **every** field a default value (`= ""`, `= 0`, `= None`). This is idiomatic Scala for decode-then-construct patterns.

4. **Scala 3 enums**: The runtime and emitter target Scala 3. Enum representation uses native `enum` keyword syntax.

## DevContainer

- Base image: `dev:scala` (extends `dev:java`)
- Build: `sbt compile` / `sbt assembly` (via `build.sbt`)
- Config: `build.sbt` + `project/` directory
- Output: JAR from `target/`
- Containerfile: `Containerfile.build` — copies SBT configs + `src/`, runs `sbt`, copies output to scratch
