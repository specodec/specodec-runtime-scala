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

def test_nested_simple(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestedSimple.msgpack"))
    val obj = NestedSimpleCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    NestedSimpleCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestedSimple.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestedSimple mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestedSimple.json"))
    val obj = NestedSimpleCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    NestedSimpleCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestedSimple.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestedSimple json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestedSimple.unformatted.json"))
    val obj = NestedSimpleCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    NestedSimpleCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestedSimple.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestedSimple unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestedSimple.gron"))
    val obj = NestedSimpleCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    NestedSimpleCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestedSimple.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestedSimple gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def run_AllTypes_nested(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  Files.createDirectories(Paths.get(out))
  { val r = test_nested_simple(vec, out); passed += r._1; failed += r._2 }
  (passed, failed)
}
