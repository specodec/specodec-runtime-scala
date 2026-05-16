package specodec

trait SpecWriter {
  def writeString(value: String): Unit
  def writeBool(value: Boolean): Unit
  def writeInt32(value: Int): Unit
  def writeInt64(value: Long): Unit
  def writeUint32(value: Long): Unit
  def writeUint64(value: Long): Unit
  def writeFloat32(value: Float): Unit
  def writeFloat64(value: Double): Unit
  def writeNull(): Unit
  def writeBytes(value: Array[Byte]): Unit
  def writeEnum(value: String): Unit
  def beginObject(fieldCount: Int): Unit
  def writeField(name: String): Unit
  def endObject(): Unit
  def beginArray(elementCount: Int): Unit
  def nextElement(): Unit
  def endArray(): Unit
  def toBytes(): Array[Byte]
}
