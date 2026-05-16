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

def test_opt_single_string(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptSingleString.msgpack"))
    val obj = OptSingleStringCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    OptSingleStringCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptSingleString.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptSingleString mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptSingleString.json"))
    val obj = OptSingleStringCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptSingleStringCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptSingleString.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptSingleString json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptSingleString.unformatted.json"))
    val obj = OptSingleStringCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptSingleStringCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptSingleString.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptSingleString unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptSingleString.gron"))
    val obj = OptSingleStringCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    OptSingleStringCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptSingleString.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptSingleString gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_opt_single_boolean(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptSingleBoolean.msgpack"))
    val obj = OptSingleBooleanCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    OptSingleBooleanCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptSingleBoolean.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptSingleBoolean mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptSingleBoolean.json"))
    val obj = OptSingleBooleanCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptSingleBooleanCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptSingleBoolean.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptSingleBoolean json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptSingleBoolean.unformatted.json"))
    val obj = OptSingleBooleanCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptSingleBooleanCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptSingleBoolean.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptSingleBoolean unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptSingleBoolean.gron"))
    val obj = OptSingleBooleanCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    OptSingleBooleanCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptSingleBoolean.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptSingleBoolean gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_opt_single_int8(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptSingleInt8.msgpack"))
    val obj = OptSingleInt8Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    OptSingleInt8Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptSingleInt8.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptSingleInt8 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptSingleInt8.json"))
    val obj = OptSingleInt8Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptSingleInt8Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptSingleInt8.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptSingleInt8 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptSingleInt8.unformatted.json"))
    val obj = OptSingleInt8Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptSingleInt8Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptSingleInt8.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptSingleInt8 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptSingleInt8.gron"))
    val obj = OptSingleInt8Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    OptSingleInt8Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptSingleInt8.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptSingleInt8 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_opt_single_int16(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptSingleInt16.msgpack"))
    val obj = OptSingleInt16Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    OptSingleInt16Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptSingleInt16.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptSingleInt16 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptSingleInt16.json"))
    val obj = OptSingleInt16Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptSingleInt16Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptSingleInt16.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptSingleInt16 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptSingleInt16.unformatted.json"))
    val obj = OptSingleInt16Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptSingleInt16Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptSingleInt16.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptSingleInt16 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptSingleInt16.gron"))
    val obj = OptSingleInt16Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    OptSingleInt16Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptSingleInt16.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptSingleInt16 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_opt_single_int32(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptSingleInt32.msgpack"))
    val obj = OptSingleInt32Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    OptSingleInt32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptSingleInt32.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptSingleInt32 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptSingleInt32.json"))
    val obj = OptSingleInt32Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptSingleInt32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptSingleInt32.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptSingleInt32 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptSingleInt32.unformatted.json"))
    val obj = OptSingleInt32Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptSingleInt32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptSingleInt32.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptSingleInt32 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptSingleInt32.gron"))
    val obj = OptSingleInt32Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    OptSingleInt32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptSingleInt32.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptSingleInt32 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_opt_single_int64(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptSingleInt64.msgpack"))
    val obj = OptSingleInt64Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    OptSingleInt64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptSingleInt64.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptSingleInt64 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptSingleInt64.json"))
    val obj = OptSingleInt64Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptSingleInt64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptSingleInt64.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptSingleInt64 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptSingleInt64.unformatted.json"))
    val obj = OptSingleInt64Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptSingleInt64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptSingleInt64.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptSingleInt64 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptSingleInt64.gron"))
    val obj = OptSingleInt64Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    OptSingleInt64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptSingleInt64.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptSingleInt64 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_opt_single_uint8(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptSingleUint8.msgpack"))
    val obj = OptSingleUint8Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    OptSingleUint8Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptSingleUint8.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptSingleUint8 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptSingleUint8.json"))
    val obj = OptSingleUint8Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptSingleUint8Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptSingleUint8.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptSingleUint8 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptSingleUint8.unformatted.json"))
    val obj = OptSingleUint8Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptSingleUint8Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptSingleUint8.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptSingleUint8 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptSingleUint8.gron"))
    val obj = OptSingleUint8Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    OptSingleUint8Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptSingleUint8.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptSingleUint8 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_opt_single_uint16(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptSingleUint16.msgpack"))
    val obj = OptSingleUint16Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    OptSingleUint16Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptSingleUint16.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptSingleUint16 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptSingleUint16.json"))
    val obj = OptSingleUint16Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptSingleUint16Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptSingleUint16.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptSingleUint16 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptSingleUint16.unformatted.json"))
    val obj = OptSingleUint16Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptSingleUint16Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptSingleUint16.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptSingleUint16 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptSingleUint16.gron"))
    val obj = OptSingleUint16Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    OptSingleUint16Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptSingleUint16.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptSingleUint16 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_opt_single_uint32(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptSingleUint32.msgpack"))
    val obj = OptSingleUint32Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    OptSingleUint32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptSingleUint32.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptSingleUint32 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptSingleUint32.json"))
    val obj = OptSingleUint32Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptSingleUint32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptSingleUint32.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptSingleUint32 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptSingleUint32.unformatted.json"))
    val obj = OptSingleUint32Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptSingleUint32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptSingleUint32.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptSingleUint32 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptSingleUint32.gron"))
    val obj = OptSingleUint32Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    OptSingleUint32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptSingleUint32.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptSingleUint32 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_opt_single_uint64(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptSingleUint64.msgpack"))
    val obj = OptSingleUint64Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    OptSingleUint64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptSingleUint64.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptSingleUint64 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptSingleUint64.json"))
    val obj = OptSingleUint64Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptSingleUint64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptSingleUint64.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptSingleUint64 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptSingleUint64.unformatted.json"))
    val obj = OptSingleUint64Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptSingleUint64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptSingleUint64.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptSingleUint64 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptSingleUint64.gron"))
    val obj = OptSingleUint64Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    OptSingleUint64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptSingleUint64.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptSingleUint64 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_opt_single_float32(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptSingleFloat32.msgpack"))
    val obj = OptSingleFloat32Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    OptSingleFloat32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptSingleFloat32.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptSingleFloat32 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptSingleFloat32.json"))
    val obj = OptSingleFloat32Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptSingleFloat32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptSingleFloat32.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptSingleFloat32 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptSingleFloat32.unformatted.json"))
    val obj = OptSingleFloat32Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptSingleFloat32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptSingleFloat32.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptSingleFloat32 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptSingleFloat32.gron"))
    val obj = OptSingleFloat32Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    OptSingleFloat32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptSingleFloat32.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptSingleFloat32 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_opt_single_float64(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptSingleFloat64.msgpack"))
    val obj = OptSingleFloat64Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    OptSingleFloat64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptSingleFloat64.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptSingleFloat64 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptSingleFloat64.json"))
    val obj = OptSingleFloat64Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptSingleFloat64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptSingleFloat64.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptSingleFloat64 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptSingleFloat64.unformatted.json"))
    val obj = OptSingleFloat64Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptSingleFloat64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptSingleFloat64.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptSingleFloat64 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptSingleFloat64.gron"))
    val obj = OptSingleFloat64Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    OptSingleFloat64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptSingleFloat64.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptSingleFloat64 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_opt_single_bytes(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptSingleBytes.msgpack"))
    val obj = OptSingleBytesCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    OptSingleBytesCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptSingleBytes.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptSingleBytes mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptSingleBytes.json"))
    val obj = OptSingleBytesCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptSingleBytesCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptSingleBytes.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptSingleBytes json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptSingleBytes.unformatted.json"))
    val obj = OptSingleBytesCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptSingleBytesCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptSingleBytes.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptSingleBytes unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptSingleBytes.gron"))
    val obj = OptSingleBytesCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    OptSingleBytesCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptSingleBytes.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptSingleBytes gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def run_AllTypes_Opt(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  Files.createDirectories(Paths.get(out))
  { val r = test_opt_single_string(vec, out); passed += r._1; failed += r._2 }
  { val r = test_opt_single_boolean(vec, out); passed += r._1; failed += r._2 }
  { val r = test_opt_single_int8(vec, out); passed += r._1; failed += r._2 }
  { val r = test_opt_single_int16(vec, out); passed += r._1; failed += r._2 }
  { val r = test_opt_single_int32(vec, out); passed += r._1; failed += r._2 }
  { val r = test_opt_single_int64(vec, out); passed += r._1; failed += r._2 }
  { val r = test_opt_single_uint8(vec, out); passed += r._1; failed += r._2 }
  { val r = test_opt_single_uint16(vec, out); passed += r._1; failed += r._2 }
  { val r = test_opt_single_uint32(vec, out); passed += r._1; failed += r._2 }
  { val r = test_opt_single_uint64(vec, out); passed += r._1; failed += r._2 }
  { val r = test_opt_single_float32(vec, out); passed += r._1; failed += r._2 }
  { val r = test_opt_single_float64(vec, out); passed += r._1; failed += r._2 }
  { val r = test_opt_single_bytes(vec, out); passed += r._1; failed += r._2 }
  (passed, failed)
}
