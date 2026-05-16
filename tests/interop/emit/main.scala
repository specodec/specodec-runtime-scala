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


@main def main(): Unit = {
  val vec = sys.env("VEC_DIR")
  val out = sys.env("OUT_DIR")
  var passed = 0; var failed = 0

  { val r = run_scalars(vec, out); passed += r._1; failed += r._2 }
  { val r = run_AllTypes(vec, out); passed += r._1; failed += r._2 }
  { val r = run_AllTypes_Scalars(vec, out); passed += r._1; failed += r._2 }
  { val r = run_AllTypes_Opt(vec, out); passed += r._1; failed += r._2 }
  { val r = run_AllTypes_Pairs(vec, out); passed += r._1; failed += r._2 }
  { val r = run_AllTypes_Many(vec, out); passed += r._1; failed += r._2 }
  { val r = run_AllTypes_Arrays(vec, out); passed += r._1; failed += r._2 }
  { val r = run_AllTypes_Nests(vec, out); passed += r._1; failed += r._2 }
  { val r = run_AllTypes_Mixed(vec, out); passed += r._1; failed += r._2 }
  { val r = run_AllTypes_Recursive(vec, out); passed += r._1; failed += r._2 }
  { val r = run_AllTypes_Wide(vec, out); passed += r._1; failed += r._2 }
  { val r = run_AllTypes_Edge(vec, out); passed += r._1; failed += r._2 }
  { val r = run_AllTypes_Extra(vec, out); passed += r._1; failed += r._2 }
  { val r = run_AllTypes_nested(vec, out); passed += r._1; failed += r._2 }
  { val r = run_AllTypes_nested_deep(vec, out); passed += r._1; failed += r._2 }
  { val r = run_AllTypes_Enums(vec, out); passed += r._1; failed += r._2 }
  { val r = run_AllTypes_Unions(vec, out); passed += r._1; failed += r._2 }
  { val r = run_models(vec, out); passed += r._1; failed += r._2 }

  println("emit-scala: " + passed + " passed, " + failed + " failed")
  if (failed > 0) sys.exit(1)
}