package specodec

import scala.collection.mutable.{ArrayBuffer, StringBuilder}


// SCodecError is defined in SpecCodec.scala

class JsonReader(data: Array[Byte]) extends SpecReader:
  private val src: String = new String(data, "UTF-8")
  private var pos: Int = 0
  private val _firstField: ArrayBuffer[Boolean] = ArrayBuffer.empty
  private val _firstElem: ArrayBuffer[Boolean] = ArrayBuffer.empty


  private def ws(): Unit =
    while pos < src.length do
      val c = src(pos).toInt
      if c == 0x20 || c == 0x09 || c == 0x0A || c == 0x0D then pos += 1
      else return

  private def peek(): Char =
    ws()
    if pos >= src.length then throw SCodecError("internal", "json: unexpected end of input")
    src(pos)

  private def read(): Char =
    ws()
    if pos >= src.length then throw SCodecError("internal", "json: unexpected end of input")
    val c = src(pos)
    pos += 1
    c

  private def expect(ch: Char): Unit =
    val got = read()
    if got != ch then throw SCodecError("internal", s"json: expected '$ch', got '$got' at ${pos - 1}")

  private def parseString(): String =
    expect('"')
    val parts = new StringBuilder()
    while pos < src.length do
      val c = src(pos)
      val code = c.toInt
      if code == 0x22 then
        pos += 1
        return parts.toString()
      if code == 0x5C then
        pos += 1
        if pos >= src.length then throw SCodecError("internal", "json: unexpected end of string escape")
        val esc = src(pos)
        esc.toInt match
          case 0x22 => parts.append('"'); pos += 1
          case 0x5C => parts.append('\\'); pos += 1
          case 0x2F => parts.append('/'); pos += 1
          case 0x62 => parts.append('\b'); pos += 1
          case 0x66 => parts.append('\u000C'); pos += 1
          case 0x6E => parts.append('\n'); pos += 1
          case 0x72 => parts.append('\r'); pos += 1
          case 0x74 => parts.append('\t'); pos += 1
          case 0x75 =>
            pos += 1
            if pos + 4 > src.length then throw SCodecError("internal", "json: incomplete unicode escape")
            val hex = src.substring(pos, pos + 4)
            var cp = java.lang.Integer.parseInt(hex, 16) // JVM-only: override for Scala.js/Native
            pos += 4
            if cp >= 0xD800 && cp <= 0xDBFF then
              if pos + 6 <= src.length && src(pos) == '\\' && src(pos + 1) == 'u' then
                pos += 2
                val hex2 = src.substring(pos, pos + 4)
                val low = java.lang.Integer.parseInt(hex2, 16) // JVM-only: override for Scala.js/Native
                pos += 4
                if low >= 0xDC00 && low <= 0xDFFF then
                  cp = 0x10000 + (cp - 0xD800) * 0x400 + (low - 0xDC00)
                else
                  throw SCodecError("internal", "json: expected low surrogate")
              else
                throw SCodecError("internal", "json: expected low surrogate")
            parts.append(cp.toChar)
          case _ => throw SCodecError("internal", s"json: invalid escape '\\$esc'")
      else if code < 0x20 then
        val hs = java.lang.Integer.toHexString(code) // JVM-only: override for Scala.js/Native
        throw SCodecError("internal", s"json: unescaped control char U+${"0000".substring(hs.length)}$hs")
      else
        parts.append(c)
        pos += 1
    throw SCodecError("internal", "json: unterminated string")

  private def parseNumberRaw(): String =
    ws()
    val start = pos
    if pos < src.length && src(pos) == '-' then pos += 1
    if pos >= src.length then throw SCodecError("internal", "json: unexpected end of number")
    if src(pos) == '0' then
      pos += 1
    else if src(pos) >= '1' && src(pos) <= '9' then
      pos += 1
      while pos < src.length && src(pos) >= '0' && src(pos) <= '9' do pos += 1
    else throw SCodecError("internal", "json: invalid number")
    if pos < src.length && src(pos) == '.' then
      pos += 1
      if pos >= src.length || src(pos) < '0' || src(pos) > '9' then
        throw SCodecError("internal", "json: invalid fraction")
      while pos < src.length && src(pos) >= '0' && src(pos) <= '9' do pos += 1
    if pos < src.length && (src(pos) == 'e' || src(pos) == 'E') then
      pos += 1
      if pos < src.length && (src(pos) == '+' || src(pos) == '-') then pos += 1
      if pos >= src.length || src(pos) < '0' || src(pos) > '9' then
        throw SCodecError("internal", "json: invalid exponent")
      while pos < src.length && src(pos) >= '0' && src(pos) <= '9' do pos += 1
    src.substring(start, pos)

  override def readString(): String = parseString()

  override def readBool(): Boolean =
    val ch = peek()
    if ch == 't' then
      for c <- "true" do
        if read() != c then throw SCodecError("internal", "json: expected true")
      return true
    if ch == 'f' then
      for c <- "false" do
        if read() != c then throw SCodecError("internal", "json: expected false")
      return false
    throw SCodecError("internal", s"json: expected bool, got '$ch'")

  override def readInt32(): Int =
    val raw = parseNumberRaw()
    try raw.toInt
    catch case _: NumberFormatException => throw SCodecError("internal", s"json: invalid int32: $raw")

  override def readInt64(): Long =
    if peek() == '"' then
      val s = parseString()
      try s.toLong
      catch case _: NumberFormatException => throw SCodecError("internal", s"json: invalid int64: $s")
    else
      val raw = parseNumberRaw()
      try raw.toLong
      catch case _: NumberFormatException => throw SCodecError("internal", s"json: invalid int64: $raw")

  override def readUint32(): Long =
    val raw = parseNumberRaw()
    try
      val v = raw.toLong
      if v < 0 || v > 0xFFFFFFFFL then throw NumberFormatException()
      v
    catch case _: NumberFormatException => throw SCodecError("internal", s"json: invalid uint32: $raw")

  override def readUint64(): Long =
    if peek() == '"' then
      val s = parseString()
      try java.lang.Long.parseUnsignedLong(s)
      catch case _: NumberFormatException => throw SCodecError("internal", s"json: invalid uint64: $s")
    else
      val raw = parseNumberRaw()
      try java.lang.Long.parseUnsignedLong(raw)
      catch case _: NumberFormatException => throw SCodecError("internal", s"json: invalid uint64: $raw")

  override def readFloat32(): Float =
    if peek() == '"' then
      val s = parseString()
      if s == "NaN" then return Float.NaN
      if s == "Infinity" then return Float.PositiveInfinity
      if s == "-Infinity" then return Float.NegativeInfinity
      try s.toFloat
      catch case _: NumberFormatException => throw SCodecError("internal", s"json: invalid float32: $s")
    else
      val raw = parseNumberRaw()
      try raw.toFloat
      catch case _: NumberFormatException => throw SCodecError("internal", s"json: invalid float32: $raw")

  override def readFloat64(): Double =
    if peek() == '"' then
      val s = parseString()
      if s == "NaN" then return Double.NaN
      if s == "Infinity" then return Double.PositiveInfinity
      if s == "-Infinity" then return Double.NegativeInfinity
      try s.toDouble
      catch case _: NumberFormatException => throw SCodecError("internal", s"json: invalid float64: $s")
    else
      val raw = parseNumberRaw()
      try raw.toDouble
      catch case _: NumberFormatException => throw SCodecError("internal", s"json: invalid float64: $raw")

  override def readNull(): Unit =
    for c <- "null" do
      if read() != c then throw SCodecError("internal", "json: expected null")

  override def readBytes(): Array[Byte] =
    val s = parseString()
    val lookup = new Array[Int](128)
    for i <- 0 until 128 do lookup(i) = -1
    "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".zipWithIndex.foreach: (c, i) =>
      lookup(c.toInt) = i
    val builder = Array.newBuilder[Byte]
    var i = 0
    while i < s.length do
      val a = lookup(s(i).toInt)
      val b = lookup(s(i + 1).toInt)
      val c = if s(i + 2) == '=' then -1 else lookup(s(i + 2).toInt)
      val d = if s(i + 3) == '=' then -1 else lookup(s(i + 3).toInt)
      if a < 0 || b < 0 then throw SCodecError("internal", "json: invalid base64")
      builder += ((a << 2) | (b >> 4)).toByte
      if c >= 0 then
        builder += (((b & 0xF) << 4) | (c >> 2)).toByte
        if d >= 0 then
          builder += (((c & 0x3) << 6) | d).toByte
      i += 4
    builder.result()

  override def readEnum(): String = parseString()

  override def beginObject(): Unit =
    expect('{')
    _firstField += true

  override def hasNextField(): Boolean =
    val ch = peek()
    if ch == '}' then
      _firstField.remove(_firstField.size - 1)
      return false
    val top = _firstField.size - 1
    if !_firstField(top) then
      if ch != ',' then throw SCodecError("internal", s"json: expected ',' or '}', got '$ch'")
      pos += 1
    else
      _firstField(top) = false
    true

  override def readFieldName(): String =
    val key = parseString()
    ws()
    if pos < src.length && src(pos) == ':' then
      pos += 1
    else
      throw SCodecError("internal", s"json: expected ':' after field name '$key'")
    key

  override def endObject(): Unit = expect('}')

  override def beginArray(): Unit =
    expect('[')
    _firstElem += true

  override def hasNextElement(): Boolean =
    val ch = peek()
    if ch == ']' then
      _firstElem.remove(_firstElem.size - 1)
      return false
    val top = _firstElem.size - 1
    if !_firstElem(top) then
      if ch != ',' then throw SCodecError("internal", s"json: expected ',' or ']', got '$ch'")
      pos += 1
    else
      _firstElem(top) = false
    true

  override def endArray(): Unit = expect(']')

  override def isNull(): Boolean = peek() == 'n'

  override def skip(): Unit =
    ws()
    if pos >= src.length then throw SCodecError("internal", "json: unexpected end of input")
    val ch = src(pos)
    ch match
      case '"' =>
        pos += 1
        while pos < src.length do
          if src(pos) == '\\' then pos += 2
          else if src(pos) == '"' then
            pos += 1
            return
          else pos += 1
        throw SCodecError("internal", "json: unterminated string in skip")
      case '{' =>
        beginObject()
        while hasNextField() do
          readFieldName()
          skip()
        endObject()
      case '[' =>
        beginArray()
        while hasNextElement() do skip()
        endArray()
      case 't' =>
        for c <- "true" do
          if read() != c then throw SCodecError("internal", "json: skip expected true")
      case 'f' =>
        for c <- "false" do
          if read() != c then throw SCodecError("internal", "json: skip expected false")
      case 'n' =>
        for c <- "null" do
          if read() != c then throw SCodecError("internal", "json: skip expected null")
      case _ =>
        if (ch >= '0' && ch <= '9') || ch == '-' then parseNumberRaw()
        else throw SCodecError("internal", s"json: unexpected '$ch' in skip")
