package specodec

import scala.collection.mutable.{ArrayBuffer, StringBuilder}

class GronWriter extends SpecWriter:
  private val lines: ArrayBuffer[String] = ArrayBuffer.empty
  private val segments: ArrayBuffer[String] = ArrayBuffer("json")
  private val nesting: ArrayBuffer[NestInfo] = ArrayBuffer.empty

  private class NestInfo(val depth: Int, var arrayIndex: Int = -1)

  private def buildPath(): String =
    var r = segments(0)
    for i <- 1 until segments.size do
      if segments(i).startsWith("[") then r += segments(i)
      else r += "." + segments(i)
    r

  private def escape(s: String): String =
    val sb = new StringBuilder()
    for c <- s do
      c.toInt match
        case 0x22 => sb.append("\\\"")
        case 0x5C => sb.append("\\\\")
        case 0x08 => sb.append("\\b")
        case 0x0C => sb.append("\\f")
        case 0x0A => sb.append("\\n")
        case 0x0D => sb.append("\\r")
        case 0x09 => sb.append("\\t")
        case n if n <= 0x1F =>
          val hex = n.toHexString
          sb.append("\\u" + ("0000".substring(hex.length)) + hex)
        case _ => sb.append(c)
    sb.toString()

  private def b64(buf: Array[Byte]): String =
    val chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/"
    val sb = new StringBuilder()
    var i = 0
    while i < buf.length do
      val b0 = buf(i).toInt & 0xFF
      val b1 = if i + 1 < buf.length then buf(i + 1).toInt & 0xFF else 0
      val b2 = if i + 2 < buf.length then buf(i + 2).toInt & 0xFF else 0
      sb.append(chars(b0 >> 2))
      sb.append(chars(((b0 & 3) << 4) | (b1 >> 4)))
      sb.append(if i + 1 < buf.length then chars(((b1 & 0xF) << 2) | (b2 >> 6)) else '=')
      sb.append(if i + 2 < buf.length then chars(b2 & 0x3F) else '=')
      i += 3
    sb.toString()

  private def emit(raw: String): Unit =
    lines += s"${buildPath()} = $raw;"

  override def writeString(value: String): Unit =
    emit(s"\"${escape(value)}\"")

  override def writeBool(value: Boolean): Unit =
    emit(if value then "true" else "false")

  override def writeInt32(value: Int): Unit =
    emit(value.toString())

  override def writeInt64(value: Long): Unit =
    emit(s"\"$value\"")

  override def writeUint32(value: Long): Unit =
    emit(value.toString())

  override def writeUint64(value: Long): Unit =
    emit("\"" + java.lang.Long.toUnsignedString(value) + "\"")

  override def writeFloat32(value: Float): Unit =
    if value.isNaN() then
      emit("\"NaN\"")
    else if value.isInfinite() then
      emit(if value > 0 then "\"Infinity\"" else "\"-Infinity\"")
    else
      emit(formatFloat32(value))

  override def writeFloat64(value: Double): Unit =
    if value.isNaN() then
      emit("\"NaN\"")
    else if value.isInfinite() then
      emit(if value > 0 then "\"Infinity\"" else "\"-Infinity\"")
    else
      emit(formatFloat64(value))

  override def writeNull(): Unit = emit("null")

  override def writeBytes(value: Array[Byte]): Unit =
    emit(s"\"${b64(value)}\"")

  override def beginObject(fieldCount: Int): Unit =
    lines += s"${buildPath()} = {};"
    nesting += new NestInfo(segments.size)

  override def writeField(name: String): Unit =
    val top = nesting.last
    if segments.size > top.depth then segments(segments.size - 1) = name
    else segments += name

  override def endObject(): Unit =
    val info = nesting.remove(nesting.size - 1)
    while segments.size > info.depth do segments.remove(segments.size - 1)

  override def beginArray(elementCount: Int): Unit =
    lines += s"${buildPath()} = [];"
    nesting += new NestInfo(segments.size, -1)

  override def nextElement(): Unit =
    val info = nesting.last
    info.arrayIndex += 1
    val seg = s"[${info.arrayIndex}]"
    if segments.size > info.depth then segments(segments.size - 1) = seg
    else segments += seg

  override def endArray(): Unit =
    val info = nesting.remove(nesting.size - 1)
    while segments.size > info.depth do segments.remove(segments.size - 1)

  override def writeEnum(value: String): Unit =
    emit(s"\"${escape(value)}\"")

  override def toBytes(): Array[Byte] =
    (lines.mkString("\n") + "\n").getBytes("UTF-8")
