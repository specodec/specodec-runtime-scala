import specodec.*
import java.nio.file.{Files, Paths}

import AllTypes._
import AllTypesScalars._
import AllTypesOpt._
import AllTypesPairs._
import AllTypesMany._
import AllTypesArrays._
import AllTypesNests._
import AllTypesMixed._
import AllTypesRecursive._
import AllTypesWide._
import AllTypesEdge._
import AllTypesExtra._
import AllTypesNested._
import AllTypesNestedDeep._
import AllTypesEnums._
import AllTypesUnions._

def test_int8_min(vec: String, out: String): (Int, Int) = {
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "scalars/int8_min.mp"))
    val r = MsgPackReader(b)
    val v = r.readInt32()
    val w = MsgPackWriter()
    w.writeInt32(v)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "scalars/int8_min.mp"), w.toBytes())
    (1, 0)
  } catch { case e: Exception => println("FAIL int8_min mp: " + e.getMessage); (0, 1) }
}
def test_int8_max(vec: String, out: String): (Int, Int) = {
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "scalars/int8_max.mp"))
    val r = MsgPackReader(b)
    val v = r.readInt32()
    val w = MsgPackWriter()
    w.writeInt32(v)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "scalars/int8_max.mp"), w.toBytes())
    (1, 0)
  } catch { case e: Exception => println("FAIL int8_max mp: " + e.getMessage); (0, 1) }
}
def test_int16_min(vec: String, out: String): (Int, Int) = {
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "scalars/int16_min.mp"))
    val r = MsgPackReader(b)
    val v = r.readInt32()
    val w = MsgPackWriter()
    w.writeInt32(v)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "scalars/int16_min.mp"), w.toBytes())
    (1, 0)
  } catch { case e: Exception => println("FAIL int16_min mp: " + e.getMessage); (0, 1) }
}
def test_int16_max(vec: String, out: String): (Int, Int) = {
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "scalars/int16_max.mp"))
    val r = MsgPackReader(b)
    val v = r.readInt32()
    val w = MsgPackWriter()
    w.writeInt32(v)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "scalars/int16_max.mp"), w.toBytes())
    (1, 0)
  } catch { case e: Exception => println("FAIL int16_max mp: " + e.getMessage); (0, 1) }
}
def test_int32_min(vec: String, out: String): (Int, Int) = {
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "scalars/int32_min.mp"))
    val r = MsgPackReader(b)
    val v = r.readInt32()
    val w = MsgPackWriter()
    w.writeInt32(v)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "scalars/int32_min.mp"), w.toBytes())
    (1, 0)
  } catch { case e: Exception => println("FAIL int32_min mp: " + e.getMessage); (0, 1) }
}
def test_int32_max(vec: String, out: String): (Int, Int) = {
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "scalars/int32_max.mp"))
    val r = MsgPackReader(b)
    val v = r.readInt32()
    val w = MsgPackWriter()
    w.writeInt32(v)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "scalars/int32_max.mp"), w.toBytes())
    (1, 0)
  } catch { case e: Exception => println("FAIL int32_max mp: " + e.getMessage); (0, 1) }
}
def test_int64_min(vec: String, out: String): (Int, Int) = {
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "scalars/int64_min.mp"))
    val r = MsgPackReader(b)
    val v = r.readInt64()
    val w = MsgPackWriter()
    w.writeInt64(v)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "scalars/int64_min.mp"), w.toBytes())
    (1, 0)
  } catch { case e: Exception => println("FAIL int64_min mp: " + e.getMessage); (0, 1) }
}
def test_int64_max(vec: String, out: String): (Int, Int) = {
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "scalars/int64_max.mp"))
    val r = MsgPackReader(b)
    val v = r.readInt64()
    val w = MsgPackWriter()
    w.writeInt64(v)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "scalars/int64_max.mp"), w.toBytes())
    (1, 0)
  } catch { case e: Exception => println("FAIL int64_max mp: " + e.getMessage); (0, 1) }
}
def test_uint8_max(vec: String, out: String): (Int, Int) = {
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "scalars/uint8_max.mp"))
    val r = MsgPackReader(b)
    val v = r.readUint32()
    val w = MsgPackWriter()
    w.writeUint32(v)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "scalars/uint8_max.mp"), w.toBytes())
    (1, 0)
  } catch { case e: Exception => println("FAIL uint8_max mp: " + e.getMessage); (0, 1) }
}
def test_uint16_max(vec: String, out: String): (Int, Int) = {
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "scalars/uint16_max.mp"))
    val r = MsgPackReader(b)
    val v = r.readUint32()
    val w = MsgPackWriter()
    w.writeUint32(v)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "scalars/uint16_max.mp"), w.toBytes())
    (1, 0)
  } catch { case e: Exception => println("FAIL uint16_max mp: " + e.getMessage); (0, 1) }
}
def test_uint32_max(vec: String, out: String): (Int, Int) = {
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "scalars/uint32_max.mp"))
    val r = MsgPackReader(b)
    val v = r.readUint32()
    val w = MsgPackWriter()
    w.writeUint32(v)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "scalars/uint32_max.mp"), w.toBytes())
    (1, 0)
  } catch { case e: Exception => println("FAIL uint32_max mp: " + e.getMessage); (0, 1) }
}
def test_uint64_max(vec: String, out: String): (Int, Int) = {
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "scalars/uint64_max.mp"))
    val r = MsgPackReader(b)
    val v = r.readUint64()
    val w = MsgPackWriter()
    w.writeUint64(v)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "scalars/uint64_max.mp"), w.toBytes())
    (1, 0)
  } catch { case e: Exception => println("FAIL uint64_max mp: " + e.getMessage); (0, 1) }
}
def test_float32_1_5(vec: String, out: String): (Int, Int) = {
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "scalars/float32_1.5.mp"))
    val r = MsgPackReader(b)
    val v = r.readFloat32()
    val w = MsgPackWriter()
    w.writeFloat32(v)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "scalars/float32_1.5.mp"), w.toBytes())
    (1, 0)
  } catch { case e: Exception => println("FAIL float32_1.5 mp: " + e.getMessage); (0, 1) }
}
def test_float32_neg_zero(vec: String, out: String): (Int, Int) = {
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "scalars/float32_neg_zero.mp"))
    val r = MsgPackReader(b)
    val v = r.readFloat32()
    val w = MsgPackWriter()
    w.writeFloat32(v)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "scalars/float32_neg_zero.mp"), w.toBytes())
    (1, 0)
  } catch { case e: Exception => println("FAIL float32_neg_zero mp: " + e.getMessage); (0, 1) }
}
def test_float32_inf(vec: String, out: String): (Int, Int) = {
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "scalars/float32_inf.mp"))
    val r = MsgPackReader(b)
    val v = r.readFloat32()
    val w = MsgPackWriter()
    w.writeFloat32(v)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "scalars/float32_inf.mp"), w.toBytes())
    (1, 0)
  } catch { case e: Exception => println("FAIL float32_inf mp: " + e.getMessage); (0, 1) }
}
def test_float32_neg_inf(vec: String, out: String): (Int, Int) = {
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "scalars/float32_neg_inf.mp"))
    val r = MsgPackReader(b)
    val v = r.readFloat32()
    val w = MsgPackWriter()
    w.writeFloat32(v)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "scalars/float32_neg_inf.mp"), w.toBytes())
    (1, 0)
  } catch { case e: Exception => println("FAIL float32_neg_inf mp: " + e.getMessage); (0, 1) }
}
def test_float32_nan(vec: String, out: String): (Int, Int) = {
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "scalars/float32_nan.mp"))
    val r = MsgPackReader(b)
    val v = r.readFloat32()
    val w = MsgPackWriter()
    w.writeFloat32(v)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "scalars/float32_nan.mp"), w.toBytes())
    (1, 0)
  } catch { case e: Exception => println("FAIL float32_nan mp: " + e.getMessage); (0, 1) }
}
def test_float64_pi(vec: String, out: String): (Int, Int) = {
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "scalars/float64_pi.mp"))
    val r = MsgPackReader(b)
    val v = r.readFloat64()
    val w = MsgPackWriter()
    w.writeFloat64(v)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "scalars/float64_pi.mp"), w.toBytes())
    (1, 0)
  } catch { case e: Exception => println("FAIL float64_pi mp: " + e.getMessage); (0, 1) }
}
def test_float64_neg_zero(vec: String, out: String): (Int, Int) = {
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "scalars/float64_neg_zero.mp"))
    val r = MsgPackReader(b)
    val v = r.readFloat64()
    val w = MsgPackWriter()
    w.writeFloat64(v)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "scalars/float64_neg_zero.mp"), w.toBytes())
    (1, 0)
  } catch { case e: Exception => println("FAIL float64_neg_zero mp: " + e.getMessage); (0, 1) }
}
def test_float64_inf(vec: String, out: String): (Int, Int) = {
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "scalars/float64_inf.mp"))
    val r = MsgPackReader(b)
    val v = r.readFloat64()
    val w = MsgPackWriter()
    w.writeFloat64(v)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "scalars/float64_inf.mp"), w.toBytes())
    (1, 0)
  } catch { case e: Exception => println("FAIL float64_inf mp: " + e.getMessage); (0, 1) }
}
def test_float64_neg_inf(vec: String, out: String): (Int, Int) = {
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "scalars/float64_neg_inf.mp"))
    val r = MsgPackReader(b)
    val v = r.readFloat64()
    val w = MsgPackWriter()
    w.writeFloat64(v)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "scalars/float64_neg_inf.mp"), w.toBytes())
    (1, 0)
  } catch { case e: Exception => println("FAIL float64_neg_inf mp: " + e.getMessage); (0, 1) }
}
def test_float64_nan(vec: String, out: String): (Int, Int) = {
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "scalars/float64_nan.mp"))
    val r = MsgPackReader(b)
    val v = r.readFloat64()
    val w = MsgPackWriter()
    w.writeFloat64(v)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "scalars/float64_nan.mp"), w.toBytes())
    (1, 0)
  } catch { case e: Exception => println("FAIL float64_nan mp: " + e.getMessage); (0, 1) }
}
def test_str_empty(vec: String, out: String): (Int, Int) = {
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "scalars/str_empty.mp"))
    val r = MsgPackReader(b)
    val v = r.readString()
    val w = MsgPackWriter()
    w.writeString(v)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "scalars/str_empty.mp"), w.toBytes())
    (1, 0)
  } catch { case e: Exception => println("FAIL str_empty mp: " + e.getMessage); (0, 1) }
}
def test_str_ascii(vec: String, out: String): (Int, Int) = {
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "scalars/str_ascii.mp"))
    val r = MsgPackReader(b)
    val v = r.readString()
    val w = MsgPackWriter()
    w.writeString(v)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "scalars/str_ascii.mp"), w.toBytes())
    (1, 0)
  } catch { case e: Exception => println("FAIL str_ascii mp: " + e.getMessage); (0, 1) }
}
def test_str_null_byte(vec: String, out: String): (Int, Int) = {
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "scalars/str_null_byte.mp"))
    val r = MsgPackReader(b)
    val v = r.readString()
    val w = MsgPackWriter()
    w.writeString(v)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "scalars/str_null_byte.mp"), w.toBytes())
    (1, 0)
  } catch { case e: Exception => println("FAIL str_null_byte mp: " + e.getMessage); (0, 1) }
}
def test_str_escape(vec: String, out: String): (Int, Int) = {
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "scalars/str_escape.mp"))
    val r = MsgPackReader(b)
    val v = r.readString()
    val w = MsgPackWriter()
    w.writeString(v)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "scalars/str_escape.mp"), w.toBytes())
    (1, 0)
  } catch { case e: Exception => println("FAIL str_escape mp: " + e.getMessage); (0, 1) }
}
def test_str_unicode(vec: String, out: String): (Int, Int) = {
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "scalars/str_unicode.mp"))
    val r = MsgPackReader(b)
    val v = r.readString()
    val w = MsgPackWriter()
    w.writeString(v)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "scalars/str_unicode.mp"), w.toBytes())
    (1, 0)
  } catch { case e: Exception => println("FAIL str_unicode mp: " + e.getMessage); (0, 1) }
}
def test_str_31(vec: String, out: String): (Int, Int) = {
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "scalars/str_31.mp"))
    val r = MsgPackReader(b)
    val v = r.readString()
    val w = MsgPackWriter()
    w.writeString(v)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "scalars/str_31.mp"), w.toBytes())
    (1, 0)
  } catch { case e: Exception => println("FAIL str_31 mp: " + e.getMessage); (0, 1) }
}
def test_str_32(vec: String, out: String): (Int, Int) = {
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "scalars/str_32.mp"))
    val r = MsgPackReader(b)
    val v = r.readString()
    val w = MsgPackWriter()
    w.writeString(v)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "scalars/str_32.mp"), w.toBytes())
    (1, 0)
  } catch { case e: Exception => println("FAIL str_32 mp: " + e.getMessage); (0, 1) }
}
def test_str_255(vec: String, out: String): (Int, Int) = {
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "scalars/str_255.mp"))
    val r = MsgPackReader(b)
    val v = r.readString()
    val w = MsgPackWriter()
    w.writeString(v)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "scalars/str_255.mp"), w.toBytes())
    (1, 0)
  } catch { case e: Exception => println("FAIL str_255 mp: " + e.getMessage); (0, 1) }
}
def test_str_256(vec: String, out: String): (Int, Int) = {
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "scalars/str_256.mp"))
    val r = MsgPackReader(b)
    val v = r.readString()
    val w = MsgPackWriter()
    w.writeString(v)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "scalars/str_256.mp"), w.toBytes())
    (1, 0)
  } catch { case e: Exception => println("FAIL str_256 mp: " + e.getMessage); (0, 1) }
}
def test_bytes_empty(vec: String, out: String): (Int, Int) = {
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "scalars/bytes_empty.mp"))
    val r = MsgPackReader(b)
    val v = r.readBytes()
    val w = MsgPackWriter()
    w.writeBytes(v)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "scalars/bytes_empty.mp"), w.toBytes())
    (1, 0)
  } catch { case e: Exception => println("FAIL bytes_empty mp: " + e.getMessage); (0, 1) }
}
def test_bytes_small(vec: String, out: String): (Int, Int) = {
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "scalars/bytes_small.mp"))
    val r = MsgPackReader(b)
    val v = r.readBytes()
    val w = MsgPackWriter()
    w.writeBytes(v)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "scalars/bytes_small.mp"), w.toBytes())
    (1, 0)
  } catch { case e: Exception => println("FAIL bytes_small mp: " + e.getMessage); (0, 1) }
}
def test_bytes_31(vec: String, out: String): (Int, Int) = {
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "scalars/bytes_31.mp"))
    val r = MsgPackReader(b)
    val v = r.readBytes()
    val w = MsgPackWriter()
    w.writeBytes(v)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "scalars/bytes_31.mp"), w.toBytes())
    (1, 0)
  } catch { case e: Exception => println("FAIL bytes_31 mp: " + e.getMessage); (0, 1) }
}
def test_bytes_32(vec: String, out: String): (Int, Int) = {
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "scalars/bytes_32.mp"))
    val r = MsgPackReader(b)
    val v = r.readBytes()
    val w = MsgPackWriter()
    w.writeBytes(v)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "scalars/bytes_32.mp"), w.toBytes())
    (1, 0)
  } catch { case e: Exception => println("FAIL bytes_32 mp: " + e.getMessage); (0, 1) }
}
def test_bytes_255(vec: String, out: String): (Int, Int) = {
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "scalars/bytes_255.mp"))
    val r = MsgPackReader(b)
    val v = r.readBytes()
    val w = MsgPackWriter()
    w.writeBytes(v)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "scalars/bytes_255.mp"), w.toBytes())
    (1, 0)
  } catch { case e: Exception => println("FAIL bytes_255 mp: " + e.getMessage); (0, 1) }
}
def test_bytes_256(vec: String, out: String): (Int, Int) = {
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "scalars/bytes_256.mp"))
    val r = MsgPackReader(b)
    val v = r.readBytes()
    val w = MsgPackWriter()
    w.writeBytes(v)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "scalars/bytes_256.mp"), w.toBytes())
    (1, 0)
  } catch { case e: Exception => println("FAIL bytes_256 mp: " + e.getMessage); (0, 1) }
}
def test_bytes_zeros(vec: String, out: String): (Int, Int) = {
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "scalars/bytes_zeros.mp"))
    val r = MsgPackReader(b)
    val v = r.readBytes()
    val w = MsgPackWriter()
    w.writeBytes(v)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "scalars/bytes_zeros.mp"), w.toBytes())
    (1, 0)
  } catch { case e: Exception => println("FAIL bytes_zeros mp: " + e.getMessage); (0, 1) }
}
def test_bytes_ff(vec: String, out: String): (Int, Int) = {
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "scalars/bytes_ff.mp"))
    val r = MsgPackReader(b)
    val v = r.readBytes()
    val w = MsgPackWriter()
    w.writeBytes(v)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "scalars/bytes_ff.mp"), w.toBytes())
    (1, 0)
  } catch { case e: Exception => println("FAIL bytes_ff mp: " + e.getMessage); (0, 1) }
}
def test_bool_true(vec: String, out: String): (Int, Int) = {
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "scalars/bool_true.mp"))
    val r = MsgPackReader(b)
    val v = r.readBool()
    val w = MsgPackWriter()
    w.writeBool(v)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "scalars/bool_true.mp"), w.toBytes())
    (1, 0)
  } catch { case e: Exception => println("FAIL bool_true mp: " + e.getMessage); (0, 1) }
}
def test_bool_false(vec: String, out: String): (Int, Int) = {
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "scalars/bool_false.mp"))
    val r = MsgPackReader(b)
    val v = r.readBool()
    val w = MsgPackWriter()
    w.writeBool(v)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "scalars/bool_false.mp"), w.toBytes())
    (1, 0)
  } catch { case e: Exception => println("FAIL bool_false mp: " + e.getMessage); (0, 1) }
}
def run_scalars(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  Files.createDirectories(Paths.get(out))
  Files.createDirectories(Paths.get(out, "scalars"))
  { val r = test_int8_min(vec, out); passed += r._1; failed += r._2 }
  { val r = test_int8_max(vec, out); passed += r._1; failed += r._2 }
  { val r = test_int16_min(vec, out); passed += r._1; failed += r._2 }
  { val r = test_int16_max(vec, out); passed += r._1; failed += r._2 }
  { val r = test_int32_min(vec, out); passed += r._1; failed += r._2 }
  { val r = test_int32_max(vec, out); passed += r._1; failed += r._2 }
  { val r = test_int64_min(vec, out); passed += r._1; failed += r._2 }
  { val r = test_int64_max(vec, out); passed += r._1; failed += r._2 }
  { val r = test_uint8_max(vec, out); passed += r._1; failed += r._2 }
  { val r = test_uint16_max(vec, out); passed += r._1; failed += r._2 }
  { val r = test_uint32_max(vec, out); passed += r._1; failed += r._2 }
  { val r = test_uint64_max(vec, out); passed += r._1; failed += r._2 }
  { val r = test_float32_1_5(vec, out); passed += r._1; failed += r._2 }
  { val r = test_float32_neg_zero(vec, out); passed += r._1; failed += r._2 }
  { val r = test_float32_inf(vec, out); passed += r._1; failed += r._2 }
  { val r = test_float32_neg_inf(vec, out); passed += r._1; failed += r._2 }
  { val r = test_float32_nan(vec, out); passed += r._1; failed += r._2 }
  { val r = test_float64_pi(vec, out); passed += r._1; failed += r._2 }
  { val r = test_float64_neg_zero(vec, out); passed += r._1; failed += r._2 }
  { val r = test_float64_inf(vec, out); passed += r._1; failed += r._2 }
  { val r = test_float64_neg_inf(vec, out); passed += r._1; failed += r._2 }
  { val r = test_float64_nan(vec, out); passed += r._1; failed += r._2 }
  { val r = test_str_empty(vec, out); passed += r._1; failed += r._2 }
  { val r = test_str_ascii(vec, out); passed += r._1; failed += r._2 }
  { val r = test_str_null_byte(vec, out); passed += r._1; failed += r._2 }
  { val r = test_str_escape(vec, out); passed += r._1; failed += r._2 }
  { val r = test_str_unicode(vec, out); passed += r._1; failed += r._2 }
  { val r = test_str_31(vec, out); passed += r._1; failed += r._2 }
  { val r = test_str_32(vec, out); passed += r._1; failed += r._2 }
  { val r = test_str_255(vec, out); passed += r._1; failed += r._2 }
  { val r = test_str_256(vec, out); passed += r._1; failed += r._2 }
  { val r = test_bytes_empty(vec, out); passed += r._1; failed += r._2 }
  { val r = test_bytes_small(vec, out); passed += r._1; failed += r._2 }
  { val r = test_bytes_31(vec, out); passed += r._1; failed += r._2 }
  { val r = test_bytes_32(vec, out); passed += r._1; failed += r._2 }
  { val r = test_bytes_255(vec, out); passed += r._1; failed += r._2 }
  { val r = test_bytes_256(vec, out); passed += r._1; failed += r._2 }
  { val r = test_bytes_zeros(vec, out); passed += r._1; failed += r._2 }
  { val r = test_bytes_ff(vec, out); passed += r._1; failed += r._2 }
  { val r = test_bool_true(vec, out); passed += r._1; failed += r._2 }
  { val r = test_bool_false(vec, out); passed += r._1; failed += r._2 }
  (passed, failed)
}
