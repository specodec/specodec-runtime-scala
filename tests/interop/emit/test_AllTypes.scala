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

def test_opt_inner(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptInner.msgpack"))
    val obj = OptInnerCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    OptInnerCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptInner.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptInner mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptInner.json"))
    val obj = OptInnerCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptInnerCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptInner.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptInner json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptInner.unformatted.json"))
    val obj = OptInnerCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptInnerCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptInner.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptInner unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptInner.gron"))
    val obj = OptInnerCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    OptInnerCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptInner.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptInner gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def run_AllTypes(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  Files.createDirectories(Paths.get(out))
  { val r = test_opt_inner(vec, out); passed += r._1; failed += r._2 }
  (passed, failed)
}
