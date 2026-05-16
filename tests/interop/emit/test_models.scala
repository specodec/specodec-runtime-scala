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

def test_shape_circle(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Shape_circle.msgpack"))
    val obj = ShapeCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    ShapeCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Shape_circle.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Shape_circle mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Shape_circle.json"))
    val obj = ShapeCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    ShapeCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Shape_circle.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Shape_circle json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Shape_circle.unformatted.json"))
    val obj = ShapeCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    ShapeCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Shape_circle.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Shape_circle unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Shape_circle.gron"))
    val obj = ShapeCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    ShapeCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Shape_circle.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Shape_circle gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_shape_rect(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Shape_rect.msgpack"))
    val obj = ShapeCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    ShapeCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Shape_rect.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Shape_rect mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Shape_rect.json"))
    val obj = ShapeCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    ShapeCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Shape_rect.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Shape_rect json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Shape_rect.unformatted.json"))
    val obj = ShapeCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    ShapeCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Shape_rect.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Shape_rect unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Shape_rect.gron"))
    val obj = ShapeCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    ShapeCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Shape_rect.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Shape_rect gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_ident_name(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Ident_name.msgpack"))
    val obj = IdentCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    IdentCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Ident_name.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Ident_name mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Ident_name.json"))
    val obj = IdentCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    IdentCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Ident_name.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Ident_name json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Ident_name.unformatted.json"))
    val obj = IdentCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    IdentCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Ident_name.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Ident_name unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Ident_name.gron"))
    val obj = IdentCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    IdentCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Ident_name.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Ident_name gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_ident_number(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Ident_number.msgpack"))
    val obj = IdentCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    IdentCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Ident_number.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Ident_number mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Ident_number.json"))
    val obj = IdentCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    IdentCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Ident_number.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Ident_number json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Ident_number.unformatted.json"))
    val obj = IdentCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    IdentCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Ident_number.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Ident_number unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Ident_number.gron"))
    val obj = IdentCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    IdentCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Ident_number.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Ident_number gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_result_msg_ok(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ResultMsg_ok.msgpack"))
    val obj = ResultMsgCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    ResultMsgCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ResultMsg_ok.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ResultMsg_ok mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ResultMsg_ok.json"))
    val obj = ResultMsgCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    ResultMsgCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ResultMsg_ok.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ResultMsg_ok json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ResultMsg_ok.unformatted.json"))
    val obj = ResultMsgCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    ResultMsgCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ResultMsg_ok.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ResultMsg_ok unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ResultMsg_ok.gron"))
    val obj = ResultMsgCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    ResultMsgCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ResultMsg_ok.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ResultMsg_ok gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_result_msg_err(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ResultMsg_err.msgpack"))
    val obj = ResultMsgCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    ResultMsgCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ResultMsg_err.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ResultMsg_err mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ResultMsg_err.json"))
    val obj = ResultMsgCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    ResultMsgCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ResultMsg_err.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ResultMsg_err json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ResultMsg_err.unformatted.json"))
    val obj = ResultMsgCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    ResultMsgCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ResultMsg_err.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ResultMsg_err unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ResultMsg_err.gron"))
    val obj = ResultMsgCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    ResultMsgCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ResultMsg_err.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ResultMsg_err gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_tagged_tag(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Tagged_tag.msgpack"))
    val obj = TaggedCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    TaggedCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Tagged_tag.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Tagged_tag mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Tagged_tag.json"))
    val obj = TaggedCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    TaggedCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Tagged_tag.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Tagged_tag json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Tagged_tag.unformatted.json"))
    val obj = TaggedCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    TaggedCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Tagged_tag.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Tagged_tag unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Tagged_tag.gron"))
    val obj = TaggedCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    TaggedCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Tagged_tag.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Tagged_tag gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_tagged_score(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Tagged_score.msgpack"))
    val obj = TaggedCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    TaggedCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Tagged_score.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Tagged_score mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Tagged_score.json"))
    val obj = TaggedCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    TaggedCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Tagged_score.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Tagged_score json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Tagged_score.unformatted.json"))
    val obj = TaggedCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    TaggedCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Tagged_score.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Tagged_score unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Tagged_score.gron"))
    val obj = TaggedCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    TaggedCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Tagged_score.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Tagged_score gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_tagged_active(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Tagged_active.msgpack"))
    val obj = TaggedCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    TaggedCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Tagged_active.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Tagged_active mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Tagged_active.json"))
    val obj = TaggedCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    TaggedCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Tagged_active.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Tagged_active json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Tagged_active.unformatted.json"))
    val obj = TaggedCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    TaggedCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Tagged_active.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Tagged_active unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "Tagged_active.gron"))
    val obj = TaggedCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    TaggedCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "Tagged_active.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL Tagged_active gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_opt_union_holder_shape(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptUnionHolder_shape.msgpack"))
    val obj = OptUnionHolderCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    OptUnionHolderCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptUnionHolder_shape.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptUnionHolder_shape mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptUnionHolder_shape.json"))
    val obj = OptUnionHolderCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptUnionHolderCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptUnionHolder_shape.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptUnionHolder_shape json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptUnionHolder_shape.unformatted.json"))
    val obj = OptUnionHolderCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptUnionHolderCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptUnionHolder_shape.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptUnionHolder_shape unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptUnionHolder_shape.gron"))
    val obj = OptUnionHolderCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    OptUnionHolderCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptUnionHolder_shape.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptUnionHolder_shape gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_opt_union_holder_id(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptUnionHolder_id.msgpack"))
    val obj = OptUnionHolderCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    OptUnionHolderCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptUnionHolder_id.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptUnionHolder_id mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptUnionHolder_id.json"))
    val obj = OptUnionHolderCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptUnionHolderCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptUnionHolder_id.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptUnionHolder_id json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptUnionHolder_id.unformatted.json"))
    val obj = OptUnionHolderCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptUnionHolderCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptUnionHolder_id.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptUnionHolder_id unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptUnionHolder_id.gron"))
    val obj = OptUnionHolderCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    OptUnionHolderCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptUnionHolder_id.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptUnionHolder_id gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_mixed_union_point(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "MixedUnion_point.msgpack"))
    val obj = MixedUnionCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    MixedUnionCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "MixedUnion_point.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL MixedUnion_point mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "MixedUnion_point.json"))
    val obj = MixedUnionCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    MixedUnionCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "MixedUnion_point.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL MixedUnion_point json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "MixedUnion_point.unformatted.json"))
    val obj = MixedUnionCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    MixedUnionCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "MixedUnion_point.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL MixedUnion_point unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "MixedUnion_point.gron"))
    val obj = MixedUnionCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    MixedUnionCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "MixedUnion_point.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL MixedUnion_point gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_mixed_union_label(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "MixedUnion_label.msgpack"))
    val obj = MixedUnionCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    MixedUnionCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "MixedUnion_label.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL MixedUnion_label mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "MixedUnion_label.json"))
    val obj = MixedUnionCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    MixedUnionCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "MixedUnion_label.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL MixedUnion_label json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "MixedUnion_label.unformatted.json"))
    val obj = MixedUnionCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    MixedUnionCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "MixedUnion_label.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL MixedUnion_label unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "MixedUnion_label.gron"))
    val obj = MixedUnionCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    MixedUnionCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "MixedUnion_label.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL MixedUnion_label gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_mixed_union_count(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "MixedUnion_count.msgpack"))
    val obj = MixedUnionCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    MixedUnionCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "MixedUnion_count.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL MixedUnion_count mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "MixedUnion_count.json"))
    val obj = MixedUnionCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    MixedUnionCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "MixedUnion_count.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL MixedUnion_count json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "MixedUnion_count.unformatted.json"))
    val obj = MixedUnionCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    MixedUnionCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "MixedUnion_count.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL MixedUnion_count unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "MixedUnion_count.gron"))
    val obj = MixedUnionCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    MixedUnionCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "MixedUnion_count.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL MixedUnion_count gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_nested_union_result(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestedUnion_result.msgpack"))
    val obj = NestedUnionCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    NestedUnionCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestedUnion_result.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestedUnion_result mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestedUnion_result.json"))
    val obj = NestedUnionCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    NestedUnionCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestedUnion_result.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestedUnion_result json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestedUnion_result.unformatted.json"))
    val obj = NestedUnionCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    NestedUnionCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestedUnion_result.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestedUnion_result unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestedUnion_result.gron"))
    val obj = NestedUnionCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    NestedUnionCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestedUnion_result.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestedUnion_result gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_nested_union_shape(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestedUnion_shape.msgpack"))
    val obj = NestedUnionCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    NestedUnionCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestedUnion_shape.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestedUnion_shape mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestedUnion_shape.json"))
    val obj = NestedUnionCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    NestedUnionCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestedUnion_shape.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestedUnion_shape json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestedUnion_shape.unformatted.json"))
    val obj = NestedUnionCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    NestedUnionCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestedUnion_shape.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestedUnion_shape unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestedUnion_shape.gron"))
    val obj = NestedUnionCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    NestedUnionCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestedUnion_shape.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestedUnion_shape gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_scalar_union_s(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ScalarUnion_s.msgpack"))
    val obj = ScalarUnionCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    ScalarUnionCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ScalarUnion_s.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ScalarUnion_s mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ScalarUnion_s.json"))
    val obj = ScalarUnionCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    ScalarUnionCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ScalarUnion_s.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ScalarUnion_s json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ScalarUnion_s.unformatted.json"))
    val obj = ScalarUnionCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    ScalarUnionCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ScalarUnion_s.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ScalarUnion_s unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ScalarUnion_s.gron"))
    val obj = ScalarUnionCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    ScalarUnionCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ScalarUnion_s.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ScalarUnion_s gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_scalar_union_i(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ScalarUnion_i.msgpack"))
    val obj = ScalarUnionCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    ScalarUnionCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ScalarUnion_i.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ScalarUnion_i mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ScalarUnion_i.json"))
    val obj = ScalarUnionCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    ScalarUnionCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ScalarUnion_i.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ScalarUnion_i json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ScalarUnion_i.unformatted.json"))
    val obj = ScalarUnionCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    ScalarUnionCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ScalarUnion_i.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ScalarUnion_i unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ScalarUnion_i.gron"))
    val obj = ScalarUnionCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    ScalarUnionCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ScalarUnion_i.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ScalarUnion_i gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_scalar_union_f(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ScalarUnion_f.msgpack"))
    val obj = ScalarUnionCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    ScalarUnionCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ScalarUnion_f.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ScalarUnion_f mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ScalarUnion_f.json"))
    val obj = ScalarUnionCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    ScalarUnionCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ScalarUnion_f.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ScalarUnion_f json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ScalarUnion_f.unformatted.json"))
    val obj = ScalarUnionCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    ScalarUnionCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ScalarUnion_f.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ScalarUnion_f unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ScalarUnion_f.gron"))
    val obj = ScalarUnionCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    ScalarUnionCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ScalarUnion_f.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ScalarUnion_f gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_scalar_union_b(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ScalarUnion_b.msgpack"))
    val obj = ScalarUnionCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    ScalarUnionCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ScalarUnion_b.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ScalarUnion_b mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ScalarUnion_b.json"))
    val obj = ScalarUnionCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    ScalarUnionCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ScalarUnion_b.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ScalarUnion_b json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ScalarUnion_b.unformatted.json"))
    val obj = ScalarUnionCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    ScalarUnionCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ScalarUnion_b.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ScalarUnion_b unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "ScalarUnion_b.gron"))
    val obj = ScalarUnionCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    ScalarUnionCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "ScalarUnion_b.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ScalarUnion_b gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def run_models(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  Files.createDirectories(Paths.get(out))
  { val r = test_shape_circle(vec, out); passed += r._1; failed += r._2 }
  { val r = test_shape_rect(vec, out); passed += r._1; failed += r._2 }
  { val r = test_ident_name(vec, out); passed += r._1; failed += r._2 }
  { val r = test_ident_number(vec, out); passed += r._1; failed += r._2 }
  { val r = test_result_msg_ok(vec, out); passed += r._1; failed += r._2 }
  { val r = test_result_msg_err(vec, out); passed += r._1; failed += r._2 }
  { val r = test_tagged_tag(vec, out); passed += r._1; failed += r._2 }
  { val r = test_tagged_score(vec, out); passed += r._1; failed += r._2 }
  { val r = test_tagged_active(vec, out); passed += r._1; failed += r._2 }
  { val r = test_opt_union_holder_shape(vec, out); passed += r._1; failed += r._2 }
  { val r = test_opt_union_holder_id(vec, out); passed += r._1; failed += r._2 }
  { val r = test_mixed_union_point(vec, out); passed += r._1; failed += r._2 }
  { val r = test_mixed_union_label(vec, out); passed += r._1; failed += r._2 }
  { val r = test_mixed_union_count(vec, out); passed += r._1; failed += r._2 }
  { val r = test_nested_union_result(vec, out); passed += r._1; failed += r._2 }
  { val r = test_nested_union_shape(vec, out); passed += r._1; failed += r._2 }
  { val r = test_scalar_union_s(vec, out); passed += r._1; failed += r._2 }
  { val r = test_scalar_union_i(vec, out); passed += r._1; failed += r._2 }
  { val r = test_scalar_union_f(vec, out); passed += r._1; failed += r._2 }
  { val r = test_scalar_union_b(vec, out); passed += r._1; failed += r._2 }
  (passed, failed)
}
