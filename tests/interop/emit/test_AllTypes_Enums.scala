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

def test_enum_holder(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "EnumHolder.msgpack"))
    val obj = EnumHolderCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    EnumHolderCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "EnumHolder.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL EnumHolder mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "EnumHolder.json"))
    val obj = EnumHolderCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    EnumHolderCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "EnumHolder.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL EnumHolder json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "EnumHolder.unformatted.json"))
    val obj = EnumHolderCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    EnumHolderCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "EnumHolder.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL EnumHolder unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "EnumHolder.gron"))
    val obj = EnumHolderCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    EnumHolderCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "EnumHolder.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL EnumHolder gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_opt_enum_holder(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptEnumHolder.msgpack"))
    val obj = OptEnumHolderCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    OptEnumHolderCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptEnumHolder.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptEnumHolder mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptEnumHolder.json"))
    val obj = OptEnumHolderCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptEnumHolderCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptEnumHolder.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptEnumHolder json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptEnumHolder.unformatted.json"))
    val obj = OptEnumHolderCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptEnumHolderCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptEnumHolder.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptEnumHolder unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptEnumHolder.gron"))
    val obj = OptEnumHolderCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    OptEnumHolderCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptEnumHolder.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptEnumHolder gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_enum_array_holder(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "EnumArrayHolder.msgpack"))
    val obj = EnumArrayHolderCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    EnumArrayHolderCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "EnumArrayHolder.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL EnumArrayHolder mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "EnumArrayHolder.json"))
    val obj = EnumArrayHolderCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    EnumArrayHolderCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "EnumArrayHolder.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL EnumArrayHolder json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "EnumArrayHolder.unformatted.json"))
    val obj = EnumArrayHolderCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    EnumArrayHolderCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "EnumArrayHolder.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL EnumArrayHolder unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "EnumArrayHolder.gron"))
    val obj = EnumArrayHolderCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    EnumArrayHolderCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "EnumArrayHolder.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL EnumArrayHolder gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_enum_mixed_holder(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "EnumMixedHolder.msgpack"))
    val obj = EnumMixedHolderCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    EnumMixedHolderCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "EnumMixedHolder.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL EnumMixedHolder mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "EnumMixedHolder.json"))
    val obj = EnumMixedHolderCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    EnumMixedHolderCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "EnumMixedHolder.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL EnumMixedHolder json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "EnumMixedHolder.unformatted.json"))
    val obj = EnumMixedHolderCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    EnumMixedHolderCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "EnumMixedHolder.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL EnumMixedHolder unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "EnumMixedHolder.gron"))
    val obj = EnumMixedHolderCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    EnumMixedHolderCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "EnumMixedHolder.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL EnumMixedHolder gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def run_AllTypes_Enums(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  Files.createDirectories(Paths.get(out))
  { val r = test_enum_holder(vec, out); passed += r._1; failed += r._2 }
  { val r = test_opt_enum_holder(vec, out); passed += r._1; failed += r._2 }
  { val r = test_enum_array_holder(vec, out); passed += r._1; failed += r._2 }
  { val r = test_enum_mixed_holder(vec, out); passed += r._1; failed += r._2 }
  (passed, failed)
}
