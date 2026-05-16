package specodec

import scala.collection.mutable.ArrayBuffer

class MsgPackWriter extends SpecWriter {
  private val buf: ArrayBuffer[Byte] = ArrayBuffer.empty

  private def w8(b: Int): Unit = buf += (b & 0xFF).toByte
  private def w16(v: Int): Unit = { buf += ((v >> 8) & 0xFF).toByte; buf += (v & 0xFF).toByte }
  private def w32(v: Long): Unit = {
    buf += ((v >> 24) & 0xFF).toByte; buf += ((v >> 16) & 0xFF).toByte
    buf += ((v >> 8) & 0xFF).toByte; buf += (v & 0xFF).toByte
  }
  private def w64(hi: Long, lo: Long): Unit = { w32(hi); w32(lo) }

  def writeString(value: String): Unit = {
    val encoded = value.getBytes("UTF-8")
    val len = encoded.length
    if (len <= 0x1F) w8(0xA0 | len)
    else if (len <= 0xFF) { w8(0xD9); w8(len) }
    else if (len <= 0xFFFF) { w8(0xDA); w16(len) }
    else { w8(0xDB); w32(len.toLong) }
    buf ++= encoded
  }

  def writeBool(value: Boolean): Unit = w8(if (value) 0xC3 else 0xC2)

  def writeInt32(value: Int): Unit = {
    if (value >= 0 && value <= 0x7F) w8(value)
    else if (value >= -0x20 && value < 0) w8(value & 0xFF)
    else if (value >= 0 && value <= 0xFF) { w8(0xCC); w8(value) }
    else if (value >= 0 && value <= 0xFFFF) { w8(0xCD); w16(value) }
    else if (value >= 0) { w8(0xCE); w32(value.toLong & 0xFFFFFFFFL) }
    else if (value >= -0x80) { w8(0xD0); w8(value & 0xFF) }
    else if (value >= -0x8000) { w8(0xD1); w16(value & 0xFFFF) }
    else { w8(0xD2); w32(value.toLong & 0xFFFFFFFFL) }
  }

  def writeInt64(value: Long): Unit = {
    if (value >= 0 && value <= 0x7F) w8(value.toInt)
    else if (value >= -0x20 && value < 0) w8(value.toInt & 0xFF)
    else if (value >= 0 && value <= 0xFF) { w8(0xCC); w8(value.toInt) }
    else if (value >= 0 && value <= 0xFFFF) { w8(0xCD); w16(value.toInt) }
    else if (value >= 0 && value <= 0xFFFFFFFFL) { w8(0xCE); w32(value) }
    else if (value >= 0) { w8(0xCF); w64((value >> 32) & 0xFFFFFFFFL, value & 0xFFFFFFFFL) }
    else if (value >= -0x80) { w8(0xD0); w8(value.toInt & 0xFF) }
    else if (value >= -0x8000) { w8(0xD1); w16(value.toInt & 0xFFFF) }
    else if (value >= -0x80000000L) { w8(0xD2); w32(value & 0xFFFFFFFFL) }
    else { w8(0xD3); w64((value >> 32) & 0xFFFFFFFFL, value & 0xFFFFFFFFL) }
  }

  def writeUint32(value: Long): Unit = {
    if (value <= 0x7F) w8(value.toInt)
    else if (value <= 0xFF) { w8(0xCC); w8(value.toInt) }
    else if (value <= 0xFFFF) { w8(0xCD); w16(value.toInt) }
    else { w8(0xCE); w32(value) }
  }

  def writeUint64(value: Long): Unit = {
    if (java.lang.Long.compareUnsigned(value, 0x7FL) <= 0) w8(value.toInt)
    else if (java.lang.Long.compareUnsigned(value, 0xFFL) <= 0) { w8(0xCC); w8(value.toInt) }
    else if (java.lang.Long.compareUnsigned(value, 0xFFFFL) <= 0) { w8(0xCD); w16(value.toInt) }
    else if (java.lang.Long.compareUnsigned(value, 0xFFFFFFFFL) <= 0) { w8(0xCE); w32(value) }
    else {
      w8(0xCF)
      val hi = (value >>> 32) & 0xFFFFFFFFL
      val lo = value & 0xFFFFFFFFL
      w64(hi, lo)
    }
  }

  def writeFloat32(value: Float): Unit = {
    w8(0xCA)
    val bits = java.lang.Float.floatToRawIntBits(value)
    w32(bits.toLong & 0xFFFFFFFFL)
  }

  def writeFloat64(value: Double): Unit = {
    w8(0xCB)
    val bits = java.lang.Double.doubleToRawLongBits(value)
    w64((bits >> 32) & 0xFFFFFFFFL, bits & 0xFFFFFFFFL)
  }

  def writeNull(): Unit = w8(0xC0)

  def writeBytes(value: Array[Byte]): Unit = {
    val len = value.length
    if (len <= 0xFF) { w8(0xC4); w8(len) }
    else if (len <= 0xFFFF) { w8(0xC5); w16(len) }
    else { w8(0xC6); w32(len.toLong) }
    buf ++= value
  }

  def writeEnum(value: String): Unit = writeString(value)

  def beginObject(fieldCount: Int): Unit = {
    if (fieldCount <= 0x0F) w8(0x80 | fieldCount)
    else if (fieldCount <= 0xFFFF) { w8(0xDE); w16(fieldCount) }
    else { w8(0xDF); w32(fieldCount.toLong) }
  }

  def writeField(name: String): Unit = writeString(name)
  def endObject(): Unit = ()

  def beginArray(elementCount: Int): Unit = {
    if (elementCount <= 0x0F) w8(0x90 | elementCount)
    else if (elementCount <= 0xFFFF) { w8(0xDC); w16(elementCount) }
    else { w8(0xDD); w32(elementCount.toLong) }
  }

  def nextElement(): Unit = ()
  def endArray(): Unit = ()

  def toBytes(): Array[Byte] = buf.toArray
}
