package specodec

import scala.collection.mutable.{ArrayBuffer, StringBuilder}

class GronReader(data: Array[Byte]) extends SpecReader:
  private val lines: ArrayBuffer[(String, String)] = ArrayBuffer.empty
  private var cursor: Int = 0
  private val ctx: ArrayBuffer[CtxInfo] = ArrayBuffer.empty

  private class CtxInfo(val prefix: String, val ctype: String, var index: Int = -1)

  // constructor body
  for raw <- new String(data, "UTF-8").split("\n") do
    val line = raw.trim()
    if !line.isEmpty() then
      val eq = line.indexOf(" = ")
      if eq >= 0 then
        val path = line.substring(0, eq)
        var value = line.substring(eq + 3)
        if value.endsWith(";") then value = value.substring(0, value.length - 1)
        lines += ((path, value))

  private def unescape(s: String): String =
    if s.length < 2 || s(0) != '"' || s.last != '"' then
      throw SCodecError("internal", "gron: expected quoted string")
    val sb = new StringBuilder()
    var i = 1
    while i < s.length - 1 do
      if s(i) == '\\' then
        i += 1
        s(i) match
          case '"' => sb.append('"')
          case '\\' => sb.append('\\')
          case '/' => sb.append('/')
          case 'b' => sb.append('\b')
          case 'f' => sb.append('\u000C')
          case 'n' => sb.append('\n')
          case 'r' => sb.append('\r')
          case 't' => sb.append('\t')
          case 'u' =>
            sb.append(java.lang.Integer.parseInt(s.substring(i + 1, i + 5), 16).toChar) // JVM-only
            i += 4
          case _ => ()
      else
        sb.append(s(i))
      i += 1
    sb.toString()

  private def b64(s: String): Array[Byte] =
    val chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/"
    val padCount = s.reverseIterator.takeWhile(_ == '=').length
    val result = ArrayBuffer.empty[Byte]
    var i = 0
    while i < s.length && s(i) != '=' do
      val b0 = chars.indexOf(s(i)); i += 1
      val b1 = if i < s.length && s(i) != '=' then { val v = chars.indexOf(s(i)); i += 1; v } else 0
      val b2 = if i < s.length && s(i) != '=' then { val v = chars.indexOf(s(i)); i += 1; v } else 0
      val b3 = if i < s.length && s(i) != '=' then { val v = chars.indexOf(s(i)); i += 1; v } else 0
      result += ((b0 << 2) | (b1 >> 4)).toByte
      result += (((b1 & 0xF) << 4) | (b2 >> 2)).toByte
      result += (((b2 & 3) << 6) | b3).toByte
    result.dropRight(padCount).toArray

  override def readString(): String =
    val v = lines(cursor)._2
    cursor += 1
    unescape(v)

  override def readBool(): Boolean =
    val v = lines(cursor)._2
    cursor += 1
    v == "true"

  override def readInt32(): Int =
    val v = lines(cursor)._2
    cursor += 1
    v.toInt

  override def readInt64(): Long =
    val v = lines(cursor)._2
    cursor += 1
    unescape(v).toLong

  override def readUint32(): Long =
    val v = lines(cursor)._2
    cursor += 1
    try
      val x = v.toLong
      if x < 0 || x > 0xFFFFFFFFL then throw NumberFormatException()
      x
    catch case _: NumberFormatException => throw SCodecError("internal", s"gron: invalid uint32: $v")

  override def readUint64(): Long =
    val v = lines(cursor)._2
    cursor += 1
    try java.lang.Long.parseUnsignedLong(unescape(v))
    catch case _: NumberFormatException => throw SCodecError("internal", s"gron: invalid uint64: $v")

  override def readFloat32(): Float =
    val v = lines(cursor)._2
    cursor += 1
    if v == "\"NaN\"" then return Float.NaN
    if v == "\"Infinity\"" then return Float.PositiveInfinity
    if v == "\"-Infinity\"" then return Float.NegativeInfinity
    v.toFloat

  override def readFloat64(): Double =
    val v = lines(cursor)._2
    cursor += 1
    if v == "\"NaN\"" then return Double.NaN
    if v == "\"Infinity\"" then return Double.PositiveInfinity
    if v == "\"-Infinity\"" then return Double.NegativeInfinity
    v.toDouble

  override def readNull(): Unit =
    val v = lines(cursor)._2
    cursor += 1
    if v != "null" then throw SCodecError("internal", "gron: expected null")

  override def readBytes(): Array[Byte] =
    val v = lines(cursor)._2
    cursor += 1
    b64(unescape(v))

  override def readEnum(): String =
    val v = lines(cursor)._2
    cursor += 1
    unescape(v)

  override def beginObject(): Unit =
    val line = lines(cursor)
    cursor += 1
    ctx += new CtxInfo(line._1, "object")

  override def hasNextField(): Boolean =
    if cursor >= lines.size then return false
    val pfx = ctx.last.prefix + "."
    val p = lines(cursor)._1
    if !p.startsWith(pfx) then return false
    val rem = p.substring(pfx.length)
    !rem.contains(".") && !rem.contains("[")

  override def readFieldName(): String =
    val pfx = ctx.last.prefix + "."
    lines(cursor)._1.substring(pfx.length)

  override def endObject(): Unit =
    ctx.remove(ctx.size - 1)

  override def beginArray(): Unit =
    val line = lines(cursor)
    cursor += 1
    ctx += new CtxInfo(line._1, "array", -1)

  override def hasNextElement(): Boolean =
    if cursor >= lines.size then return false
    val arr = ctx.last
    val ni = arr.index + 1
    val exp = s"${arr.prefix}[$ni]"
    val p = lines(cursor)._1
    val hasNext = p == exp || p.startsWith(s"$exp.") || p.startsWith(s"$exp[")
    if hasNext then arr.index = ni
    hasNext

  override def endArray(): Unit =
    ctx.remove(ctx.size - 1)

  override def isNull(): Boolean =
    cursor < lines.size && lines(cursor)._2 == "null"

  override def skip(): Unit =
    val sp = lines(cursor)._1
    cursor += 1
    while cursor < lines.size do
      val np = lines(cursor)._1
      if np.length > sp.length && (np.startsWith(s"$sp.") || np.startsWith(s"$sp[")) then
        cursor += 1
      else return
