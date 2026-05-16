import specodec.ryu.*
import scala.io.Source
import java.io.File

@main def testRyu(): Unit = {
  var passed = 0
  var failed = 0

  def parseFloat(s: String): Float = s match {
    case "NaN" => Float.NaN
    case "Infinity" => Float.PositiveInfinity
    case "-Infinity" => Float.NegativeInfinity
    case _ => s.toFloat
  }

  def parseDouble(s: String): Double = s match {
    case "NaN" => Double.NaN
    case "Infinity" => Double.PositiveInfinity
    case "-Infinity" => Double.NegativeInfinity
    case _ => s.toDouble
  }

  def loadLines(path: String): Seq[String] =
    Source.fromFile(path, "UTF-8").getLines().map(_.trim).filter(l => l.nonEmpty && !l.startsWith("#")).toSeq

  def loadExpected(path: String): Seq[String] =
    Source.fromFile(path, "UTF-8").getLines().map(_.trim).filter(_.nonEmpty).toSeq

  val base = new File("tests/ryu")

  // Float32 Original
  println("=== Float32 Original (125 tests) ===")
  val f32In = loadLines(s"${base}/test_cases_f32.txt")
  val f32Exp = loadExpected(s"${base}/expected_f32.txt")
  f32In.zip(f32Exp).take(Math.min(f32In.length, f32Exp.length)).foreach { (in, exp) =>
    try {
      val result = float32ToString(parseFloat(in))
      if (result == exp) passed += 1 else { failed += 1; if (failed <= 5) println(s"FAIL: $in => $result (expected $exp)") }
    } catch { case e: Exception => failed += 1; if (failed <= 5) println(s"ERROR: $in => ${e.getMessage}") }
  }
  println(s"$passed/${f32In.length} f32 original\n")

  // Float64 Original
  println("=== Float64 Original (102 tests) ===")
  val f64In = loadLines(s"${base}/test_cases_f64.txt")
  val f64Exp = loadExpected(s"${base}/expected_f64.txt")
  var f64Pass = 0
  f64In.zip(f64Exp).take(Math.min(f64In.length, f64Exp.length)).foreach { (in, exp) =>
    try {
      val result = float64ToString(parseDouble(in))
      if (result == exp) { f64Pass += 1; passed += 1 } else { failed += 1; if (failed <= 5) println(s"FAIL: $in => $result (expected $exp)") }
    } catch { case e: Exception => failed += 1; if (failed <= 5) println(s"ERROR: $in => ${e.getMessage}") }
  }
  println(s"$f64Pass/${f64In.length}\n")

  // Float32 Coverage
  println("=== Float32 Coverage (78 tests) ===")
  val cov32In = loadLines(s"${base}/test_cases_table_coverage.txt")
  val cov32Exp = loadExpected(s"${base}/expected_table_coverage.txt")
  cov32In.zip(cov32Exp).take(Math.min(cov32In.length, cov32Exp.length)).foreach { (line, exp) =>
    val raw = line.split("#")(0).trim
    try {
      val result = float32ToString(parseFloat(raw))
      if (result == exp) passed += 1 else { failed += 1; if (failed <= 5) println(s"FAIL: $raw => $result (expected $exp)") }
    } catch { case e: Exception => failed += 1 }
  }
  println(s"${passed - f64Pass - f32In.length}/${Math.min(cov32In.length, cov32Exp.length)}\n")

  // Float64 Coverage
  println("=== Float64 Coverage (616 tests) ===")
  val cov64In = loadLines(s"${base}/test_cases_f64_table_coverage.txt")
  val cov64Exp = loadExpected(s"${base}/expected_f64_table_coverage.txt")
  var cov64Pass = 0
  cov64In.zip(cov64Exp).take(Math.min(cov64In.length, cov64Exp.length)).foreach { (line, exp) =>
    val raw = line.split("#")(0).trim
    try {
      val result = float64ToString(parseDouble(raw))
      if (result == exp) { cov64Pass += 1; passed += 1 } else { failed += 1; if (failed <= 5) println(s"FAIL: $raw => $result (expected $exp)") }
    } catch { case e: Exception => failed += 1 }
  }
  println(s"$cov64Pass/${Math.min(cov64In.length, cov64Exp.length)}\n")

  val total = passed + failed
  println(s"=== TOTAL: $passed/$total ===")
  if (failed > 0) sys.exit(1)
}
