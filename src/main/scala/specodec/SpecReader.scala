package specodec

trait SpecReader {
  def beginObject(): Unit
  def hasNextField(): Boolean
  def readFieldName(): String
  def endObject(): Unit
  def beginArray(): Unit
  def hasNextElement(): Boolean
  def endArray(): Unit
  def readString(): String
  def readBool(): Boolean
  def readInt32(): Int
  def readInt64(): Long
  def readUint32(): Long
  def readUint64(): Long
  def readFloat32(): Float
  def readFloat64(): Double
  def readNull(): Unit
  def readBytes(): Array[Byte]
  def readEnum(): String
  def isNull(): Boolean
  def skip(): Unit
}
