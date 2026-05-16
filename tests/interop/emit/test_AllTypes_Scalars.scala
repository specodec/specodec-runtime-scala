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

def test_single_string(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "SingleString.msgpack"))
    val obj = SingleStringCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    SingleStringCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "SingleString.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL SingleString mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "SingleString.json"))
    val obj = SingleStringCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    SingleStringCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "SingleString.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL SingleString json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "SingleString.unformatted.json"))
    val obj = SingleStringCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    SingleStringCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "SingleString.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL SingleString unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "SingleString.gron"))
    val obj = SingleStringCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    SingleStringCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "SingleString.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL SingleString gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_single_boolean(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "SingleBoolean.msgpack"))
    val obj = SingleBooleanCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    SingleBooleanCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "SingleBoolean.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL SingleBoolean mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "SingleBoolean.json"))
    val obj = SingleBooleanCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    SingleBooleanCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "SingleBoolean.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL SingleBoolean json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "SingleBoolean.unformatted.json"))
    val obj = SingleBooleanCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    SingleBooleanCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "SingleBoolean.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL SingleBoolean unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "SingleBoolean.gron"))
    val obj = SingleBooleanCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    SingleBooleanCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "SingleBoolean.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL SingleBoolean gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_single_int8(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "SingleInt8.msgpack"))
    val obj = SingleInt8Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    SingleInt8Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "SingleInt8.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL SingleInt8 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "SingleInt8.json"))
    val obj = SingleInt8Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    SingleInt8Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "SingleInt8.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL SingleInt8 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "SingleInt8.unformatted.json"))
    val obj = SingleInt8Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    SingleInt8Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "SingleInt8.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL SingleInt8 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "SingleInt8.gron"))
    val obj = SingleInt8Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    SingleInt8Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "SingleInt8.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL SingleInt8 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_single_int16(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "SingleInt16.msgpack"))
    val obj = SingleInt16Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    SingleInt16Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "SingleInt16.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL SingleInt16 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "SingleInt16.json"))
    val obj = SingleInt16Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    SingleInt16Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "SingleInt16.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL SingleInt16 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "SingleInt16.unformatted.json"))
    val obj = SingleInt16Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    SingleInt16Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "SingleInt16.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL SingleInt16 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "SingleInt16.gron"))
    val obj = SingleInt16Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    SingleInt16Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "SingleInt16.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL SingleInt16 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_single_int32(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "SingleInt32.msgpack"))
    val obj = SingleInt32Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    SingleInt32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "SingleInt32.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL SingleInt32 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "SingleInt32.json"))
    val obj = SingleInt32Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    SingleInt32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "SingleInt32.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL SingleInt32 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "SingleInt32.unformatted.json"))
    val obj = SingleInt32Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    SingleInt32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "SingleInt32.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL SingleInt32 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "SingleInt32.gron"))
    val obj = SingleInt32Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    SingleInt32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "SingleInt32.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL SingleInt32 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_single_int64(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "SingleInt64.msgpack"))
    val obj = SingleInt64Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    SingleInt64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "SingleInt64.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL SingleInt64 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "SingleInt64.json"))
    val obj = SingleInt64Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    SingleInt64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "SingleInt64.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL SingleInt64 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "SingleInt64.unformatted.json"))
    val obj = SingleInt64Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    SingleInt64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "SingleInt64.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL SingleInt64 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "SingleInt64.gron"))
    val obj = SingleInt64Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    SingleInt64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "SingleInt64.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL SingleInt64 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_single_uint8(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "SingleUint8.msgpack"))
    val obj = SingleUint8Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    SingleUint8Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "SingleUint8.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL SingleUint8 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "SingleUint8.json"))
    val obj = SingleUint8Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    SingleUint8Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "SingleUint8.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL SingleUint8 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "SingleUint8.unformatted.json"))
    val obj = SingleUint8Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    SingleUint8Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "SingleUint8.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL SingleUint8 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "SingleUint8.gron"))
    val obj = SingleUint8Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    SingleUint8Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "SingleUint8.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL SingleUint8 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_single_uint16(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "SingleUint16.msgpack"))
    val obj = SingleUint16Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    SingleUint16Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "SingleUint16.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL SingleUint16 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "SingleUint16.json"))
    val obj = SingleUint16Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    SingleUint16Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "SingleUint16.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL SingleUint16 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "SingleUint16.unformatted.json"))
    val obj = SingleUint16Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    SingleUint16Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "SingleUint16.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL SingleUint16 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "SingleUint16.gron"))
    val obj = SingleUint16Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    SingleUint16Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "SingleUint16.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL SingleUint16 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_single_uint32(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "SingleUint32.msgpack"))
    val obj = SingleUint32Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    SingleUint32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "SingleUint32.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL SingleUint32 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "SingleUint32.json"))
    val obj = SingleUint32Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    SingleUint32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "SingleUint32.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL SingleUint32 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "SingleUint32.unformatted.json"))
    val obj = SingleUint32Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    SingleUint32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "SingleUint32.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL SingleUint32 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "SingleUint32.gron"))
    val obj = SingleUint32Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    SingleUint32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "SingleUint32.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL SingleUint32 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_single_uint64(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "SingleUint64.msgpack"))
    val obj = SingleUint64Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    SingleUint64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "SingleUint64.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL SingleUint64 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "SingleUint64.json"))
    val obj = SingleUint64Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    SingleUint64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "SingleUint64.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL SingleUint64 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "SingleUint64.unformatted.json"))
    val obj = SingleUint64Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    SingleUint64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "SingleUint64.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL SingleUint64 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "SingleUint64.gron"))
    val obj = SingleUint64Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    SingleUint64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "SingleUint64.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL SingleUint64 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_single_float32(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "SingleFloat32.msgpack"))
    val obj = SingleFloat32Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    SingleFloat32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "SingleFloat32.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL SingleFloat32 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "SingleFloat32.json"))
    val obj = SingleFloat32Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    SingleFloat32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "SingleFloat32.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL SingleFloat32 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "SingleFloat32.unformatted.json"))
    val obj = SingleFloat32Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    SingleFloat32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "SingleFloat32.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL SingleFloat32 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "SingleFloat32.gron"))
    val obj = SingleFloat32Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    SingleFloat32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "SingleFloat32.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL SingleFloat32 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_single_float64(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "SingleFloat64.msgpack"))
    val obj = SingleFloat64Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    SingleFloat64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "SingleFloat64.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL SingleFloat64 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "SingleFloat64.json"))
    val obj = SingleFloat64Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    SingleFloat64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "SingleFloat64.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL SingleFloat64 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "SingleFloat64.unformatted.json"))
    val obj = SingleFloat64Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    SingleFloat64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "SingleFloat64.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL SingleFloat64 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "SingleFloat64.gron"))
    val obj = SingleFloat64Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    SingleFloat64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "SingleFloat64.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL SingleFloat64 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_single_bytes(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "SingleBytes.msgpack"))
    val obj = SingleBytesCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    SingleBytesCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "SingleBytes.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL SingleBytes mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "SingleBytes.json"))
    val obj = SingleBytesCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    SingleBytesCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "SingleBytes.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL SingleBytes json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "SingleBytes.unformatted.json"))
    val obj = SingleBytesCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    SingleBytesCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "SingleBytes.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL SingleBytes unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "SingleBytes.gron"))
    val obj = SingleBytesCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    SingleBytesCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "SingleBytes.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL SingleBytes gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def run_AllTypes_Scalars(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  Files.createDirectories(Paths.get(out))
  { val r = test_single_string(vec, out); passed += r._1; failed += r._2 }
  { val r = test_single_boolean(vec, out); passed += r._1; failed += r._2 }
  { val r = test_single_int8(vec, out); passed += r._1; failed += r._2 }
  { val r = test_single_int16(vec, out); passed += r._1; failed += r._2 }
  { val r = test_single_int32(vec, out); passed += r._1; failed += r._2 }
  { val r = test_single_int64(vec, out); passed += r._1; failed += r._2 }
  { val r = test_single_uint8(vec, out); passed += r._1; failed += r._2 }
  { val r = test_single_uint16(vec, out); passed += r._1; failed += r._2 }
  { val r = test_single_uint32(vec, out); passed += r._1; failed += r._2 }
  { val r = test_single_uint64(vec, out); passed += r._1; failed += r._2 }
  { val r = test_single_float32(vec, out); passed += r._1; failed += r._2 }
  { val r = test_single_float64(vec, out); passed += r._1; failed += r._2 }
  { val r = test_single_bytes(vec, out); passed += r._1; failed += r._2 }
  (passed, failed)
}
