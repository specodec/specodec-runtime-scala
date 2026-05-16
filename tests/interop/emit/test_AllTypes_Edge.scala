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

def test_edge_empty(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "EdgeEmpty.msgpack"))
    val obj = EdgeEmptyCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    EdgeEmptyCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "EdgeEmpty.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL EdgeEmpty mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "EdgeEmpty.json"))
    val obj = EdgeEmptyCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    EdgeEmptyCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "EdgeEmpty.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL EdgeEmpty json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "EdgeEmpty.unformatted.json"))
    val obj = EdgeEmptyCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    EdgeEmptyCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "EdgeEmpty.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL EdgeEmpty unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "EdgeEmpty.gron"))
    val obj = EdgeEmptyCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    EdgeEmptyCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "EdgeEmpty.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL EdgeEmpty gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_edge_one_opt(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "EdgeOneOpt.msgpack"))
    val obj = EdgeOneOptCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    EdgeOneOptCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "EdgeOneOpt.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL EdgeOneOpt mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "EdgeOneOpt.json"))
    val obj = EdgeOneOptCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    EdgeOneOptCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "EdgeOneOpt.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL EdgeOneOpt json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "EdgeOneOpt.unformatted.json"))
    val obj = EdgeOneOptCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    EdgeOneOptCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "EdgeOneOpt.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL EdgeOneOpt unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "EdgeOneOpt.gron"))
    val obj = EdgeOneOptCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    EdgeOneOptCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "EdgeOneOpt.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL EdgeOneOpt gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_edge_big_nums(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "EdgeBigNums.msgpack"))
    val obj = EdgeBigNumsCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    EdgeBigNumsCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "EdgeBigNums.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL EdgeBigNums mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "EdgeBigNums.json"))
    val obj = EdgeBigNumsCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    EdgeBigNumsCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "EdgeBigNums.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL EdgeBigNums json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "EdgeBigNums.unformatted.json"))
    val obj = EdgeBigNumsCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    EdgeBigNumsCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "EdgeBigNums.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL EdgeBigNums unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "EdgeBigNums.gron"))
    val obj = EdgeBigNumsCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    EdgeBigNumsCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "EdgeBigNums.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL EdgeBigNums gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_edge_zero_vals(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "EdgeZeroVals.msgpack"))
    val obj = EdgeZeroValsCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    EdgeZeroValsCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "EdgeZeroVals.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL EdgeZeroVals mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "EdgeZeroVals.json"))
    val obj = EdgeZeroValsCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    EdgeZeroValsCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "EdgeZeroVals.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL EdgeZeroVals json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "EdgeZeroVals.unformatted.json"))
    val obj = EdgeZeroValsCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    EdgeZeroValsCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "EdgeZeroVals.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL EdgeZeroVals unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "EdgeZeroVals.gron"))
    val obj = EdgeZeroValsCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    EdgeZeroValsCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "EdgeZeroVals.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL EdgeZeroVals gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_edge_nullable(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "EdgeNullable.msgpack"))
    val obj = EdgeNullableCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    EdgeNullableCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "EdgeNullable.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL EdgeNullable mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "EdgeNullable.json"))
    val obj = EdgeNullableCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    EdgeNullableCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "EdgeNullable.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL EdgeNullable json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "EdgeNullable.unformatted.json"))
    val obj = EdgeNullableCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    EdgeNullableCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "EdgeNullable.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL EdgeNullable unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "EdgeNullable.gron"))
    val obj = EdgeNullableCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    EdgeNullableCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "EdgeNullable.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL EdgeNullable gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_edge_neg_zero(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "EdgeNegZero.msgpack"))
    val obj = EdgeNegZeroCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    EdgeNegZeroCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "EdgeNegZero.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL EdgeNegZero mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "EdgeNegZero.json"))
    val obj = EdgeNegZeroCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    EdgeNegZeroCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "EdgeNegZero.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL EdgeNegZero json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "EdgeNegZero.unformatted.json"))
    val obj = EdgeNegZeroCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    EdgeNegZeroCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "EdgeNegZero.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL EdgeNegZero unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "EdgeNegZero.gron"))
    val obj = EdgeNegZeroCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    EdgeNegZeroCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "EdgeNegZero.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL EdgeNegZero gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_edge_null_byte(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "EdgeNullByte.msgpack"))
    val obj = EdgeNullByteCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    EdgeNullByteCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "EdgeNullByte.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL EdgeNullByte mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "EdgeNullByte.json"))
    val obj = EdgeNullByteCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    EdgeNullByteCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "EdgeNullByte.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL EdgeNullByte json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "EdgeNullByte.unformatted.json"))
    val obj = EdgeNullByteCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    EdgeNullByteCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "EdgeNullByte.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL EdgeNullByte unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "EdgeNullByte.gron"))
    val obj = EdgeNullByteCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    EdgeNullByteCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "EdgeNullByte.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL EdgeNullByte gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_edge_boundary(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "EdgeBoundary.msgpack"))
    val obj = EdgeBoundaryCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    EdgeBoundaryCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "EdgeBoundary.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL EdgeBoundary mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "EdgeBoundary.json"))
    val obj = EdgeBoundaryCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    EdgeBoundaryCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "EdgeBoundary.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL EdgeBoundary json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "EdgeBoundary.unformatted.json"))
    val obj = EdgeBoundaryCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    EdgeBoundaryCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "EdgeBoundary.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL EdgeBoundary unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "EdgeBoundary.gron"))
    val obj = EdgeBoundaryCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    EdgeBoundaryCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "EdgeBoundary.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL EdgeBoundary gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_edge_str_len(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "EdgeStrLen.msgpack"))
    val obj = EdgeStrLenCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    EdgeStrLenCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "EdgeStrLen.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL EdgeStrLen mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "EdgeStrLen.json"))
    val obj = EdgeStrLenCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    EdgeStrLenCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "EdgeStrLen.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL EdgeStrLen json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "EdgeStrLen.unformatted.json"))
    val obj = EdgeStrLenCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    EdgeStrLenCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "EdgeStrLen.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL EdgeStrLen unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "EdgeStrLen.gron"))
    val obj = EdgeStrLenCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    EdgeStrLenCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "EdgeStrLen.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL EdgeStrLen gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_edge_bytes_len(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "EdgeBytesLen.msgpack"))
    val obj = EdgeBytesLenCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    EdgeBytesLenCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "EdgeBytesLen.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL EdgeBytesLen mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "EdgeBytesLen.json"))
    val obj = EdgeBytesLenCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    EdgeBytesLenCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "EdgeBytesLen.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL EdgeBytesLen json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "EdgeBytesLen.unformatted.json"))
    val obj = EdgeBytesLenCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    EdgeBytesLenCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "EdgeBytesLen.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL EdgeBytesLen unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "EdgeBytesLen.gron"))
    val obj = EdgeBytesLenCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    EdgeBytesLenCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "EdgeBytesLen.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL EdgeBytesLen gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_edge_arr_empty(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "EdgeArrEmpty.msgpack"))
    val obj = EdgeArrEmptyCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    EdgeArrEmptyCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "EdgeArrEmpty.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL EdgeArrEmpty mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "EdgeArrEmpty.json"))
    val obj = EdgeArrEmptyCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    EdgeArrEmptyCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "EdgeArrEmpty.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL EdgeArrEmpty json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "EdgeArrEmpty.unformatted.json"))
    val obj = EdgeArrEmptyCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    EdgeArrEmptyCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "EdgeArrEmpty.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL EdgeArrEmpty unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "EdgeArrEmpty.gron"))
    val obj = EdgeArrEmptyCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    EdgeArrEmptyCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "EdgeArrEmpty.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL EdgeArrEmpty gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_edge_arr_boundary(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "EdgeArrBoundary.msgpack"))
    val obj = EdgeArrBoundaryCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    EdgeArrBoundaryCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "EdgeArrBoundary.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL EdgeArrBoundary mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "EdgeArrBoundary.json"))
    val obj = EdgeArrBoundaryCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    EdgeArrBoundaryCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "EdgeArrBoundary.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL EdgeArrBoundary json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "EdgeArrBoundary.unformatted.json"))
    val obj = EdgeArrBoundaryCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    EdgeArrBoundaryCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "EdgeArrBoundary.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL EdgeArrBoundary unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "EdgeArrBoundary.gron"))
    val obj = EdgeArrBoundaryCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    EdgeArrBoundaryCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "EdgeArrBoundary.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL EdgeArrBoundary gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def run_AllTypes_Edge(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  Files.createDirectories(Paths.get(out))
  { val r = test_edge_empty(vec, out); passed += r._1; failed += r._2 }
  { val r = test_edge_one_opt(vec, out); passed += r._1; failed += r._2 }
  { val r = test_edge_big_nums(vec, out); passed += r._1; failed += r._2 }
  { val r = test_edge_zero_vals(vec, out); passed += r._1; failed += r._2 }
  { val r = test_edge_nullable(vec, out); passed += r._1; failed += r._2 }
  { val r = test_edge_neg_zero(vec, out); passed += r._1; failed += r._2 }
  { val r = test_edge_null_byte(vec, out); passed += r._1; failed += r._2 }
  { val r = test_edge_boundary(vec, out); passed += r._1; failed += r._2 }
  { val r = test_edge_str_len(vec, out); passed += r._1; failed += r._2 }
  { val r = test_edge_bytes_len(vec, out); passed += r._1; failed += r._2 }
  { val r = test_edge_arr_empty(vec, out); passed += r._1; failed += r._2 }
  { val r = test_edge_arr_boundary(vec, out); passed += r._1; failed += r._2 }
  (passed, failed)
}
