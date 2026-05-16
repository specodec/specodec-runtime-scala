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

def test_deep_model(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DeepModel.msgpack"))
    val obj = DeepModelCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    DeepModelCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DeepModel.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DeepModel mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DeepModel.json"))
    val obj = DeepModelCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DeepModelCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DeepModel.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DeepModel json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DeepModel.unformatted.json"))
    val obj = DeepModelCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    DeepModelCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DeepModel.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DeepModel unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "DeepModel.gron"))
    val obj = DeepModelCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    DeepModelCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "DeepModel.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL DeepModel gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def run_AllTypes_nested_deep(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  Files.createDirectories(Paths.get(out))
  { val r = test_deep_model(vec, out); passed += r._1; failed += r._2 }
  (passed, failed)
}
