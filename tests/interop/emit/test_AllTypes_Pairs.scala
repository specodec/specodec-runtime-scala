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

def test_pair_string(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "PairString.msgpack"))
    val obj = PairStringCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    PairStringCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "PairString.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL PairString mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "PairString.json"))
    val obj = PairStringCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    PairStringCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "PairString.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL PairString json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "PairString.unformatted.json"))
    val obj = PairStringCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    PairStringCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "PairString.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL PairString unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "PairString.gron"))
    val obj = PairStringCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    PairStringCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "PairString.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL PairString gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_pair_boolean(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "PairBoolean.msgpack"))
    val obj = PairBooleanCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    PairBooleanCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "PairBoolean.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL PairBoolean mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "PairBoolean.json"))
    val obj = PairBooleanCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    PairBooleanCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "PairBoolean.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL PairBoolean json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "PairBoolean.unformatted.json"))
    val obj = PairBooleanCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    PairBooleanCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "PairBoolean.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL PairBoolean unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "PairBoolean.gron"))
    val obj = PairBooleanCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    PairBooleanCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "PairBoolean.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL PairBoolean gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_pair_int8(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "PairInt8.msgpack"))
    val obj = PairInt8Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    PairInt8Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "PairInt8.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL PairInt8 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "PairInt8.json"))
    val obj = PairInt8Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    PairInt8Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "PairInt8.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL PairInt8 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "PairInt8.unformatted.json"))
    val obj = PairInt8Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    PairInt8Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "PairInt8.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL PairInt8 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "PairInt8.gron"))
    val obj = PairInt8Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    PairInt8Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "PairInt8.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL PairInt8 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_pair_int16(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "PairInt16.msgpack"))
    val obj = PairInt16Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    PairInt16Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "PairInt16.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL PairInt16 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "PairInt16.json"))
    val obj = PairInt16Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    PairInt16Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "PairInt16.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL PairInt16 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "PairInt16.unformatted.json"))
    val obj = PairInt16Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    PairInt16Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "PairInt16.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL PairInt16 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "PairInt16.gron"))
    val obj = PairInt16Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    PairInt16Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "PairInt16.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL PairInt16 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_pair_int32(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "PairInt32.msgpack"))
    val obj = PairInt32Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    PairInt32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "PairInt32.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL PairInt32 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "PairInt32.json"))
    val obj = PairInt32Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    PairInt32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "PairInt32.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL PairInt32 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "PairInt32.unformatted.json"))
    val obj = PairInt32Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    PairInt32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "PairInt32.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL PairInt32 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "PairInt32.gron"))
    val obj = PairInt32Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    PairInt32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "PairInt32.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL PairInt32 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_pair_int64(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "PairInt64.msgpack"))
    val obj = PairInt64Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    PairInt64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "PairInt64.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL PairInt64 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "PairInt64.json"))
    val obj = PairInt64Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    PairInt64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "PairInt64.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL PairInt64 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "PairInt64.unformatted.json"))
    val obj = PairInt64Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    PairInt64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "PairInt64.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL PairInt64 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "PairInt64.gron"))
    val obj = PairInt64Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    PairInt64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "PairInt64.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL PairInt64 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_pair_uint8(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "PairUint8.msgpack"))
    val obj = PairUint8Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    PairUint8Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "PairUint8.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL PairUint8 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "PairUint8.json"))
    val obj = PairUint8Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    PairUint8Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "PairUint8.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL PairUint8 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "PairUint8.unformatted.json"))
    val obj = PairUint8Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    PairUint8Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "PairUint8.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL PairUint8 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "PairUint8.gron"))
    val obj = PairUint8Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    PairUint8Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "PairUint8.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL PairUint8 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_pair_uint16(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "PairUint16.msgpack"))
    val obj = PairUint16Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    PairUint16Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "PairUint16.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL PairUint16 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "PairUint16.json"))
    val obj = PairUint16Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    PairUint16Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "PairUint16.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL PairUint16 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "PairUint16.unformatted.json"))
    val obj = PairUint16Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    PairUint16Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "PairUint16.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL PairUint16 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "PairUint16.gron"))
    val obj = PairUint16Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    PairUint16Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "PairUint16.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL PairUint16 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_pair_uint32(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "PairUint32.msgpack"))
    val obj = PairUint32Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    PairUint32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "PairUint32.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL PairUint32 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "PairUint32.json"))
    val obj = PairUint32Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    PairUint32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "PairUint32.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL PairUint32 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "PairUint32.unformatted.json"))
    val obj = PairUint32Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    PairUint32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "PairUint32.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL PairUint32 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "PairUint32.gron"))
    val obj = PairUint32Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    PairUint32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "PairUint32.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL PairUint32 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_pair_uint64(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "PairUint64.msgpack"))
    val obj = PairUint64Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    PairUint64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "PairUint64.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL PairUint64 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "PairUint64.json"))
    val obj = PairUint64Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    PairUint64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "PairUint64.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL PairUint64 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "PairUint64.unformatted.json"))
    val obj = PairUint64Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    PairUint64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "PairUint64.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL PairUint64 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "PairUint64.gron"))
    val obj = PairUint64Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    PairUint64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "PairUint64.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL PairUint64 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_pair_float32(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "PairFloat32.msgpack"))
    val obj = PairFloat32Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    PairFloat32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "PairFloat32.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL PairFloat32 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "PairFloat32.json"))
    val obj = PairFloat32Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    PairFloat32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "PairFloat32.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL PairFloat32 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "PairFloat32.unformatted.json"))
    val obj = PairFloat32Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    PairFloat32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "PairFloat32.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL PairFloat32 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "PairFloat32.gron"))
    val obj = PairFloat32Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    PairFloat32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "PairFloat32.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL PairFloat32 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_pair_float64(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "PairFloat64.msgpack"))
    val obj = PairFloat64Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    PairFloat64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "PairFloat64.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL PairFloat64 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "PairFloat64.json"))
    val obj = PairFloat64Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    PairFloat64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "PairFloat64.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL PairFloat64 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "PairFloat64.unformatted.json"))
    val obj = PairFloat64Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    PairFloat64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "PairFloat64.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL PairFloat64 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "PairFloat64.gron"))
    val obj = PairFloat64Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    PairFloat64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "PairFloat64.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL PairFloat64 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_pair_bytes(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "PairBytes.msgpack"))
    val obj = PairBytesCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    PairBytesCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "PairBytes.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL PairBytes mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "PairBytes.json"))
    val obj = PairBytesCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    PairBytesCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "PairBytes.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL PairBytes json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "PairBytes.unformatted.json"))
    val obj = PairBytesCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    PairBytesCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "PairBytes.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL PairBytes unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "PairBytes.gron"))
    val obj = PairBytesCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    PairBytesCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "PairBytes.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL PairBytes gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_dual_string_int32(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualStringInt32.msgpack"))
    val obj = DualStringInt32Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    DualStringInt32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualStringInt32.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualStringInt32 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualStringInt32.json"))
    val obj = DualStringInt32Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DualStringInt32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualStringInt32.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualStringInt32 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualStringInt32.unformatted.json"))
    val obj = DualStringInt32Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DualStringInt32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualStringInt32.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualStringInt32 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualStringInt32.gron"))
    val obj = DualStringInt32Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    DualStringInt32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualStringInt32.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualStringInt32 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_dual_string_boolean(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualStringBoolean.msgpack"))
    val obj = DualStringBooleanCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    DualStringBooleanCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualStringBoolean.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualStringBoolean mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualStringBoolean.json"))
    val obj = DualStringBooleanCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DualStringBooleanCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualStringBoolean.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualStringBoolean json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualStringBoolean.unformatted.json"))
    val obj = DualStringBooleanCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DualStringBooleanCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualStringBoolean.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualStringBoolean unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualStringBoolean.gron"))
    val obj = DualStringBooleanCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    DualStringBooleanCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualStringBoolean.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualStringBoolean gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_dual_string_float64(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualStringFloat64.msgpack"))
    val obj = DualStringFloat64Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    DualStringFloat64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualStringFloat64.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualStringFloat64 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualStringFloat64.json"))
    val obj = DualStringFloat64Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DualStringFloat64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualStringFloat64.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualStringFloat64 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualStringFloat64.unformatted.json"))
    val obj = DualStringFloat64Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DualStringFloat64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualStringFloat64.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualStringFloat64 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualStringFloat64.gron"))
    val obj = DualStringFloat64Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    DualStringFloat64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualStringFloat64.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualStringFloat64 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_dual_string_bytes(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualStringBytes.msgpack"))
    val obj = DualStringBytesCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    DualStringBytesCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualStringBytes.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualStringBytes mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualStringBytes.json"))
    val obj = DualStringBytesCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DualStringBytesCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualStringBytes.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualStringBytes json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualStringBytes.unformatted.json"))
    val obj = DualStringBytesCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DualStringBytesCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualStringBytes.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualStringBytes unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualStringBytes.gron"))
    val obj = DualStringBytesCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    DualStringBytesCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualStringBytes.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualStringBytes gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_dual_int32_boolean(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualInt32Boolean.msgpack"))
    val obj = DualInt32BooleanCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    DualInt32BooleanCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualInt32Boolean.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualInt32Boolean mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualInt32Boolean.json"))
    val obj = DualInt32BooleanCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DualInt32BooleanCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualInt32Boolean.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualInt32Boolean json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualInt32Boolean.unformatted.json"))
    val obj = DualInt32BooleanCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DualInt32BooleanCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualInt32Boolean.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualInt32Boolean unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualInt32Boolean.gron"))
    val obj = DualInt32BooleanCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    DualInt32BooleanCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualInt32Boolean.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualInt32Boolean gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_dual_int32_float64(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualInt32Float64.msgpack"))
    val obj = DualInt32Float64Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    DualInt32Float64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualInt32Float64.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualInt32Float64 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualInt32Float64.json"))
    val obj = DualInt32Float64Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DualInt32Float64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualInt32Float64.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualInt32Float64 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualInt32Float64.unformatted.json"))
    val obj = DualInt32Float64Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DualInt32Float64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualInt32Float64.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualInt32Float64 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualInt32Float64.gron"))
    val obj = DualInt32Float64Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    DualInt32Float64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualInt32Float64.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualInt32Float64 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_dual_int32_int64(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualInt32Int64.msgpack"))
    val obj = DualInt32Int64Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    DualInt32Int64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualInt32Int64.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualInt32Int64 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualInt32Int64.json"))
    val obj = DualInt32Int64Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DualInt32Int64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualInt32Int64.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualInt32Int64 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualInt32Int64.unformatted.json"))
    val obj = DualInt32Int64Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DualInt32Int64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualInt32Int64.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualInt32Int64 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualInt32Int64.gron"))
    val obj = DualInt32Int64Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    DualInt32Int64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualInt32Int64.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualInt32Int64 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_dual_int32_uint32(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualInt32Uint32.msgpack"))
    val obj = DualInt32Uint32Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    DualInt32Uint32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualInt32Uint32.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualInt32Uint32 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualInt32Uint32.json"))
    val obj = DualInt32Uint32Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DualInt32Uint32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualInt32Uint32.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualInt32Uint32 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualInt32Uint32.unformatted.json"))
    val obj = DualInt32Uint32Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DualInt32Uint32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualInt32Uint32.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualInt32Uint32 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualInt32Uint32.gron"))
    val obj = DualInt32Uint32Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    DualInt32Uint32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualInt32Uint32.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualInt32Uint32 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_dual_int64_uint64(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualInt64Uint64.msgpack"))
    val obj = DualInt64Uint64Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    DualInt64Uint64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualInt64Uint64.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualInt64Uint64 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualInt64Uint64.json"))
    val obj = DualInt64Uint64Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DualInt64Uint64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualInt64Uint64.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualInt64Uint64 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualInt64Uint64.unformatted.json"))
    val obj = DualInt64Uint64Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DualInt64Uint64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualInt64Uint64.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualInt64Uint64 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualInt64Uint64.gron"))
    val obj = DualInt64Uint64Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    DualInt64Uint64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualInt64Uint64.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualInt64Uint64 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_dual_float32_float64(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualFloat32Float64.msgpack"))
    val obj = DualFloat32Float64Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    DualFloat32Float64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualFloat32Float64.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualFloat32Float64 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualFloat32Float64.json"))
    val obj = DualFloat32Float64Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DualFloat32Float64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualFloat32Float64.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualFloat32Float64 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualFloat32Float64.unformatted.json"))
    val obj = DualFloat32Float64Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DualFloat32Float64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualFloat32Float64.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualFloat32Float64 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualFloat32Float64.gron"))
    val obj = DualFloat32Float64Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    DualFloat32Float64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualFloat32Float64.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualFloat32Float64 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_dual_float64_boolean(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualFloat64Boolean.msgpack"))
    val obj = DualFloat64BooleanCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    DualFloat64BooleanCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualFloat64Boolean.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualFloat64Boolean mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualFloat64Boolean.json"))
    val obj = DualFloat64BooleanCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DualFloat64BooleanCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualFloat64Boolean.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualFloat64Boolean json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualFloat64Boolean.unformatted.json"))
    val obj = DualFloat64BooleanCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DualFloat64BooleanCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualFloat64Boolean.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualFloat64Boolean unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualFloat64Boolean.gron"))
    val obj = DualFloat64BooleanCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    DualFloat64BooleanCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualFloat64Boolean.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualFloat64Boolean gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_dual_float64_bytes(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualFloat64Bytes.msgpack"))
    val obj = DualFloat64BytesCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    DualFloat64BytesCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualFloat64Bytes.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualFloat64Bytes mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualFloat64Bytes.json"))
    val obj = DualFloat64BytesCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DualFloat64BytesCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualFloat64Bytes.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualFloat64Bytes json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualFloat64Bytes.unformatted.json"))
    val obj = DualFloat64BytesCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DualFloat64BytesCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualFloat64Bytes.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualFloat64Bytes unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualFloat64Bytes.gron"))
    val obj = DualFloat64BytesCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    DualFloat64BytesCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualFloat64Bytes.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualFloat64Bytes gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_dual_uint32_uint64(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualUint32Uint64.msgpack"))
    val obj = DualUint32Uint64Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    DualUint32Uint64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualUint32Uint64.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualUint32Uint64 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualUint32Uint64.json"))
    val obj = DualUint32Uint64Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DualUint32Uint64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualUint32Uint64.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualUint32Uint64 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualUint32Uint64.unformatted.json"))
    val obj = DualUint32Uint64Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DualUint32Uint64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualUint32Uint64.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualUint32Uint64 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualUint32Uint64.gron"))
    val obj = DualUint32Uint64Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    DualUint32Uint64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualUint32Uint64.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualUint32Uint64 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_dual_boolean_bytes(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualBooleanBytes.msgpack"))
    val obj = DualBooleanBytesCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    DualBooleanBytesCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualBooleanBytes.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualBooleanBytes mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualBooleanBytes.json"))
    val obj = DualBooleanBytesCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DualBooleanBytesCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualBooleanBytes.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualBooleanBytes json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualBooleanBytes.unformatted.json"))
    val obj = DualBooleanBytesCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DualBooleanBytesCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualBooleanBytes.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualBooleanBytes unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualBooleanBytes.gron"))
    val obj = DualBooleanBytesCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    DualBooleanBytesCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualBooleanBytes.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualBooleanBytes gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_dual_int8_uint8(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualInt8Uint8.msgpack"))
    val obj = DualInt8Uint8Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    DualInt8Uint8Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualInt8Uint8.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualInt8Uint8 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualInt8Uint8.json"))
    val obj = DualInt8Uint8Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DualInt8Uint8Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualInt8Uint8.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualInt8Uint8 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualInt8Uint8.unformatted.json"))
    val obj = DualInt8Uint8Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DualInt8Uint8Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualInt8Uint8.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualInt8Uint8 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualInt8Uint8.gron"))
    val obj = DualInt8Uint8Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    DualInt8Uint8Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualInt8Uint8.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualInt8Uint8 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_dual_int16_uint16(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualInt16Uint16.msgpack"))
    val obj = DualInt16Uint16Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    DualInt16Uint16Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualInt16Uint16.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualInt16Uint16 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualInt16Uint16.json"))
    val obj = DualInt16Uint16Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DualInt16Uint16Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualInt16Uint16.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualInt16Uint16 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualInt16Uint16.unformatted.json"))
    val obj = DualInt16Uint16Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DualInt16Uint16Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualInt16Uint16.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualInt16Uint16 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualInt16Uint16.gron"))
    val obj = DualInt16Uint16Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    DualInt16Uint16Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualInt16Uint16.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualInt16Uint16 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_dual_string_int64(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualStringInt64.msgpack"))
    val obj = DualStringInt64Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    DualStringInt64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualStringInt64.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualStringInt64 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualStringInt64.json"))
    val obj = DualStringInt64Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DualStringInt64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualStringInt64.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualStringInt64 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualStringInt64.unformatted.json"))
    val obj = DualStringInt64Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DualStringInt64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualStringInt64.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualStringInt64 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualStringInt64.gron"))
    val obj = DualStringInt64Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    DualStringInt64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualStringInt64.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualStringInt64 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_dual_string_uint64(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualStringUint64.msgpack"))
    val obj = DualStringUint64Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    DualStringUint64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualStringUint64.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualStringUint64 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualStringUint64.json"))
    val obj = DualStringUint64Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DualStringUint64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualStringUint64.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualStringUint64 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualStringUint64.unformatted.json"))
    val obj = DualStringUint64Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DualStringUint64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualStringUint64.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualStringUint64 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualStringUint64.gron"))
    val obj = DualStringUint64Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    DualStringUint64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualStringUint64.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualStringUint64 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_dual_int32_bytes(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualInt32Bytes.msgpack"))
    val obj = DualInt32BytesCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    DualInt32BytesCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualInt32Bytes.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualInt32Bytes mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualInt32Bytes.json"))
    val obj = DualInt32BytesCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DualInt32BytesCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualInt32Bytes.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualInt32Bytes json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualInt32Bytes.unformatted.json"))
    val obj = DualInt32BytesCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DualInt32BytesCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualInt32Bytes.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualInt32Bytes unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualInt32Bytes.gron"))
    val obj = DualInt32BytesCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    DualInt32BytesCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualInt32Bytes.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualInt32Bytes gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_dual_float64_int32(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualFloat64Int32.msgpack"))
    val obj = DualFloat64Int32Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    DualFloat64Int32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualFloat64Int32.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualFloat64Int32 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualFloat64Int32.json"))
    val obj = DualFloat64Int32Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DualFloat64Int32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualFloat64Int32.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualFloat64Int32 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualFloat64Int32.unformatted.json"))
    val obj = DualFloat64Int32Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DualFloat64Int32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualFloat64Int32.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualFloat64Int32 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualFloat64Int32.gron"))
    val obj = DualFloat64Int32Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    DualFloat64Int32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualFloat64Int32.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualFloat64Int32 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_dual_boolean_int32(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualBooleanInt32.msgpack"))
    val obj = DualBooleanInt32Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    DualBooleanInt32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualBooleanInt32.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualBooleanInt32 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualBooleanInt32.json"))
    val obj = DualBooleanInt32Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DualBooleanInt32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualBooleanInt32.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualBooleanInt32 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualBooleanInt32.unformatted.json"))
    val obj = DualBooleanInt32Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DualBooleanInt32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualBooleanInt32.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualBooleanInt32 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualBooleanInt32.gron"))
    val obj = DualBooleanInt32Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    DualBooleanInt32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualBooleanInt32.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualBooleanInt32 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_dual_bytes_int64(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualBytesInt64.msgpack"))
    val obj = DualBytesInt64Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    DualBytesInt64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualBytesInt64.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualBytesInt64 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualBytesInt64.json"))
    val obj = DualBytesInt64Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DualBytesInt64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualBytesInt64.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualBytesInt64 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualBytesInt64.unformatted.json"))
    val obj = DualBytesInt64Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DualBytesInt64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualBytesInt64.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualBytesInt64 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualBytesInt64.gron"))
    val obj = DualBytesInt64Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    DualBytesInt64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualBytesInt64.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualBytesInt64 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_dual_int8_float32(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualInt8Float32.msgpack"))
    val obj = DualInt8Float32Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    DualInt8Float32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualInt8Float32.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualInt8Float32 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualInt8Float32.json"))
    val obj = DualInt8Float32Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DualInt8Float32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualInt8Float32.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualInt8Float32 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualInt8Float32.unformatted.json"))
    val obj = DualInt8Float32Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DualInt8Float32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualInt8Float32.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualInt8Float32 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualInt8Float32.gron"))
    val obj = DualInt8Float32Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    DualInt8Float32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualInt8Float32.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualInt8Float32 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_dual_uint8_int16(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualUint8Int16.msgpack"))
    val obj = DualUint8Int16Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    DualUint8Int16Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualUint8Int16.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualUint8Int16 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualUint8Int16.json"))
    val obj = DualUint8Int16Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DualUint8Int16Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualUint8Int16.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualUint8Int16 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualUint8Int16.unformatted.json"))
    val obj = DualUint8Int16Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DualUint8Int16Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualUint8Int16.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualUint8Int16 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualUint8Int16.gron"))
    val obj = DualUint8Int16Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    DualUint8Int16Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualUint8Int16.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualUint8Int16 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_dual_int64_float64(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualInt64Float64.msgpack"))
    val obj = DualInt64Float64Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    DualInt64Float64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualInt64Float64.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualInt64Float64 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualInt64Float64.json"))
    val obj = DualInt64Float64Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DualInt64Float64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualInt64Float64.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualInt64Float64 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualInt64Float64.unformatted.json"))
    val obj = DualInt64Float64Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DualInt64Float64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualInt64Float64.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualInt64Float64 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualInt64Float64.gron"))
    val obj = DualInt64Float64Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    DualInt64Float64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualInt64Float64.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualInt64Float64 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_dual_uint64_string(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualUint64String.msgpack"))
    val obj = DualUint64StringCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    DualUint64StringCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualUint64String.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualUint64String mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualUint64String.json"))
    val obj = DualUint64StringCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DualUint64StringCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualUint64String.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualUint64String json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualUint64String.unformatted.json"))
    val obj = DualUint64StringCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DualUint64StringCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualUint64String.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualUint64String unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DualUint64String.gron"))
    val obj = DualUint64StringCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    DualUint64StringCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DualUint64String.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DualUint64String gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_triple01(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Triple01.msgpack"))
    val obj = Triple01Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    Triple01Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Triple01.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Triple01 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Triple01.json"))
    val obj = Triple01Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Triple01Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Triple01.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Triple01 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Triple01.unformatted.json"))
    val obj = Triple01Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Triple01Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Triple01.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Triple01 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Triple01.gron"))
    val obj = Triple01Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    Triple01Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Triple01.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Triple01 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_triple02(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Triple02.msgpack"))
    val obj = Triple02Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    Triple02Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Triple02.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Triple02 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Triple02.json"))
    val obj = Triple02Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Triple02Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Triple02.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Triple02 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Triple02.unformatted.json"))
    val obj = Triple02Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Triple02Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Triple02.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Triple02 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Triple02.gron"))
    val obj = Triple02Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    Triple02Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Triple02.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Triple02 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_triple03(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Triple03.msgpack"))
    val obj = Triple03Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    Triple03Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Triple03.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Triple03 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Triple03.json"))
    val obj = Triple03Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Triple03Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Triple03.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Triple03 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Triple03.unformatted.json"))
    val obj = Triple03Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Triple03Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Triple03.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Triple03 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Triple03.gron"))
    val obj = Triple03Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    Triple03Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Triple03.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Triple03 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_triple04(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Triple04.msgpack"))
    val obj = Triple04Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    Triple04Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Triple04.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Triple04 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Triple04.json"))
    val obj = Triple04Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Triple04Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Triple04.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Triple04 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Triple04.unformatted.json"))
    val obj = Triple04Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Triple04Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Triple04.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Triple04 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Triple04.gron"))
    val obj = Triple04Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    Triple04Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Triple04.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Triple04 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_triple05(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Triple05.msgpack"))
    val obj = Triple05Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    Triple05Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Triple05.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Triple05 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Triple05.json"))
    val obj = Triple05Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Triple05Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Triple05.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Triple05 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Triple05.unformatted.json"))
    val obj = Triple05Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Triple05Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Triple05.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Triple05 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Triple05.gron"))
    val obj = Triple05Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    Triple05Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Triple05.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Triple05 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_triple06(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Triple06.msgpack"))
    val obj = Triple06Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    Triple06Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Triple06.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Triple06 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Triple06.json"))
    val obj = Triple06Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Triple06Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Triple06.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Triple06 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Triple06.unformatted.json"))
    val obj = Triple06Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Triple06Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Triple06.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Triple06 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Triple06.gron"))
    val obj = Triple06Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    Triple06Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Triple06.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Triple06 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_triple07(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Triple07.msgpack"))
    val obj = Triple07Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    Triple07Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Triple07.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Triple07 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Triple07.json"))
    val obj = Triple07Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Triple07Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Triple07.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Triple07 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Triple07.unformatted.json"))
    val obj = Triple07Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Triple07Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Triple07.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Triple07 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Triple07.gron"))
    val obj = Triple07Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    Triple07Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Triple07.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Triple07 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_triple08(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Triple08.msgpack"))
    val obj = Triple08Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    Triple08Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Triple08.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Triple08 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Triple08.json"))
    val obj = Triple08Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Triple08Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Triple08.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Triple08 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Triple08.unformatted.json"))
    val obj = Triple08Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Triple08Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Triple08.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Triple08 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Triple08.gron"))
    val obj = Triple08Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    Triple08Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Triple08.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Triple08 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_triple09(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Triple09.msgpack"))
    val obj = Triple09Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    Triple09Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Triple09.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Triple09 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Triple09.json"))
    val obj = Triple09Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Triple09Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Triple09.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Triple09 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Triple09.unformatted.json"))
    val obj = Triple09Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Triple09Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Triple09.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Triple09 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Triple09.gron"))
    val obj = Triple09Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    Triple09Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Triple09.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Triple09 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_triple10(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Triple10.msgpack"))
    val obj = Triple10Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    Triple10Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Triple10.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Triple10 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Triple10.json"))
    val obj = Triple10Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Triple10Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Triple10.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Triple10 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Triple10.unformatted.json"))
    val obj = Triple10Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Triple10Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Triple10.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Triple10 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Triple10.gron"))
    val obj = Triple10Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    Triple10Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Triple10.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Triple10 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_triple11(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Triple11.msgpack"))
    val obj = Triple11Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    Triple11Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Triple11.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Triple11 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Triple11.json"))
    val obj = Triple11Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Triple11Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Triple11.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Triple11 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Triple11.unformatted.json"))
    val obj = Triple11Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Triple11Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Triple11.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Triple11 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Triple11.gron"))
    val obj = Triple11Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    Triple11Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Triple11.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Triple11 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_triple12(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Triple12.msgpack"))
    val obj = Triple12Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    Triple12Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Triple12.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Triple12 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Triple12.json"))
    val obj = Triple12Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Triple12Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Triple12.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Triple12 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Triple12.unformatted.json"))
    val obj = Triple12Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Triple12Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Triple12.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Triple12 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Triple12.gron"))
    val obj = Triple12Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    Triple12Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Triple12.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Triple12 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_triple13(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Triple13.msgpack"))
    val obj = Triple13Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    Triple13Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Triple13.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Triple13 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Triple13.json"))
    val obj = Triple13Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Triple13Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Triple13.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Triple13 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Triple13.unformatted.json"))
    val obj = Triple13Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Triple13Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Triple13.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Triple13 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Triple13.gron"))
    val obj = Triple13Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    Triple13Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Triple13.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Triple13 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_triple14(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Triple14.msgpack"))
    val obj = Triple14Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    Triple14Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Triple14.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Triple14 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Triple14.json"))
    val obj = Triple14Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Triple14Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Triple14.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Triple14 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Triple14.unformatted.json"))
    val obj = Triple14Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Triple14Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Triple14.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Triple14 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Triple14.gron"))
    val obj = Triple14Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    Triple14Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Triple14.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Triple14 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_triple15(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Triple15.msgpack"))
    val obj = Triple15Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    Triple15Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Triple15.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Triple15 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Triple15.json"))
    val obj = Triple15Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Triple15Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Triple15.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Triple15 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Triple15.unformatted.json"))
    val obj = Triple15Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Triple15Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Triple15.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Triple15 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Triple15.gron"))
    val obj = Triple15Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    Triple15Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Triple15.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Triple15 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def run_AllTypes_Pairs(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  Files.createDirectories(Paths.get(out))
  { val r = test_pair_string(vec, out); passed += r._1; failed += r._2 }
  { val r = test_pair_boolean(vec, out); passed += r._1; failed += r._2 }
  { val r = test_pair_int8(vec, out); passed += r._1; failed += r._2 }
  { val r = test_pair_int16(vec, out); passed += r._1; failed += r._2 }
  { val r = test_pair_int32(vec, out); passed += r._1; failed += r._2 }
  { val r = test_pair_int64(vec, out); passed += r._1; failed += r._2 }
  { val r = test_pair_uint8(vec, out); passed += r._1; failed += r._2 }
  { val r = test_pair_uint16(vec, out); passed += r._1; failed += r._2 }
  { val r = test_pair_uint32(vec, out); passed += r._1; failed += r._2 }
  { val r = test_pair_uint64(vec, out); passed += r._1; failed += r._2 }
  { val r = test_pair_float32(vec, out); passed += r._1; failed += r._2 }
  { val r = test_pair_float64(vec, out); passed += r._1; failed += r._2 }
  { val r = test_pair_bytes(vec, out); passed += r._1; failed += r._2 }
  { val r = test_dual_string_int32(vec, out); passed += r._1; failed += r._2 }
  { val r = test_dual_string_boolean(vec, out); passed += r._1; failed += r._2 }
  { val r = test_dual_string_float64(vec, out); passed += r._1; failed += r._2 }
  { val r = test_dual_string_bytes(vec, out); passed += r._1; failed += r._2 }
  { val r = test_dual_int32_boolean(vec, out); passed += r._1; failed += r._2 }
  { val r = test_dual_int32_float64(vec, out); passed += r._1; failed += r._2 }
  { val r = test_dual_int32_int64(vec, out); passed += r._1; failed += r._2 }
  { val r = test_dual_int32_uint32(vec, out); passed += r._1; failed += r._2 }
  { val r = test_dual_int64_uint64(vec, out); passed += r._1; failed += r._2 }
  { val r = test_dual_float32_float64(vec, out); passed += r._1; failed += r._2 }
  { val r = test_dual_float64_boolean(vec, out); passed += r._1; failed += r._2 }
  { val r = test_dual_float64_bytes(vec, out); passed += r._1; failed += r._2 }
  { val r = test_dual_uint32_uint64(vec, out); passed += r._1; failed += r._2 }
  { val r = test_dual_boolean_bytes(vec, out); passed += r._1; failed += r._2 }
  { val r = test_dual_int8_uint8(vec, out); passed += r._1; failed += r._2 }
  { val r = test_dual_int16_uint16(vec, out); passed += r._1; failed += r._2 }
  { val r = test_dual_string_int64(vec, out); passed += r._1; failed += r._2 }
  { val r = test_dual_string_uint64(vec, out); passed += r._1; failed += r._2 }
  { val r = test_dual_int32_bytes(vec, out); passed += r._1; failed += r._2 }
  { val r = test_dual_float64_int32(vec, out); passed += r._1; failed += r._2 }
  { val r = test_dual_boolean_int32(vec, out); passed += r._1; failed += r._2 }
  { val r = test_dual_bytes_int64(vec, out); passed += r._1; failed += r._2 }
  { val r = test_dual_int8_float32(vec, out); passed += r._1; failed += r._2 }
  { val r = test_dual_uint8_int16(vec, out); passed += r._1; failed += r._2 }
  { val r = test_dual_int64_float64(vec, out); passed += r._1; failed += r._2 }
  { val r = test_dual_uint64_string(vec, out); passed += r._1; failed += r._2 }
  { val r = test_triple01(vec, out); passed += r._1; failed += r._2 }
  { val r = test_triple02(vec, out); passed += r._1; failed += r._2 }
  { val r = test_triple03(vec, out); passed += r._1; failed += r._2 }
  { val r = test_triple04(vec, out); passed += r._1; failed += r._2 }
  { val r = test_triple05(vec, out); passed += r._1; failed += r._2 }
  { val r = test_triple06(vec, out); passed += r._1; failed += r._2 }
  { val r = test_triple07(vec, out); passed += r._1; failed += r._2 }
  { val r = test_triple08(vec, out); passed += r._1; failed += r._2 }
  { val r = test_triple09(vec, out); passed += r._1; failed += r._2 }
  { val r = test_triple10(vec, out); passed += r._1; failed += r._2 }
  { val r = test_triple11(vec, out); passed += r._1; failed += r._2 }
  { val r = test_triple12(vec, out); passed += r._1; failed += r._2 }
  { val r = test_triple13(vec, out); passed += r._1; failed += r._2 }
  { val r = test_triple14(vec, out); passed += r._1; failed += r._2 }
  { val r = test_triple15(vec, out); passed += r._1; failed += r._2 }
  (passed, failed)
}
