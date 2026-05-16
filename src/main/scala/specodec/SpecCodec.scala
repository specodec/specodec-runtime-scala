package specodec

class SCodecError(val code: String, message: String) extends Exception(message)

case class SpecCodec[T](
  encode: (SpecWriter, T) => Unit,
  decode: SpecReader => T
)

case class FormatEntry(
  name: String,
  newWriter: () => SpecWriter,
  newReader: Array[Byte] => SpecReader
)

class FormatRegistry {
  private var entries: List[FormatEntry] = Nil

  def register(entry: FormatEntry): FormatRegistry = {
    entries = entries :+ entry
    this
  }

  def `match`(format: String): FormatEntry =
    entries.find(_.name == format).getOrElse(entries.head)
}

object FormatRegistry {
  val default: FormatRegistry = new FormatRegistry()
    .register(FormatEntry("json",    () => new JsonWriter(),    bytes => new JsonReader(bytes)))
    .register(FormatEntry("msgpack", () => new MsgPackWriter(), bytes => new MsgPackReader(bytes)))
    .register(FormatEntry("gron",    () => new GronWriter(),    bytes => new GronReader(bytes)))
}

case class RespondResult(body: Array[Byte], name: String)

def dispatch[T](codec: SpecCodec[T], body: Array[Byte], format: String,
                 registry: FormatRegistry = FormatRegistry.default): T = {
  val fmt = registry.`match`(format)
  codec.decode(fmt.newReader(body))
}

def respond[T](codec: SpecCodec[T], obj: T, format: String,
               registry: FormatRegistry = FormatRegistry.default): RespondResult = {
  val fmt = registry.`match`(format)
  val w = fmt.newWriter()
  codec.encode(w, obj)
  RespondResult(body = w.toBytes(), name = fmt.name)
}
