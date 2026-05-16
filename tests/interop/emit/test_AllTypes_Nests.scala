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

def test_nest_inner(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestInner.msgpack"))
    val obj = NestInnerCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    NestInnerCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestInner.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestInner mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestInner.json"))
    val obj = NestInnerCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    NestInnerCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestInner.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestInner json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestInner.unformatted.json"))
    val obj = NestInnerCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    NestInnerCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestInner.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestInner unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestInner.gron"))
    val obj = NestInnerCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    NestInnerCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestInner.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestInner gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_nest_coord(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestCoord.msgpack"))
    val obj = NestCoordCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    NestCoordCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestCoord.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestCoord mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestCoord.json"))
    val obj = NestCoordCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    NestCoordCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestCoord.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestCoord json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestCoord.unformatted.json"))
    val obj = NestCoordCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    NestCoordCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestCoord.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestCoord unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestCoord.gron"))
    val obj = NestCoordCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    NestCoordCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestCoord.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestCoord gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_nest_id_val(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestIdVal.msgpack"))
    val obj = NestIdValCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    NestIdValCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestIdVal.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestIdVal mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestIdVal.json"))
    val obj = NestIdValCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    NestIdValCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestIdVal.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestIdVal json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestIdVal.unformatted.json"))
    val obj = NestIdValCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    NestIdValCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestIdVal.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestIdVal unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestIdVal.gron"))
    val obj = NestIdValCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    NestIdValCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestIdVal.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestIdVal gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_nest_label(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestLabel.msgpack"))
    val obj = NestLabelCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    NestLabelCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestLabel.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestLabel mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestLabel.json"))
    val obj = NestLabelCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    NestLabelCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestLabel.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestLabel json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestLabel.unformatted.json"))
    val obj = NestLabelCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    NestLabelCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestLabel.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestLabel unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestLabel.gron"))
    val obj = NestLabelCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    NestLabelCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestLabel.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestLabel gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_nest_money(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestMoney.msgpack"))
    val obj = NestMoneyCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    NestMoneyCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestMoney.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestMoney mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestMoney.json"))
    val obj = NestMoneyCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    NestMoneyCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestMoney.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestMoney json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestMoney.unformatted.json"))
    val obj = NestMoneyCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    NestMoneyCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestMoney.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestMoney unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestMoney.gron"))
    val obj = NestMoneyCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    NestMoneyCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestMoney.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestMoney gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_nest_range32(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestRange32.msgpack"))
    val obj = NestRange32Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    NestRange32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestRange32.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestRange32 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestRange32.json"))
    val obj = NestRange32Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    NestRange32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestRange32.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestRange32 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestRange32.unformatted.json"))
    val obj = NestRange32Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    NestRange32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestRange32.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestRange32 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestRange32.gron"))
    val obj = NestRange32Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    NestRange32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestRange32.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestRange32 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_nest_addr(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestAddr.msgpack"))
    val obj = NestAddrCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    NestAddrCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestAddr.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestAddr mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestAddr.json"))
    val obj = NestAddrCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    NestAddrCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestAddr.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestAddr json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestAddr.unformatted.json"))
    val obj = NestAddrCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    NestAddrCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestAddr.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestAddr unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestAddr.gron"))
    val obj = NestAddrCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    NestAddrCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestAddr.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestAddr gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_nest_point3(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestPoint3.msgpack"))
    val obj = NestPoint3Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    NestPoint3Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestPoint3.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestPoint3 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestPoint3.json"))
    val obj = NestPoint3Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    NestPoint3Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestPoint3.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestPoint3 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestPoint3.unformatted.json"))
    val obj = NestPoint3Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    NestPoint3Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestPoint3.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestPoint3 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "NestPoint3.gron"))
    val obj = NestPoint3Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    NestPoint3Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "NestPoint3.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL NestPoint3 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_opt_nest_inner(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptNestInner.msgpack"))
    val obj = OptNestInnerCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    OptNestInnerCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptNestInner.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptNestInner mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptNestInner.json"))
    val obj = OptNestInnerCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptNestInnerCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptNestInner.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptNestInner json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptNestInner.unformatted.json"))
    val obj = OptNestInnerCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptNestInnerCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptNestInner.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptNestInner unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptNestInner.gron"))
    val obj = OptNestInnerCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    OptNestInnerCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptNestInner.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptNestInner gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_opt_nest_coord(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptNestCoord.msgpack"))
    val obj = OptNestCoordCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    OptNestCoordCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptNestCoord.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptNestCoord mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptNestCoord.json"))
    val obj = OptNestCoordCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptNestCoordCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptNestCoord.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptNestCoord json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptNestCoord.unformatted.json"))
    val obj = OptNestCoordCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptNestCoordCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptNestCoord.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptNestCoord unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptNestCoord.gron"))
    val obj = OptNestCoordCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    OptNestCoordCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptNestCoord.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptNestCoord gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_opt_nest_id_val(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptNestIdVal.msgpack"))
    val obj = OptNestIdValCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    OptNestIdValCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptNestIdVal.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptNestIdVal mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptNestIdVal.json"))
    val obj = OptNestIdValCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptNestIdValCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptNestIdVal.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptNestIdVal json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptNestIdVal.unformatted.json"))
    val obj = OptNestIdValCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptNestIdValCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptNestIdVal.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptNestIdVal unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptNestIdVal.gron"))
    val obj = OptNestIdValCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    OptNestIdValCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptNestIdVal.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptNestIdVal gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_opt_nest_label(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptNestLabel.msgpack"))
    val obj = OptNestLabelCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    OptNestLabelCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptNestLabel.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptNestLabel mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptNestLabel.json"))
    val obj = OptNestLabelCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptNestLabelCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptNestLabel.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptNestLabel json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptNestLabel.unformatted.json"))
    val obj = OptNestLabelCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptNestLabelCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptNestLabel.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptNestLabel unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptNestLabel.gron"))
    val obj = OptNestLabelCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    OptNestLabelCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptNestLabel.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptNestLabel gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_opt_nest_money(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptNestMoney.msgpack"))
    val obj = OptNestMoneyCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    OptNestMoneyCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptNestMoney.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptNestMoney mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptNestMoney.json"))
    val obj = OptNestMoneyCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptNestMoneyCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptNestMoney.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptNestMoney json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptNestMoney.unformatted.json"))
    val obj = OptNestMoneyCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptNestMoneyCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptNestMoney.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptNestMoney unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptNestMoney.gron"))
    val obj = OptNestMoneyCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    OptNestMoneyCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptNestMoney.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptNestMoney gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_opt_nest_range32(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptNestRange32.msgpack"))
    val obj = OptNestRange32Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    OptNestRange32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptNestRange32.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptNestRange32 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptNestRange32.json"))
    val obj = OptNestRange32Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptNestRange32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptNestRange32.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptNestRange32 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptNestRange32.unformatted.json"))
    val obj = OptNestRange32Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptNestRange32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptNestRange32.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptNestRange32 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptNestRange32.gron"))
    val obj = OptNestRange32Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    OptNestRange32Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptNestRange32.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptNestRange32 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_opt_nest_addr(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptNestAddr.msgpack"))
    val obj = OptNestAddrCodec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    OptNestAddrCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptNestAddr.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptNestAddr mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptNestAddr.json"))
    val obj = OptNestAddrCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptNestAddrCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptNestAddr.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptNestAddr json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptNestAddr.unformatted.json"))
    val obj = OptNestAddrCodec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptNestAddrCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptNestAddr.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptNestAddr unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptNestAddr.gron"))
    val obj = OptNestAddrCodec.decode.apply(GronReader(b))
    val w = GronWriter()
    OptNestAddrCodec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptNestAddr.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptNestAddr gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def test_opt_nest_point3(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptNestPoint3.msgpack"))
    val obj = OptNestPoint3Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    OptNestPoint3Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptNestPoint3.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptNestPoint3 mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptNestPoint3.json"))
    val obj = OptNestPoint3Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptNestPoint3Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptNestPoint3.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptNestPoint3 json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptNestPoint3.unformatted.json"))
    val obj = OptNestPoint3Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    OptNestPoint3Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptNestPoint3.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptNestPoint3 unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "OptNestPoint3.gron"))
    val obj = OptNestPoint3Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    OptNestPoint3Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "OptNestPoint3.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL OptNestPoint3 gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}
def run_AllTypes_Nests(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  Files.createDirectories(Paths.get(out))
  { val r = test_nest_inner(vec, out); passed += r._1; failed += r._2 }
  { val r = test_nest_coord(vec, out); passed += r._1; failed += r._2 }
  { val r = test_nest_id_val(vec, out); passed += r._1; failed += r._2 }
  { val r = test_nest_label(vec, out); passed += r._1; failed += r._2 }
  { val r = test_nest_money(vec, out); passed += r._1; failed += r._2 }
  { val r = test_nest_range32(vec, out); passed += r._1; failed += r._2 }
  { val r = test_nest_addr(vec, out); passed += r._1; failed += r._2 }
  { val r = test_nest_point3(vec, out); passed += r._1; failed += r._2 }
  { val r = test_opt_nest_inner(vec, out); passed += r._1; failed += r._2 }
  { val r = test_opt_nest_coord(vec, out); passed += r._1; failed += r._2 }
  { val r = test_opt_nest_id_val(vec, out); passed += r._1; failed += r._2 }
  { val r = test_opt_nest_label(vec, out); passed += r._1; failed += r._2 }
  { val r = test_opt_nest_money(vec, out); passed += r._1; failed += r._2 }
  { val r = test_opt_nest_range32(vec, out); passed += r._1; failed += r._2 }
  { val r = test_opt_nest_addr(vec, out); passed += r._1; failed += r._2 }
  { val r = test_opt_nest_point3(vec, out); passed += r._1; failed += r._2 }
  (passed, failed)
}
