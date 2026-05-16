package specodec

import scala.collection.mutable.StringBuilder

class JsonWriter extends SpecWriter:
  private val sb: StringBuilder = new StringBuilder()
  private val firstItem: scala.collection.mutable.ArrayBuffer[Boolean] =
    scala.collection.mutable.ArrayBuffer.empty

  private def escape(s: String): Unit =
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

  private def b64(buf: Array[Byte]): String =
    val chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/"
    val s = new StringBuilder()
    var i = 0
    while i < buf.length do
      val b0 = buf(i).toInt & 0xFF
      val b1 = if i + 1 < buf.length then buf(i + 1).toInt & 0xFF else 0
      val b2 = if i + 2 < buf.length then buf(i + 2).toInt & 0xFF else 0
      s.append(chars(b0 >> 2))
      s.append(chars(((b0 & 3) << 4) | (b1 >> 4)))
      s.append(if i + 1 < buf.length then chars(((b1 & 0xF) << 2) | (b2 >> 6)) else '=')
      s.append(if i + 2 < buf.length then chars(b2 & 0x3F) else '=')
      i += 3
    s.toString()

  override def writeString(value: String): Unit =
    sb.append('"')
    escape(value)
    sb.append('"')

  override def writeBool(value: Boolean): Unit =
    sb.append(if value then "true" else "false")

  override def writeInt32(value: Int): Unit =
    sb.append(value)

  override def writeInt64(value: Long): Unit =
    sb.append('"')
    sb.append(value)
    sb.append('"')

  override def writeUint32(value: Long): Unit =
    sb.append(value)

  override def writeUint64(value: Long): Unit =
    sb.append('"')
    sb.append(java.lang.Long.toUnsignedString(value))
    sb.append('"')

  override def writeFloat32(value: Float): Unit =
    if value.isNaN() then
      sb.append("\"NaN\"")
    else if value.isInfinite() then
      sb.append(if value > 0 then "\"Infinity\"" else "\"-Infinity\"")
    else
      sb.append(formatFloat32(value))

  override def writeFloat64(value: Double): Unit =
    if value.isNaN() then
      sb.append("\"NaN\"")
    else if value.isInfinite() then
      sb.append(if value > 0 then "\"Infinity\"" else "\"-Infinity\"")
    else
      sb.append(formatFloat64(value))

  override def writeNull(): Unit =
    sb.append("null")

  override def writeBytes(value: Array[Byte]): Unit =
    sb.append('"')
    sb.append(b64(value))
    sb.append('"')

  override def writeEnum(value: String): Unit =
    sb.append('"')
    escape(value)
    sb.append('"')

  override def beginObject(fieldCount: Int): Unit =
    sb.append('{')
    firstItem += true

  override def writeField(name: String): Unit =
    val top = firstItem.size - 1
    if !firstItem(top) then sb.append(',')
    firstItem(top) = false
    sb.append('"')
    escape(name)
    sb.append('"')
    sb.append(':')

  override def endObject(): Unit =
    firstItem.remove(firstItem.size - 1)
    sb.append('}')

  override def beginArray(elementCount: Int): Unit =
    sb.append('[')
    firstItem += true

  override def nextElement(): Unit =
    val top = firstItem.size - 1
    if !firstItem(top) then sb.append(',')
    firstItem(top) = false

  override def endArray(): Unit =
    firstItem.remove(firstItem.size - 1)
    sb.append(']')

  override def toBytes(): Array[Byte] = sb.toString().getBytes("UTF-8")
