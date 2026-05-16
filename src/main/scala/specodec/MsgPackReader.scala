package specodec

import scala.collection.mutable.ArrayBuffer

class MsgPackReader(private val data: Array[Byte]) extends SpecReader {
  private var pos: Int = 0
  private val containerCount: ArrayBuffer[Int] = ArrayBuffer.empty

  private def readByte(): Int = {
    if (pos >= data.length) throw new SCodecError("internal", "msgpack: unexpected end of data")
    val b = data(pos) & 0xFF
    pos += 1
    b
  }

  private def readU16(): Int = {
    val v = ((data(pos) & 0xFF) << 8) | (data(pos + 1) & 0xFF)
    pos += 2
    v
  }

  private def readU32(): Long = {
    val v = ((data(pos).toLong & 0xFF) << 24) | ((data(pos + 1).toLong & 0xFF) << 16) |
            ((data(pos + 2).toLong & 0xFF) << 8) | (data(pos + 3).toLong & 0xFF)
    pos += 4
    v
  }

  private def readI16(): Int = { val v = readU16(); if (v > 0x7FFF) v - 0x10000 else v }
  private def readI32(): Long = { val v = readU32(); if (v > 0x7FFFFFFF) v - 0x100000000L else v }

  private def readF32(): Float = java.lang.Float.intBitsToFloat(readU32().toInt)
  private def readF64(): Double = java.lang.Double.longBitsToDouble((readU32() << 32) | readU32())

  private def readMapHeader(): Int = {
    val b = readByte()
    if ((b & 0xF0) == 0x80) b & 0x0F
    else if (b == 0xDE) readU16()
    else if (b == 0xDF) readU32().toInt
    else throw new SCodecError("internal", f"msgpack: expected map, got 0x${b}%02X")
  }

  private def readArrayHeader(): Int = {
    val b = readByte()
    if ((b & 0xF0) == 0x90) b & 0x0F
    else if (b == 0xDC) readU16()
    else if (b == 0xDD) readU32().toInt
    else throw new SCodecError("internal", f"msgpack: expected array, got 0x${b}%02X")
  }

  private def readInt(): Long = {
    val b = readByte()
    if (b <= 0x7F) b.toLong
    else if (b >= 0xE0) (b - 0x100).toLong
    else b match {
      case 0xCC => readByte().toLong
      case 0xCD => readU16().toLong
      case 0xCE => readU32()
      case 0xCF => (readU32() << 32) | readU32()
      case 0xD0 => val v = data(pos).toInt; pos += 1; v.toLong
      case 0xD1 => readI16().toLong
      case 0xD2 => readI32()
      case 0xD3 => (readU32() << 32) | readU32()
      case _ => throw new SCodecError("internal", f"msgpack: expected int, got 0x${b}%02X")
    }
  }

  def readString(): String = {
    val b = readByte()
    val len = if ((b & 0xE0) == 0xA0) b & 0x1F
    else if (b == 0xD9) readByte()
    else if (b == 0xDA) readU16()
    else if (b == 0xDB) readU32().toInt
    else throw new SCodecError("internal", f"msgpack: expected string, got 0x${b}%02X")
    val s = new String(data, pos, len, "UTF-8")
    pos += len
    s
  }

  def readBool(): Boolean = {
    val b = readByte()
    if (b == 0xC3) true
    else if (b == 0xC2) false
    else throw new SCodecError("internal", f"msgpack: expected bool, got 0x${b}%02X")
  }

  def readInt32(): Int = readInt().toInt

  def readInt64(): Long = readInt()

  def readUint32(): Long = readInt() & 0xFFFFFFFFL

  def readUint64(): Long = {
    val b = readByte()
    if (b <= 0x7F) b.toLong
    else if (b == 0xCC) readByte().toLong
    else if (b == 0xCD) readU16().toLong
    else if (b == 0xCE) readU32()
    else if (b == 0xCF) (readU32() << 32) | readU32()
    else throw new SCodecError("internal", f"msgpack: expected uint64, got 0x${b}%02X")
  }

  private def readFloat(): Double = {
    val b = readByte()
    if (b == 0xCA) readF32().toDouble
    else if (b == 0xCB) readF64()
    else if (b <= 0x7F) b.toDouble
    else if (b >= 0xE0) (b - 0x100).toDouble
    else if (b == 0xCC) readByte().toDouble
    else if (b == 0xCD) readU16().toDouble
    else if (b == 0xCE) readU32().toDouble
    else if (b == 0xD0) { val v = data(pos).toInt; pos += 1; v.toDouble }
    else if (b == 0xD1) readI16().toDouble
    else if (b == 0xD2) readI32().toDouble
    else throw new SCodecError("internal", f"msgpack: expected float, got 0x${b}%02X")
  }

  def readFloat32(): Float = readFloat().toFloat
  def readFloat64(): Double = readFloat()

  def readBytes(): Array[Byte] = {
    val b = readByte()
    val len = b match {
      case 0xC4 => readByte()
      case 0xC5 => readU16()
      case 0xC6 => readU32().toInt
      case _ => throw new SCodecError("internal", f"msgpack: expected bin, got 0x${b}%02X")
    }
    val v = data.slice(pos, pos + len)
    pos += len
    v
  }

  def readEnum(): String = readString()

  def readNull(): Unit = {
    val b = readByte()
    if (b != 0xC0) throw new SCodecError("internal", f"msgpack: expected null, got 0x${b}%02X")
  }

  def isNull(): Boolean = pos < data.length && (data(pos) & 0xFF) == 0xC0

  def skip(): Unit = {
    val b = readByte()
    if (b <= 0x7F || b >= 0xE0) return
    if ((b & 0xF0) == 0x80) { val n = b & 0x0F; for (_ <- 0 until n) { skip(); skip() }; return }
    if ((b & 0xF0) == 0x90) { val n = b & 0x0F; for (_ <- 0 until n) skip(); return }
    if ((b & 0xE0) == 0xA0) { pos += b & 0x1F; return }
    b match {
      case 0xC0 | 0xC2 | 0xC3 => ()
      case 0xCC | 0xD0 => pos += 1
      case 0xCD | 0xD1 => pos += 2
      case 0xCE | 0xD2 | 0xCA => pos += 4
      case 0xCF | 0xD3 | 0xCB => pos += 8
      case 0xD9 => pos += readByte()
      case 0xDA => pos += readU16()
      case 0xDB => pos += readU32().toInt
      case 0xC4 => pos += readByte()
      case 0xC5 => pos += readU16()
      case 0xC6 => pos += readU32().toInt
      case 0xD4 => pos += 2
      case 0xD5 => pos += 3
      case 0xD6 => pos += 5
      case 0xD7 => pos += 9
      case 0xD8 => pos += 17
      case 0xC7 => val l = readByte(); pos += 1 + l
      case 0xC8 => val l = readU16(); pos += 1 + l
      case 0xC9 => val l = readU32().toInt; pos += 1 + l
      case 0xDC => val n = readU16(); for (_ <- 0 until n) skip()
      case 0xDD => val n = readU32().toInt; for (_ <- 0 until n) skip()
      case 0xDE => val n = readU16(); for (_ <- 0 until n) { skip(); skip() }
      case 0xDF => val n = readU32().toInt; for (_ <- 0 until n) { skip(); skip() }
      case _ => throw new SCodecError("internal", f"msgpack: unknown format 0x${b}%02X")
    }
  }

  // Container methods
  def beginObject(): Unit = { val n = readMapHeader(); containerCount += n }
  def hasNextField(): Boolean = {
    val top = containerCount.length - 1
    if (containerCount(top) > 0) { containerCount(top) -= 1; true }
    else { containerCount.remove(top); false }
  }
  def readFieldName(): String = readString()
  def endObject(): Unit = ()
  def beginArray(): Unit = { val n = readArrayHeader(); containerCount += n }
  def hasNextElement(): Boolean = {
    val top = containerCount.length - 1
    if (containerCount(top) > 0) { containerCount(top) -= 1; true }
    else { containerCount.remove(top); false }
  }
  def endArray(): Unit = ()
}
