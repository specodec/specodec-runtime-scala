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

def test_five01(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Five01.msgpack"))
    val obj = Five01Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    Five01Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Five01.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Five01 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Five01.json"))
    val obj = Five01Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Five01Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Five01.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Five01 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Five01.unformatted.json"))
    val obj = Five01Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Five01Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Five01.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Five01 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Five01.gron"))
    val obj = Five01Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    Five01Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Five01.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Five01 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_five02(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Five02.msgpack"))
    val obj = Five02Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    Five02Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Five02.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Five02 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Five02.json"))
    val obj = Five02Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Five02Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Five02.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Five02 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Five02.unformatted.json"))
    val obj = Five02Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Five02Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Five02.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Five02 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Five02.gron"))
    val obj = Five02Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    Five02Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Five02.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Five02 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_five03(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Five03.msgpack"))
    val obj = Five03Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    Five03Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Five03.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Five03 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Five03.json"))
    val obj = Five03Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Five03Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Five03.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Five03 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Five03.unformatted.json"))
    val obj = Five03Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Five03Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Five03.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Five03 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Five03.gron"))
    val obj = Five03Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    Five03Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Five03.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Five03 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_five04(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Five04.msgpack"))
    val obj = Five04Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    Five04Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Five04.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Five04 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Five04.json"))
    val obj = Five04Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Five04Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Five04.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Five04 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Five04.unformatted.json"))
    val obj = Five04Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Five04Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Five04.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Five04 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Five04.gron"))
    val obj = Five04Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    Five04Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Five04.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Five04 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_five05(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Five05.msgpack"))
    val obj = Five05Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    Five05Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Five05.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Five05 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Five05.json"))
    val obj = Five05Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Five05Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Five05.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Five05 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Five05.unformatted.json"))
    val obj = Five05Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Five05Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Five05.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Five05 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Five05.gron"))
    val obj = Five05Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    Five05Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Five05.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Five05 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_five06(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Five06.msgpack"))
    val obj = Five06Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    Five06Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Five06.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Five06 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Five06.json"))
    val obj = Five06Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Five06Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Five06.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Five06 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Five06.unformatted.json"))
    val obj = Five06Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Five06Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Five06.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Five06 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Five06.gron"))
    val obj = Five06Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    Five06Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Five06.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Five06 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_five07(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Five07.msgpack"))
    val obj = Five07Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    Five07Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Five07.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Five07 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Five07.json"))
    val obj = Five07Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Five07Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Five07.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Five07 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Five07.unformatted.json"))
    val obj = Five07Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Five07Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Five07.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Five07 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Five07.gron"))
    val obj = Five07Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    Five07Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Five07.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Five07 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_five08(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Five08.msgpack"))
    val obj = Five08Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    Five08Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Five08.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Five08 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Five08.json"))
    val obj = Five08Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Five08Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Five08.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Five08 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Five08.unformatted.json"))
    val obj = Five08Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Five08Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Five08.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Five08 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Five08.gron"))
    val obj = Five08Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    Five08Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Five08.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Five08 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_five09(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Five09.msgpack"))
    val obj = Five09Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    Five09Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Five09.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Five09 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Five09.json"))
    val obj = Five09Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Five09Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Five09.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Five09 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Five09.unformatted.json"))
    val obj = Five09Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Five09Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Five09.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Five09 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Five09.gron"))
    val obj = Five09Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    Five09Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Five09.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Five09 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_five10(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Five10.msgpack"))
    val obj = Five10Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    Five10Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Five10.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Five10 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Five10.json"))
    val obj = Five10Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Five10Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Five10.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Five10 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Five10.unformatted.json"))
    val obj = Five10Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Five10Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Five10.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Five10 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Five10.gron"))
    val obj = Five10Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    Five10Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Five10.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Five10 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_ten01(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Ten01.msgpack"))
    val obj = Ten01Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    Ten01Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Ten01.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Ten01 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Ten01.json"))
    val obj = Ten01Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Ten01Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Ten01.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Ten01 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Ten01.unformatted.json"))
    val obj = Ten01Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Ten01Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Ten01.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Ten01 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Ten01.gron"))
    val obj = Ten01Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    Ten01Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Ten01.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Ten01 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_ten02(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Ten02.msgpack"))
    val obj = Ten02Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    Ten02Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Ten02.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Ten02 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Ten02.json"))
    val obj = Ten02Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Ten02Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Ten02.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Ten02 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Ten02.unformatted.json"))
    val obj = Ten02Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Ten02Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Ten02.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Ten02 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Ten02.gron"))
    val obj = Ten02Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    Ten02Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Ten02.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Ten02 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_ten03(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Ten03.msgpack"))
    val obj = Ten03Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    Ten03Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Ten03.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Ten03 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Ten03.json"))
    val obj = Ten03Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Ten03Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Ten03.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Ten03 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Ten03.unformatted.json"))
    val obj = Ten03Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Ten03Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Ten03.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Ten03 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Ten03.gron"))
    val obj = Ten03Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    Ten03Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Ten03.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Ten03 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_ten04(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Ten04.msgpack"))
    val obj = Ten04Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    Ten04Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Ten04.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Ten04 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Ten04.json"))
    val obj = Ten04Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Ten04Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Ten04.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Ten04 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Ten04.unformatted.json"))
    val obj = Ten04Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Ten04Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Ten04.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Ten04 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Ten04.gron"))
    val obj = Ten04Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    Ten04Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Ten04.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Ten04 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_ten05(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Ten05.msgpack"))
    val obj = Ten05Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    Ten05Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Ten05.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Ten05 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Ten05.json"))
    val obj = Ten05Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Ten05Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Ten05.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Ten05 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Ten05.unformatted.json"))
    val obj = Ten05Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Ten05Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Ten05.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Ten05 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Ten05.gron"))
    val obj = Ten05Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    Ten05Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Ten05.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Ten05 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def run_AllTypes_Many(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  Files.createDirectories(Paths.get(out))
  { val r = test_five01(vec, out); passed += r._1; failed += r._2 }
  { val r = test_five02(vec, out); passed += r._1; failed += r._2 }
  { val r = test_five03(vec, out); passed += r._1; failed += r._2 }
  { val r = test_five04(vec, out); passed += r._1; failed += r._2 }
  { val r = test_five05(vec, out); passed += r._1; failed += r._2 }
  { val r = test_five06(vec, out); passed += r._1; failed += r._2 }
  { val r = test_five07(vec, out); passed += r._1; failed += r._2 }
  { val r = test_five08(vec, out); passed += r._1; failed += r._2 }
  { val r = test_five09(vec, out); passed += r._1; failed += r._2 }
  { val r = test_five10(vec, out); passed += r._1; failed += r._2 }
  { val r = test_ten01(vec, out); passed += r._1; failed += r._2 }
  { val r = test_ten02(vec, out); passed += r._1; failed += r._2 }
  { val r = test_ten03(vec, out); passed += r._1; failed += r._2 }
  { val r = test_ten04(vec, out); passed += r._1; failed += r._2 }
  { val r = test_ten05(vec, out); passed += r._1; failed += r._2 }
  (passed, failed)
}
