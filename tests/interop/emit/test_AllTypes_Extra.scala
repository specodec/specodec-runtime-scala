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

def test_opt_arr1(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptArr1.msgpack"))
    val obj = OptArr1Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    OptArr1Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptArr1.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptArr1 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptArr1.json"))
    val obj = OptArr1Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptArr1Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptArr1.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptArr1 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptArr1.unformatted.json"))
    val obj = OptArr1Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptArr1Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptArr1.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptArr1 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptArr1.gron"))
    val obj = OptArr1Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    OptArr1Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptArr1.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptArr1 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_opt_arr2(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptArr2.msgpack"))
    val obj = OptArr2Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    OptArr2Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptArr2.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptArr2 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptArr2.json"))
    val obj = OptArr2Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptArr2Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptArr2.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptArr2 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptArr2.unformatted.json"))
    val obj = OptArr2Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptArr2Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptArr2.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptArr2 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptArr2.gron"))
    val obj = OptArr2Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    OptArr2Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptArr2.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptArr2 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_opt_arr3(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptArr3.msgpack"))
    val obj = OptArr3Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    OptArr3Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptArr3.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptArr3 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptArr3.json"))
    val obj = OptArr3Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptArr3Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptArr3.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptArr3 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptArr3.unformatted.json"))
    val obj = OptArr3Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptArr3Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptArr3.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptArr3 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptArr3.gron"))
    val obj = OptArr3Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    OptArr3Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptArr3.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptArr3 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_opt_arr4(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptArr4.msgpack"))
    val obj = OptArr4Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    OptArr4Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptArr4.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptArr4 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptArr4.json"))
    val obj = OptArr4Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptArr4Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptArr4.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptArr4 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptArr4.unformatted.json"))
    val obj = OptArr4Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptArr4Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptArr4.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptArr4 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptArr4.gron"))
    val obj = OptArr4Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    OptArr4Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptArr4.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptArr4 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_opt_arr5(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptArr5.msgpack"))
    val obj = OptArr5Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    OptArr5Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptArr5.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptArr5 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptArr5.json"))
    val obj = OptArr5Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptArr5Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptArr5.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptArr5 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptArr5.unformatted.json"))
    val obj = OptArr5Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptArr5Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptArr5.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptArr5 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptArr5.gron"))
    val obj = OptArr5Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    OptArr5Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptArr5.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptArr5 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_nest_opt1(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestOpt1.msgpack"))
    val obj = NestOpt1Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    NestOpt1Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestOpt1.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestOpt1 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestOpt1.json"))
    val obj = NestOpt1Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    NestOpt1Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestOpt1.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestOpt1 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestOpt1.unformatted.json"))
    val obj = NestOpt1Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    NestOpt1Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestOpt1.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestOpt1 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestOpt1.gron"))
    val obj = NestOpt1Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    NestOpt1Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestOpt1.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestOpt1 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_nest_opt2(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestOpt2.msgpack"))
    val obj = NestOpt2Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    NestOpt2Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestOpt2.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestOpt2 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestOpt2.json"))
    val obj = NestOpt2Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    NestOpt2Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestOpt2.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestOpt2 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestOpt2.unformatted.json"))
    val obj = NestOpt2Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    NestOpt2Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestOpt2.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestOpt2 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestOpt2.gron"))
    val obj = NestOpt2Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    NestOpt2Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestOpt2.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestOpt2 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_nest_opt3(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestOpt3.msgpack"))
    val obj = NestOpt3Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    NestOpt3Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestOpt3.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestOpt3 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestOpt3.json"))
    val obj = NestOpt3Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    NestOpt3Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestOpt3.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestOpt3 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestOpt3.unformatted.json"))
    val obj = NestOpt3Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    NestOpt3Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestOpt3.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestOpt3 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestOpt3.gron"))
    val obj = NestOpt3Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    NestOpt3Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestOpt3.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestOpt3 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_nest_opt4(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestOpt4.msgpack"))
    val obj = NestOpt4Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    NestOpt4Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestOpt4.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestOpt4 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestOpt4.json"))
    val obj = NestOpt4Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    NestOpt4Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestOpt4.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestOpt4 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestOpt4.unformatted.json"))
    val obj = NestOpt4Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    NestOpt4Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestOpt4.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestOpt4 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestOpt4.gron"))
    val obj = NestOpt4Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    NestOpt4Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestOpt4.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestOpt4 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_nest_opt5(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestOpt5.msgpack"))
    val obj = NestOpt5Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    NestOpt5Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestOpt5.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestOpt5 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestOpt5.json"))
    val obj = NestOpt5Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    NestOpt5Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestOpt5.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestOpt5 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestOpt5.unformatted.json"))
    val obj = NestOpt5Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    NestOpt5Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestOpt5.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestOpt5 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestOpt5.gron"))
    val obj = NestOpt5Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    NestOpt5Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestOpt5.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestOpt5 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_nest_opt_inner1(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestOptInner1.msgpack"))
    val obj = NestOptInner1Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    NestOptInner1Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestOptInner1.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestOptInner1 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestOptInner1.json"))
    val obj = NestOptInner1Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    NestOptInner1Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestOptInner1.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestOptInner1 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestOptInner1.unformatted.json"))
    val obj = NestOptInner1Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    NestOptInner1Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestOptInner1.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestOptInner1 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestOptInner1.gron"))
    val obj = NestOptInner1Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    NestOptInner1Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestOptInner1.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestOptInner1 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_nest_opt_inner2(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestOptInner2.msgpack"))
    val obj = NestOptInner2Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    NestOptInner2Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestOptInner2.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestOptInner2 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestOptInner2.json"))
    val obj = NestOptInner2Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    NestOptInner2Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestOptInner2.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestOptInner2 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestOptInner2.unformatted.json"))
    val obj = NestOptInner2Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    NestOptInner2Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestOptInner2.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestOptInner2 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestOptInner2.gron"))
    val obj = NestOptInner2Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    NestOptInner2Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestOptInner2.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestOptInner2 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_nest_opt_inner3(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestOptInner3.msgpack"))
    val obj = NestOptInner3Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    NestOptInner3Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestOptInner3.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestOptInner3 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestOptInner3.json"))
    val obj = NestOptInner3Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    NestOptInner3Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestOptInner3.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestOptInner3 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestOptInner3.unformatted.json"))
    val obj = NestOptInner3Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    NestOptInner3Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestOptInner3.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestOptInner3 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestOptInner3.gron"))
    val obj = NestOptInner3Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    NestOptInner3Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestOptInner3.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestOptInner3 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_deep_nest1(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DeepNest1.msgpack"))
    val obj = DeepNest1Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    DeepNest1Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DeepNest1.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DeepNest1 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DeepNest1.json"))
    val obj = DeepNest1Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DeepNest1Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DeepNest1.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DeepNest1 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DeepNest1.unformatted.json"))
    val obj = DeepNest1Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DeepNest1Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DeepNest1.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DeepNest1 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DeepNest1.gron"))
    val obj = DeepNest1Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    DeepNest1Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DeepNest1.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DeepNest1 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_deep_nest2(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DeepNest2.msgpack"))
    val obj = DeepNest2Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    DeepNest2Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DeepNest2.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DeepNest2 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DeepNest2.json"))
    val obj = DeepNest2Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DeepNest2Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DeepNest2.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DeepNest2 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DeepNest2.unformatted.json"))
    val obj = DeepNest2Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DeepNest2Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DeepNest2.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DeepNest2 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DeepNest2.gron"))
    val obj = DeepNest2Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    DeepNest2Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DeepNest2.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DeepNest2 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_deep_nest3(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DeepNest3.msgpack"))
    val obj = DeepNest3Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    DeepNest3Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DeepNest3.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DeepNest3 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DeepNest3.json"))
    val obj = DeepNest3Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DeepNest3Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DeepNest3.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DeepNest3 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DeepNest3.unformatted.json"))
    val obj = DeepNest3Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DeepNest3Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DeepNest3.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DeepNest3 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DeepNest3.gron"))
    val obj = DeepNest3Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    DeepNest3Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DeepNest3.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DeepNest3 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_deep_nest4(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DeepNest4.msgpack"))
    val obj = DeepNest4Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    DeepNest4Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DeepNest4.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DeepNest4 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DeepNest4.json"))
    val obj = DeepNest4Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DeepNest4Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DeepNest4.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DeepNest4 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DeepNest4.unformatted.json"))
    val obj = DeepNest4Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DeepNest4Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DeepNest4.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DeepNest4 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DeepNest4.gron"))
    val obj = DeepNest4Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    DeepNest4Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DeepNest4.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DeepNest4 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_deep_nest5(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DeepNest5.msgpack"))
    val obj = DeepNest5Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    DeepNest5Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DeepNest5.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DeepNest5 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DeepNest5.json"))
    val obj = DeepNest5Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DeepNest5Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DeepNest5.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DeepNest5 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DeepNest5.unformatted.json"))
    val obj = DeepNest5Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DeepNest5Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DeepNest5.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DeepNest5 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DeepNest5.gron"))
    val obj = DeepNest5Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    DeepNest5Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DeepNest5.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DeepNest5 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_deep_nest6(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DeepNest6.msgpack"))
    val obj = DeepNest6Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    DeepNest6Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DeepNest6.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DeepNest6 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DeepNest6.json"))
    val obj = DeepNest6Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DeepNest6Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DeepNest6.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DeepNest6 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DeepNest6.unformatted.json"))
    val obj = DeepNest6Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DeepNest6Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DeepNest6.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DeepNest6 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DeepNest6.gron"))
    val obj = DeepNest6Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    DeepNest6Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DeepNest6.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DeepNest6 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_deep_nest7(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DeepNest7.msgpack"))
    val obj = DeepNest7Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    DeepNest7Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DeepNest7.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DeepNest7 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DeepNest7.json"))
    val obj = DeepNest7Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DeepNest7Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DeepNest7.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DeepNest7 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DeepNest7.unformatted.json"))
    val obj = DeepNest7Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DeepNest7Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DeepNest7.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DeepNest7 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DeepNest7.gron"))
    val obj = DeepNest7Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    DeepNest7Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DeepNest7.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DeepNest7 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_timestamp_entry(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "TimestampEntry.msgpack"))
    val obj = TimestampEntryCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    TimestampEntryCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "TimestampEntry.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL TimestampEntry mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "TimestampEntry.json"))
    val obj = TimestampEntryCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    TimestampEntryCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "TimestampEntry.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL TimestampEntry json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "TimestampEntry.unformatted.json"))
    val obj = TimestampEntryCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    TimestampEntryCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "TimestampEntry.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL TimestampEntry unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "TimestampEntry.gron"))
    val obj = TimestampEntryCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    TimestampEntryCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "TimestampEntry.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL TimestampEntry gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_config_entry(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ConfigEntry.msgpack"))
    val obj = ConfigEntryCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    ConfigEntryCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ConfigEntry.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ConfigEntry mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ConfigEntry.json"))
    val obj = ConfigEntryCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    ConfigEntryCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ConfigEntry.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ConfigEntry json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ConfigEntry.unformatted.json"))
    val obj = ConfigEntryCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    ConfigEntryCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ConfigEntry.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ConfigEntry unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ConfigEntry.gron"))
    val obj = ConfigEntryCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    ConfigEntryCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ConfigEntry.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ConfigEntry gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def run_AllTypes_Extra(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  Files.createDirectories(Paths.get(out))
  { val r = test_opt_arr1(vec, out); passed += r._1; failed += r._2 }
  { val r = test_opt_arr2(vec, out); passed += r._1; failed += r._2 }
  { val r = test_opt_arr3(vec, out); passed += r._1; failed += r._2 }
  { val r = test_opt_arr4(vec, out); passed += r._1; failed += r._2 }
  { val r = test_opt_arr5(vec, out); passed += r._1; failed += r._2 }
  { val r = test_nest_opt1(vec, out); passed += r._1; failed += r._2 }
  { val r = test_nest_opt2(vec, out); passed += r._1; failed += r._2 }
  { val r = test_nest_opt3(vec, out); passed += r._1; failed += r._2 }
  { val r = test_nest_opt4(vec, out); passed += r._1; failed += r._2 }
  { val r = test_nest_opt5(vec, out); passed += r._1; failed += r._2 }
  { val r = test_nest_opt_inner1(vec, out); passed += r._1; failed += r._2 }
  { val r = test_nest_opt_inner2(vec, out); passed += r._1; failed += r._2 }
  { val r = test_nest_opt_inner3(vec, out); passed += r._1; failed += r._2 }
  { val r = test_deep_nest1(vec, out); passed += r._1; failed += r._2 }
  { val r = test_deep_nest2(vec, out); passed += r._1; failed += r._2 }
  { val r = test_deep_nest3(vec, out); passed += r._1; failed += r._2 }
  { val r = test_deep_nest4(vec, out); passed += r._1; failed += r._2 }
  { val r = test_deep_nest5(vec, out); passed += r._1; failed += r._2 }
  { val r = test_deep_nest6(vec, out); passed += r._1; failed += r._2 }
  { val r = test_deep_nest7(vec, out); passed += r._1; failed += r._2 }
  { val r = test_timestamp_entry(vec, out); passed += r._1; failed += r._2 }
  { val r = test_config_entry(vec, out); passed += r._1; failed += r._2 }
  (passed, failed)
}
