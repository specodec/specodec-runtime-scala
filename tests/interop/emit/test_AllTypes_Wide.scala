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

def test_wide20(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Wide20.msgpack"))
    val obj = Wide20Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    Wide20Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Wide20.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Wide20 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Wide20.json"))
    val obj = Wide20Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Wide20Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Wide20.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Wide20 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Wide20.unformatted.json"))
    val obj = Wide20Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Wide20Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Wide20.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Wide20 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Wide20.gron"))
    val obj = Wide20Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    Wide20Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Wide20.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Wide20 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_wide25(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Wide25.msgpack"))
    val obj = Wide25Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    Wide25Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Wide25.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Wide25 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Wide25.json"))
    val obj = Wide25Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Wide25Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Wide25.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Wide25 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Wide25.unformatted.json"))
    val obj = Wide25Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Wide25Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Wide25.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Wide25 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Wide25.gron"))
    val obj = Wide25Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    Wide25Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Wide25.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Wide25 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_wide30(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Wide30.msgpack"))
    val obj = Wide30Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    Wide30Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Wide30.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Wide30 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Wide30.json"))
    val obj = Wide30Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Wide30Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Wide30.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Wide30 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Wide30.unformatted.json"))
    val obj = Wide30Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Wide30Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Wide30.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Wide30 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Wide30.gron"))
    val obj = Wide30Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    Wide30Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Wide30.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Wide30 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_wide35(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Wide35.msgpack"))
    val obj = Wide35Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    Wide35Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Wide35.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Wide35 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Wide35.json"))
    val obj = Wide35Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Wide35Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Wide35.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Wide35 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Wide35.unformatted.json"))
    val obj = Wide35Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Wide35Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Wide35.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Wide35 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Wide35.gron"))
    val obj = Wide35Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    Wide35Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Wide35.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Wide35 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_wide40(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Wide40.msgpack"))
    val obj = Wide40Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    Wide40Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Wide40.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Wide40 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Wide40.json"))
    val obj = Wide40Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Wide40Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Wide40.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Wide40 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Wide40.unformatted.json"))
    val obj = Wide40Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    Wide40Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Wide40.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Wide40 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Wide40.gron"))
    val obj = Wide40Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    Wide40Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Wide40.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Wide40 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def run_AllTypes_Wide(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  Files.createDirectories(Paths.get(out))
  { val r = test_wide20(vec, out); passed += r._1; failed += r._2 }
  { val r = test_wide25(vec, out); passed += r._1; failed += r._2 }
  { val r = test_wide30(vec, out); passed += r._1; failed += r._2 }
  { val r = test_wide35(vec, out); passed += r._1; failed += r._2 }
  { val r = test_wide40(vec, out); passed += r._1; failed += r._2 }
  (passed, failed)
}
