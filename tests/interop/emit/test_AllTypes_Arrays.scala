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

def test_arr_string(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ArrString.msgpack"))
    val obj = ArrStringCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    ArrStringCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ArrString.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ArrString mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ArrString.json"))
    val obj = ArrStringCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    ArrStringCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ArrString.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ArrString json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ArrString.unformatted.json"))
    val obj = ArrStringCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    ArrStringCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ArrString.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ArrString unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ArrString.gron"))
    val obj = ArrStringCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    ArrStringCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ArrString.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ArrString gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_arr_int32(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ArrInt32.msgpack"))
    val obj = ArrInt32Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    ArrInt32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ArrInt32.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ArrInt32 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ArrInt32.json"))
    val obj = ArrInt32Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    ArrInt32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ArrInt32.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ArrInt32 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ArrInt32.unformatted.json"))
    val obj = ArrInt32Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    ArrInt32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ArrInt32.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ArrInt32 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ArrInt32.gron"))
    val obj = ArrInt32Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    ArrInt32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ArrInt32.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ArrInt32 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_arr_boolean(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ArrBoolean.msgpack"))
    val obj = ArrBooleanCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    ArrBooleanCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ArrBoolean.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ArrBoolean mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ArrBoolean.json"))
    val obj = ArrBooleanCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    ArrBooleanCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ArrBoolean.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ArrBoolean json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ArrBoolean.unformatted.json"))
    val obj = ArrBooleanCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    ArrBooleanCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ArrBoolean.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ArrBoolean unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ArrBoolean.gron"))
    val obj = ArrBooleanCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    ArrBooleanCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ArrBoolean.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ArrBoolean gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_arr_float64(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ArrFloat64.msgpack"))
    val obj = ArrFloat64Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    ArrFloat64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ArrFloat64.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ArrFloat64 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ArrFloat64.json"))
    val obj = ArrFloat64Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    ArrFloat64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ArrFloat64.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ArrFloat64 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ArrFloat64.unformatted.json"))
    val obj = ArrFloat64Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    ArrFloat64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ArrFloat64.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ArrFloat64 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ArrFloat64.gron"))
    val obj = ArrFloat64Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    ArrFloat64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ArrFloat64.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ArrFloat64 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_arr_bytes(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ArrBytes.msgpack"))
    val obj = ArrBytesCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    ArrBytesCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ArrBytes.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ArrBytes mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ArrBytes.json"))
    val obj = ArrBytesCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    ArrBytesCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ArrBytes.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ArrBytes json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ArrBytes.unformatted.json"))
    val obj = ArrBytesCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    ArrBytesCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ArrBytes.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ArrBytes unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ArrBytes.gron"))
    val obj = ArrBytesCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    ArrBytesCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ArrBytes.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ArrBytes gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_arr_int64(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ArrInt64.msgpack"))
    val obj = ArrInt64Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    ArrInt64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ArrInt64.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ArrInt64 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ArrInt64.json"))
    val obj = ArrInt64Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    ArrInt64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ArrInt64.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ArrInt64 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ArrInt64.unformatted.json"))
    val obj = ArrInt64Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    ArrInt64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ArrInt64.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ArrInt64 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ArrInt64.gron"))
    val obj = ArrInt64Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    ArrInt64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ArrInt64.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ArrInt64 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_arr_uint64(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ArrUint64.msgpack"))
    val obj = ArrUint64Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    ArrUint64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ArrUint64.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ArrUint64 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ArrUint64.json"))
    val obj = ArrUint64Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    ArrUint64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ArrUint64.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ArrUint64 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ArrUint64.unformatted.json"))
    val obj = ArrUint64Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    ArrUint64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ArrUint64.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ArrUint64 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ArrUint64.gron"))
    val obj = ArrUint64Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    ArrUint64Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ArrUint64.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ArrUint64 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_multi_arr1(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "MultiArr1.msgpack"))
    val obj = MultiArr1Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    MultiArr1Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "MultiArr1.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL MultiArr1 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "MultiArr1.json"))
    val obj = MultiArr1Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    MultiArr1Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "MultiArr1.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL MultiArr1 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "MultiArr1.unformatted.json"))
    val obj = MultiArr1Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    MultiArr1Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "MultiArr1.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL MultiArr1 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "MultiArr1.gron"))
    val obj = MultiArr1Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    MultiArr1Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "MultiArr1.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL MultiArr1 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_multi_arr2(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "MultiArr2.msgpack"))
    val obj = MultiArr2Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    MultiArr2Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "MultiArr2.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL MultiArr2 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "MultiArr2.json"))
    val obj = MultiArr2Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    MultiArr2Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "MultiArr2.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL MultiArr2 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "MultiArr2.unformatted.json"))
    val obj = MultiArr2Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    MultiArr2Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "MultiArr2.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL MultiArr2 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "MultiArr2.gron"))
    val obj = MultiArr2Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    MultiArr2Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "MultiArr2.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL MultiArr2 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_multi_arr3(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "MultiArr3.msgpack"))
    val obj = MultiArr3Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    MultiArr3Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "MultiArr3.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL MultiArr3 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "MultiArr3.json"))
    val obj = MultiArr3Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    MultiArr3Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "MultiArr3.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL MultiArr3 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "MultiArr3.unformatted.json"))
    val obj = MultiArr3Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    MultiArr3Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "MultiArr3.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL MultiArr3 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "MultiArr3.gron"))
    val obj = MultiArr3Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    MultiArr3Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "MultiArr3.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL MultiArr3 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_multi_arr4(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "MultiArr4.msgpack"))
    val obj = MultiArr4Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    MultiArr4Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "MultiArr4.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL MultiArr4 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "MultiArr4.json"))
    val obj = MultiArr4Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    MultiArr4Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "MultiArr4.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL MultiArr4 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "MultiArr4.unformatted.json"))
    val obj = MultiArr4Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    MultiArr4Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "MultiArr4.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL MultiArr4 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "MultiArr4.gron"))
    val obj = MultiArr4Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    MultiArr4Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "MultiArr4.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL MultiArr4 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_multi_arr5(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "MultiArr5.msgpack"))
    val obj = MultiArr5Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    MultiArr5Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "MultiArr5.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL MultiArr5 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "MultiArr5.json"))
    val obj = MultiArr5Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    MultiArr5Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "MultiArr5.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL MultiArr5 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "MultiArr5.unformatted.json"))
    val obj = MultiArr5Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    MultiArr5Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "MultiArr5.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL MultiArr5 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "MultiArr5.gron"))
    val obj = MultiArr5Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    MultiArr5Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "MultiArr5.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL MultiArr5 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_opt_combo1(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptCombo1.msgpack"))
    val obj = OptCombo1Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    OptCombo1Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptCombo1.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptCombo1 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptCombo1.json"))
    val obj = OptCombo1Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptCombo1Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptCombo1.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptCombo1 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptCombo1.unformatted.json"))
    val obj = OptCombo1Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptCombo1Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptCombo1.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptCombo1 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptCombo1.gron"))
    val obj = OptCombo1Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    OptCombo1Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptCombo1.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptCombo1 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_opt_combo2(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptCombo2.msgpack"))
    val obj = OptCombo2Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    OptCombo2Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptCombo2.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptCombo2 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptCombo2.json"))
    val obj = OptCombo2Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptCombo2Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptCombo2.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptCombo2 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptCombo2.unformatted.json"))
    val obj = OptCombo2Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptCombo2Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptCombo2.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptCombo2 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptCombo2.gron"))
    val obj = OptCombo2Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    OptCombo2Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptCombo2.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptCombo2 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_opt_combo3(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptCombo3.msgpack"))
    val obj = OptCombo3Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    OptCombo3Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptCombo3.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptCombo3 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptCombo3.json"))
    val obj = OptCombo3Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptCombo3Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptCombo3.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptCombo3 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptCombo3.unformatted.json"))
    val obj = OptCombo3Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptCombo3Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptCombo3.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptCombo3 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptCombo3.gron"))
    val obj = OptCombo3Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    OptCombo3Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptCombo3.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptCombo3 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_opt_combo4(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptCombo4.msgpack"))
    val obj = OptCombo4Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    OptCombo4Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptCombo4.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptCombo4 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptCombo4.json"))
    val obj = OptCombo4Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptCombo4Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptCombo4.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptCombo4 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptCombo4.unformatted.json"))
    val obj = OptCombo4Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptCombo4Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptCombo4.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptCombo4 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptCombo4.gron"))
    val obj = OptCombo4Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    OptCombo4Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptCombo4.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptCombo4 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_opt_combo5(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptCombo5.msgpack"))
    val obj = OptCombo5Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    OptCombo5Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptCombo5.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptCombo5 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptCombo5.json"))
    val obj = OptCombo5Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptCombo5Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptCombo5.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptCombo5 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptCombo5.unformatted.json"))
    val obj = OptCombo5Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptCombo5Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptCombo5.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptCombo5 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptCombo5.gron"))
    val obj = OptCombo5Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    OptCombo5Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptCombo5.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptCombo5 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_opt_combo6(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptCombo6.msgpack"))
    val obj = OptCombo6Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    OptCombo6Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptCombo6.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptCombo6 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptCombo6.json"))
    val obj = OptCombo6Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptCombo6Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptCombo6.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptCombo6 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptCombo6.unformatted.json"))
    val obj = OptCombo6Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptCombo6Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptCombo6.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptCombo6 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptCombo6.gron"))
    val obj = OptCombo6Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    OptCombo6Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptCombo6.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptCombo6 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_opt_combo7(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptCombo7.msgpack"))
    val obj = OptCombo7Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    OptCombo7Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptCombo7.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptCombo7 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptCombo7.json"))
    val obj = OptCombo7Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptCombo7Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptCombo7.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptCombo7 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptCombo7.unformatted.json"))
    val obj = OptCombo7Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptCombo7Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptCombo7.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptCombo7 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptCombo7.gron"))
    val obj = OptCombo7Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    OptCombo7Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptCombo7.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptCombo7 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_opt_combo8(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptCombo8.msgpack"))
    val obj = OptCombo8Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    OptCombo8Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptCombo8.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptCombo8 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptCombo8.json"))
    val obj = OptCombo8Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptCombo8Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptCombo8.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptCombo8 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptCombo8.unformatted.json"))
    val obj = OptCombo8Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptCombo8Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptCombo8.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptCombo8 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptCombo8.gron"))
    val obj = OptCombo8Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    OptCombo8Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptCombo8.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptCombo8 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_opt_combo9(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptCombo9.msgpack"))
    val obj = OptCombo9Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    OptCombo9Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptCombo9.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptCombo9 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptCombo9.json"))
    val obj = OptCombo9Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptCombo9Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptCombo9.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptCombo9 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptCombo9.unformatted.json"))
    val obj = OptCombo9Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptCombo9Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptCombo9.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptCombo9 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptCombo9.gron"))
    val obj = OptCombo9Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    OptCombo9Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptCombo9.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptCombo9 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_opt_combo10(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptCombo10.msgpack"))
    val obj = OptCombo10Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    OptCombo10Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptCombo10.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptCombo10 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptCombo10.json"))
    val obj = OptCombo10Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptCombo10Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptCombo10.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptCombo10 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptCombo10.unformatted.json"))
    val obj = OptCombo10Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptCombo10Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptCombo10.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptCombo10 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptCombo10.gron"))
    val obj = OptCombo10Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    OptCombo10Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptCombo10.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptCombo10 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def run_AllTypes_Arrays(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  Files.createDirectories(Paths.get(out))
  { val r = test_arr_string(vec, out); passed += r._1; failed += r._2 }
  { val r = test_arr_int32(vec, out); passed += r._1; failed += r._2 }
  { val r = test_arr_boolean(vec, out); passed += r._1; failed += r._2 }
  { val r = test_arr_float64(vec, out); passed += r._1; failed += r._2 }
  { val r = test_arr_bytes(vec, out); passed += r._1; failed += r._2 }
  { val r = test_arr_int64(vec, out); passed += r._1; failed += r._2 }
  { val r = test_arr_uint64(vec, out); passed += r._1; failed += r._2 }
  { val r = test_multi_arr1(vec, out); passed += r._1; failed += r._2 }
  { val r = test_multi_arr2(vec, out); passed += r._1; failed += r._2 }
  { val r = test_multi_arr3(vec, out); passed += r._1; failed += r._2 }
  { val r = test_multi_arr4(vec, out); passed += r._1; failed += r._2 }
  { val r = test_multi_arr5(vec, out); passed += r._1; failed += r._2 }
  { val r = test_opt_combo1(vec, out); passed += r._1; failed += r._2 }
  { val r = test_opt_combo2(vec, out); passed += r._1; failed += r._2 }
  { val r = test_opt_combo3(vec, out); passed += r._1; failed += r._2 }
  { val r = test_opt_combo4(vec, out); passed += r._1; failed += r._2 }
  { val r = test_opt_combo5(vec, out); passed += r._1; failed += r._2 }
  { val r = test_opt_combo6(vec, out); passed += r._1; failed += r._2 }
  { val r = test_opt_combo7(vec, out); passed += r._1; failed += r._2 }
  { val r = test_opt_combo8(vec, out); passed += r._1; failed += r._2 }
  { val r = test_opt_combo9(vec, out); passed += r._1; failed += r._2 }
  { val r = test_opt_combo10(vec, out); passed += r._1; failed += r._2 }
  (passed, failed)
}
