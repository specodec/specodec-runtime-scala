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

def test_rec_list(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "RecList.msgpack"))
    val obj = RecListCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    RecListCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "RecList.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL RecList mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "RecList.json"))
    val obj = RecListCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    RecListCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "RecList.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL RecList json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "RecList.unformatted.json"))
    val obj = RecListCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    RecListCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "RecList.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL RecList unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "RecList.gron"))
    val obj = RecListCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    RecListCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "RecList.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL RecList gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_rec_tree(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "RecTree.msgpack"))
    val obj = RecTreeCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    RecTreeCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "RecTree.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL RecTree mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "RecTree.json"))
    val obj = RecTreeCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    RecTreeCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "RecTree.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL RecTree json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "RecTree.unformatted.json"))
    val obj = RecTreeCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    RecTreeCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "RecTree.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL RecTree unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "RecTree.gron"))
    val obj = RecTreeCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    RecTreeCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "RecTree.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL RecTree gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_rec_chain(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "RecChain.msgpack"))
    val obj = RecChainCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    RecChainCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "RecChain.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL RecChain mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "RecChain.json"))
    val obj = RecChainCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    RecChainCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "RecChain.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL RecChain json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "RecChain.unformatted.json"))
    val obj = RecChainCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    RecChainCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "RecChain.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL RecChain unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "RecChain.gron"))
    val obj = RecChainCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    RecChainCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "RecChain.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL RecChain gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_rec_wrap(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "RecWrap.msgpack"))
    val obj = RecWrapCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    RecWrapCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "RecWrap.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL RecWrap mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "RecWrap.json"))
    val obj = RecWrapCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    RecWrapCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "RecWrap.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL RecWrap json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "RecWrap.unformatted.json"))
    val obj = RecWrapCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    RecWrapCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "RecWrap.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL RecWrap unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "RecWrap.gron"))
    val obj = RecWrapCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    RecWrapCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "RecWrap.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL RecWrap gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_rec_wide(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "RecWide.msgpack"))
    val obj = RecWideCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    RecWideCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "RecWide.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL RecWide mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "RecWide.json"))
    val obj = RecWideCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    RecWideCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "RecWide.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL RecWide json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "RecWide.unformatted.json"))
    val obj = RecWideCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    RecWideCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "RecWide.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL RecWide unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "RecWide.gron"))
    val obj = RecWideCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    RecWideCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "RecWide.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL RecWide gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def run_AllTypes_Recursive(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  Files.createDirectories(Paths.get(out))
  { val r = test_rec_list(vec, out); passed += r._1; failed += r._2 }
  { val r = test_rec_tree(vec, out); passed += r._1; failed += r._2 }
  { val r = test_rec_chain(vec, out); passed += r._1; failed += r._2 }
  { val r = test_rec_wrap(vec, out); passed += r._1; failed += r._2 }
  { val r = test_rec_wide(vec, out); passed += r._1; failed += r._2 }
  (passed, failed)
}
