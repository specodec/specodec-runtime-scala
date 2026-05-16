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

def test_union_field_holder(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "UnionFieldHolder.msgpack"))
    val obj = UnionFieldHolderCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    UnionFieldHolderCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "UnionFieldHolder.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL UnionFieldHolder mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "UnionFieldHolder.json"))
    val obj = UnionFieldHolderCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    UnionFieldHolderCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "UnionFieldHolder.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL UnionFieldHolder json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "UnionFieldHolder.unformatted.json"))
    val obj = UnionFieldHolderCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    UnionFieldHolderCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "UnionFieldHolder.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL UnionFieldHolder unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "UnionFieldHolder.gron"))
    val obj = UnionFieldHolderCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    UnionFieldHolderCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "UnionFieldHolder.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL UnionFieldHolder gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_opt_union_field_holder(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptUnionFieldHolder.msgpack"))
    val obj = OptUnionFieldHolderCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    OptUnionFieldHolderCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptUnionFieldHolder.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptUnionFieldHolder mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptUnionFieldHolder.json"))
    val obj = OptUnionFieldHolderCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptUnionFieldHolderCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptUnionFieldHolder.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptUnionFieldHolder json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptUnionFieldHolder.unformatted.json"))
    val obj = OptUnionFieldHolderCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptUnionFieldHolderCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptUnionFieldHolder.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptUnionFieldHolder unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptUnionFieldHolder.gron"))
    val obj = OptUnionFieldHolderCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    OptUnionFieldHolderCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptUnionFieldHolder.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptUnionFieldHolder gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_union_array_holder(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "UnionArrayHolder.msgpack"))
    val obj = UnionArrayHolderCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    UnionArrayHolderCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "UnionArrayHolder.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL UnionArrayHolder mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "UnionArrayHolder.json"))
    val obj = UnionArrayHolderCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    UnionArrayHolderCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "UnionArrayHolder.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL UnionArrayHolder json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "UnionArrayHolder.unformatted.json"))
    val obj = UnionArrayHolderCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    UnionArrayHolderCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "UnionArrayHolder.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL UnionArrayHolder unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "UnionArrayHolder.gron"))
    val obj = UnionArrayHolderCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    UnionArrayHolderCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "UnionArrayHolder.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL UnionArrayHolder gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_union_mixed_holder(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "UnionMixedHolder.msgpack"))
    val obj = UnionMixedHolderCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    UnionMixedHolderCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "UnionMixedHolder.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL UnionMixedHolder mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "UnionMixedHolder.json"))
    val obj = UnionMixedHolderCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    UnionMixedHolderCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "UnionMixedHolder.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL UnionMixedHolder json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "UnionMixedHolder.unformatted.json"))
    val obj = UnionMixedHolderCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    UnionMixedHolderCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "UnionMixedHolder.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL UnionMixedHolder unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "UnionMixedHolder.gron"))
    val obj = UnionMixedHolderCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    UnionMixedHolderCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "UnionMixedHolder.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL UnionMixedHolder gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_union_scalar_holder(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "UnionScalarHolder.msgpack"))
    val obj = UnionScalarHolderCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    UnionScalarHolderCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "UnionScalarHolder.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL UnionScalarHolder mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "UnionScalarHolder.json"))
    val obj = UnionScalarHolderCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    UnionScalarHolderCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "UnionScalarHolder.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL UnionScalarHolder json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "UnionScalarHolder.unformatted.json"))
    val obj = UnionScalarHolderCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    UnionScalarHolderCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "UnionScalarHolder.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL UnionScalarHolder unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "UnionScalarHolder.gron"))
    val obj = UnionScalarHolderCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    UnionScalarHolderCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "UnionScalarHolder.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL UnionScalarHolder gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def run_AllTypes_Unions(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  Files.createDirectories(Paths.get(out))
  { val r = test_union_field_holder(vec, out); passed += r._1; failed += r._2 }
  { val r = test_opt_union_field_holder(vec, out); passed += r._1; failed += r._2 }
  { val r = test_union_array_holder(vec, out); passed += r._1; failed += r._2 }
  { val r = test_union_mixed_holder(vec, out); passed += r._1; failed += r._2 }
  { val r = test_union_scalar_holder(vec, out); passed += r._1; failed += r._2 }
  (passed, failed)
}
