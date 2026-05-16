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

def test_model_arr1(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ModelArr1.msgpack"))
    val obj = ModelArr1Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    ModelArr1Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ModelArr1.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ModelArr1 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ModelArr1.json"))
    val obj = ModelArr1Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    ModelArr1Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ModelArr1.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ModelArr1 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ModelArr1.unformatted.json"))
    val obj = ModelArr1Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    ModelArr1Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ModelArr1.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ModelArr1 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ModelArr1.gron"))
    val obj = ModelArr1Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    ModelArr1Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ModelArr1.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ModelArr1 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_model_arr2(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ModelArr2.msgpack"))
    val obj = ModelArr2Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    ModelArr2Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ModelArr2.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ModelArr2 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ModelArr2.json"))
    val obj = ModelArr2Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    ModelArr2Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ModelArr2.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ModelArr2 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ModelArr2.unformatted.json"))
    val obj = ModelArr2Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    ModelArr2Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ModelArr2.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ModelArr2 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ModelArr2.gron"))
    val obj = ModelArr2Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    ModelArr2Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ModelArr2.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ModelArr2 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_model_arr3(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ModelArr3.msgpack"))
    val obj = ModelArr3Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    ModelArr3Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ModelArr3.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ModelArr3 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ModelArr3.json"))
    val obj = ModelArr3Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    ModelArr3Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ModelArr3.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ModelArr3 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ModelArr3.unformatted.json"))
    val obj = ModelArr3Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    ModelArr3Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ModelArr3.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ModelArr3 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ModelArr3.gron"))
    val obj = ModelArr3Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    ModelArr3Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ModelArr3.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ModelArr3 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_model_arr4(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ModelArr4.msgpack"))
    val obj = ModelArr4Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    ModelArr4Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ModelArr4.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ModelArr4 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ModelArr4.json"))
    val obj = ModelArr4Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    ModelArr4Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ModelArr4.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ModelArr4 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ModelArr4.unformatted.json"))
    val obj = ModelArr4Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    ModelArr4Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ModelArr4.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ModelArr4 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ModelArr4.gron"))
    val obj = ModelArr4Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    ModelArr4Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ModelArr4.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ModelArr4 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_model_arr5(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ModelArr5.msgpack"))
    val obj = ModelArr5Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    ModelArr5Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ModelArr5.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ModelArr5 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ModelArr5.json"))
    val obj = ModelArr5Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    ModelArr5Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ModelArr5.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ModelArr5 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ModelArr5.unformatted.json"))
    val obj = ModelArr5Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    ModelArr5Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ModelArr5.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ModelArr5 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ModelArr5.gron"))
    val obj = ModelArr5Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    ModelArr5Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ModelArr5.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ModelArr5 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_mix01(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Mix01.msgpack"))
    val obj = Mix01Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    Mix01Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Mix01.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Mix01 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Mix01.json"))
    val obj = Mix01Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Mix01Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Mix01.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Mix01 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Mix01.unformatted.json"))
    val obj = Mix01Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Mix01Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Mix01.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Mix01 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Mix01.gron"))
    val obj = Mix01Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    Mix01Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Mix01.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Mix01 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_mix02(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Mix02.msgpack"))
    val obj = Mix02Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    Mix02Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Mix02.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Mix02 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Mix02.json"))
    val obj = Mix02Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Mix02Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Mix02.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Mix02 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Mix02.unformatted.json"))
    val obj = Mix02Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Mix02Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Mix02.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Mix02 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Mix02.gron"))
    val obj = Mix02Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    Mix02Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Mix02.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Mix02 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_mix03(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Mix03.msgpack"))
    val obj = Mix03Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    Mix03Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Mix03.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Mix03 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Mix03.json"))
    val obj = Mix03Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Mix03Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Mix03.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Mix03 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Mix03.unformatted.json"))
    val obj = Mix03Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Mix03Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Mix03.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Mix03 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Mix03.gron"))
    val obj = Mix03Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    Mix03Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Mix03.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Mix03 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_mix04(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Mix04.msgpack"))
    val obj = Mix04Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    Mix04Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Mix04.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Mix04 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Mix04.json"))
    val obj = Mix04Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Mix04Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Mix04.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Mix04 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Mix04.unformatted.json"))
    val obj = Mix04Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Mix04Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Mix04.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Mix04 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Mix04.gron"))
    val obj = Mix04Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    Mix04Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Mix04.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Mix04 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_mix05(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Mix05.msgpack"))
    val obj = Mix05Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    Mix05Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Mix05.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Mix05 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Mix05.json"))
    val obj = Mix05Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Mix05Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Mix05.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Mix05 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Mix05.unformatted.json"))
    val obj = Mix05Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Mix05Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Mix05.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Mix05 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Mix05.gron"))
    val obj = Mix05Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    Mix05Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Mix05.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Mix05 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_mix06(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Mix06.msgpack"))
    val obj = Mix06Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    Mix06Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Mix06.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Mix06 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Mix06.json"))
    val obj = Mix06Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Mix06Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Mix06.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Mix06 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Mix06.unformatted.json"))
    val obj = Mix06Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Mix06Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Mix06.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Mix06 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Mix06.gron"))
    val obj = Mix06Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    Mix06Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Mix06.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Mix06 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_mix07(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Mix07.msgpack"))
    val obj = Mix07Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    Mix07Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Mix07.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Mix07 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Mix07.json"))
    val obj = Mix07Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Mix07Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Mix07.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Mix07 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Mix07.unformatted.json"))
    val obj = Mix07Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Mix07Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Mix07.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Mix07 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Mix07.gron"))
    val obj = Mix07Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    Mix07Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Mix07.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Mix07 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_mix08(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Mix08.msgpack"))
    val obj = Mix08Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    Mix08Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Mix08.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Mix08 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Mix08.json"))
    val obj = Mix08Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Mix08Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Mix08.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Mix08 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Mix08.unformatted.json"))
    val obj = Mix08Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Mix08Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Mix08.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Mix08 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Mix08.gron"))
    val obj = Mix08Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    Mix08Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Mix08.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Mix08 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_mix09(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Mix09.msgpack"))
    val obj = Mix09Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    Mix09Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Mix09.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Mix09 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Mix09.json"))
    val obj = Mix09Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Mix09Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Mix09.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Mix09 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Mix09.unformatted.json"))
    val obj = Mix09Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Mix09Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Mix09.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Mix09 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Mix09.gron"))
    val obj = Mix09Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    Mix09Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Mix09.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Mix09 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_mix10(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Mix10.msgpack"))
    val obj = Mix10Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    Mix10Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Mix10.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Mix10 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Mix10.json"))
    val obj = Mix10Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Mix10Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Mix10.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Mix10 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Mix10.unformatted.json"))
    val obj = Mix10Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Mix10Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Mix10.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Mix10 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Mix10.gron"))
    val obj = Mix10Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    Mix10Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Mix10.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Mix10 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_mix11(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Mix11.msgpack"))
    val obj = Mix11Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    Mix11Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Mix11.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Mix11 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Mix11.json"))
    val obj = Mix11Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Mix11Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Mix11.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Mix11 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Mix11.unformatted.json"))
    val obj = Mix11Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Mix11Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Mix11.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Mix11 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Mix11.gron"))
    val obj = Mix11Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    Mix11Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Mix11.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Mix11 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_mix12(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Mix12.msgpack"))
    val obj = Mix12Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    Mix12Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Mix12.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Mix12 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Mix12.json"))
    val obj = Mix12Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Mix12Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Mix12.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Mix12 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Mix12.unformatted.json"))
    val obj = Mix12Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Mix12Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Mix12.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Mix12 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Mix12.gron"))
    val obj = Mix12Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    Mix12Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Mix12.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Mix12 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_mix13(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Mix13.msgpack"))
    val obj = Mix13Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    Mix13Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Mix13.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Mix13 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Mix13.json"))
    val obj = Mix13Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Mix13Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Mix13.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Mix13 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Mix13.unformatted.json"))
    val obj = Mix13Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Mix13Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Mix13.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Mix13 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Mix13.gron"))
    val obj = Mix13Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    Mix13Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Mix13.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Mix13 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_mix14(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Mix14.msgpack"))
    val obj = Mix14Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    Mix14Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Mix14.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Mix14 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Mix14.json"))
    val obj = Mix14Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Mix14Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Mix14.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Mix14 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Mix14.unformatted.json"))
    val obj = Mix14Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Mix14Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Mix14.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Mix14 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Mix14.gron"))
    val obj = Mix14Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    Mix14Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Mix14.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Mix14 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_mix15(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Mix15.msgpack"))
    val obj = Mix15Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    Mix15Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Mix15.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Mix15 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Mix15.json"))
    val obj = Mix15Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Mix15Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Mix15.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Mix15 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Mix15.unformatted.json"))
    val obj = Mix15Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Mix15Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Mix15.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Mix15 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Mix15.gron"))
    val obj = Mix15Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    Mix15Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Mix15.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Mix15 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_all_opt1(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "AllOpt1.msgpack"))
    val obj = AllOpt1Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    AllOpt1Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "AllOpt1.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL AllOpt1 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "AllOpt1.json"))
    val obj = AllOpt1Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    AllOpt1Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "AllOpt1.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL AllOpt1 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "AllOpt1.unformatted.json"))
    val obj = AllOpt1Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    AllOpt1Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "AllOpt1.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL AllOpt1 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "AllOpt1.gron"))
    val obj = AllOpt1Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    AllOpt1Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "AllOpt1.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL AllOpt1 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_all_opt2(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "AllOpt2.msgpack"))
    val obj = AllOpt2Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    AllOpt2Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "AllOpt2.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL AllOpt2 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "AllOpt2.json"))
    val obj = AllOpt2Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    AllOpt2Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "AllOpt2.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL AllOpt2 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "AllOpt2.unformatted.json"))
    val obj = AllOpt2Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    AllOpt2Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "AllOpt2.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL AllOpt2 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "AllOpt2.gron"))
    val obj = AllOpt2Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    AllOpt2Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "AllOpt2.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL AllOpt2 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_all_opt3(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "AllOpt3.msgpack"))
    val obj = AllOpt3Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    AllOpt3Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "AllOpt3.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL AllOpt3 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "AllOpt3.json"))
    val obj = AllOpt3Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    AllOpt3Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "AllOpt3.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL AllOpt3 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "AllOpt3.unformatted.json"))
    val obj = AllOpt3Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    AllOpt3Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "AllOpt3.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL AllOpt3 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "AllOpt3.gron"))
    val obj = AllOpt3Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    AllOpt3Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "AllOpt3.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL AllOpt3 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_all_opt4(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "AllOpt4.msgpack"))
    val obj = AllOpt4Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    AllOpt4Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "AllOpt4.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL AllOpt4 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "AllOpt4.json"))
    val obj = AllOpt4Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    AllOpt4Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "AllOpt4.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL AllOpt4 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "AllOpt4.unformatted.json"))
    val obj = AllOpt4Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    AllOpt4Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "AllOpt4.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL AllOpt4 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "AllOpt4.gron"))
    val obj = AllOpt4Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    AllOpt4Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "AllOpt4.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL AllOpt4 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_all_opt5(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "AllOpt5.msgpack"))
    val obj = AllOpt5Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    AllOpt5Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "AllOpt5.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL AllOpt5 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "AllOpt5.json"))
    val obj = AllOpt5Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    AllOpt5Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "AllOpt5.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL AllOpt5 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "AllOpt5.unformatted.json"))
    val obj = AllOpt5Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    AllOpt5Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "AllOpt5.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL AllOpt5 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "AllOpt5.gron"))
    val obj = AllOpt5Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    AllOpt5Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "AllOpt5.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL AllOpt5 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def run_AllTypes_Mixed(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  Files.createDirectories(Paths.get(out))
  { val r = test_model_arr1(vec, out); passed += r._1; failed += r._2 }
  { val r = test_model_arr2(vec, out); passed += r._1; failed += r._2 }
  { val r = test_model_arr3(vec, out); passed += r._1; failed += r._2 }
  { val r = test_model_arr4(vec, out); passed += r._1; failed += r._2 }
  { val r = test_model_arr5(vec, out); passed += r._1; failed += r._2 }
  { val r = test_mix01(vec, out); passed += r._1; failed += r._2 }
  { val r = test_mix02(vec, out); passed += r._1; failed += r._2 }
  { val r = test_mix03(vec, out); passed += r._1; failed += r._2 }
  { val r = test_mix04(vec, out); passed += r._1; failed += r._2 }
  { val r = test_mix05(vec, out); passed += r._1; failed += r._2 }
  { val r = test_mix06(vec, out); passed += r._1; failed += r._2 }
  { val r = test_mix07(vec, out); passed += r._1; failed += r._2 }
  { val r = test_mix08(vec, out); passed += r._1; failed += r._2 }
  { val r = test_mix09(vec, out); passed += r._1; failed += r._2 }
  { val r = test_mix10(vec, out); passed += r._1; failed += r._2 }
  { val r = test_mix11(vec, out); passed += r._1; failed += r._2 }
  { val r = test_mix12(vec, out); passed += r._1; failed += r._2 }
  { val r = test_mix13(vec, out); passed += r._1; failed += r._2 }
  { val r = test_mix14(vec, out); passed += r._1; failed += r._2 }
  { val r = test_mix15(vec, out); passed += r._1; failed += r._2 }
  { val r = test_all_opt1(vec, out); passed += r._1; failed += r._2 }
  { val r = test_all_opt2(vec, out); passed += r._1; failed += r._2 }
  { val r = test_all_opt3(vec, out); passed += r._1; failed += r._2 }
  { val r = test_all_opt4(vec, out); passed += r._1; failed += r._2 }
  { val r = test_all_opt5(vec, out); passed += r._1; failed += r._2 }
  (passed, failed)
}
