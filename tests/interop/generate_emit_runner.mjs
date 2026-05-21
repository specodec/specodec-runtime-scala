import fs from "fs";
import path from "path";
import { fileURLToPath } from "url";

const __dir = path.dirname(fileURLToPath(import.meta.url));
const VEC_DIR = process.env.VEC_DIR || path.join(__dir, "vectors");

const manifestPath = path.join(VEC_DIR, "manifest.json");
const manifest = JSON.parse(fs.readFileSync(manifestPath, "utf-8"));

const models = [...(manifest.testModels || []), ...(manifest.testUnions || [])];
const scalars = manifest.scalars;
const modelNamespaces = manifest.modelNamespaces || {};
const testUnions = new Set(manifest.testUnions || []);
function isUnionTest(name) { return testUnions.has(name); }
function unionNameOf(testName) { return testName.replace(/_[^_]+$/, ""); }

function readMethod(type) {
  const map = { int32: "readInt32()", int64: "readInt64()", uint32: "readUint32()", uint64: "readUint64()", float32: "readFloat32()", float64: "readFloat64()", string: "readString()", bytes: "readBytes()", bool: "readBool()" };
  return map[type] || "readInt32()";
}
function writeMethod(type) {
  const map = { int32: "writeInt32", int64: "writeInt64", uint32: "writeUint32", uint64: "writeUint64", float32: "writeFloat32", float64: "writeFloat64", string: "writeString", bytes: "writeBytes", bool: "writeBool" };
  return map[type] || "writeInt32";
}

function toSnakeCase(name) {
  return name.replace(/([A-Z])/g, "_$1").toLowerCase().replace(/^_/, "").replace(/\./g, "_").replace(/-/g, "_");
}
function dottedPathToPascalCase(pathStr) {
  return pathStr.split(".").map(s => s.charAt(0).toUpperCase() + s.slice(1)).join("");
}

function scalarFunc(name, info) {
  const snake = toSnakeCase(name);
  return `def test_${snake}(vec: String, out: String): (Int, Int) = {
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "scalars/${name}.mp"))
    val r = MsgPackReader(b)
    val v = r.${readMethod(info.type)}
    val w = MsgPackWriter()
    w.${writeMethod(info.type)}(v)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "scalars/${name}.mp"), w.toBytes())
    (1, 0)
  } catch { case e: Exception => println("FAIL ${name} mp: " + e.getMessage); (0, 1) }
}`;
}

function modelFunc(model) {
  const snake = toSnakeCase(model);
  const codecName = isUnionTest(model) ? unionNameOf(model) : model;
  return `def test_${snake}(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "${model}.msgpack"))
    val obj = ${codecName}Codec.decode.apply(MsgPackReader(b))
    val w = MsgPackWriter()
    ${codecName}Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "${model}.msgpack"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ${model} mp: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "${model}.json"))
    val obj = ${codecName}Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    ${codecName}Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "${model}.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ${model} json: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "${model}.unformatted.json"))
    val obj = ${codecName}Codec.decode.apply(JsonReader(b))
    val w = JsonWriter()
    ${codecName}Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "${model}.unformatted.json"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ${model} unformatted: " + e.getMessage); failed += 1 }
  try {
    val b = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(vec, "${model}.gron"))
    val obj = ${codecName}Codec.decode.apply(GronReader(b))
    val w = GronWriter()
    ${codecName}Codec.encode.apply(w, obj)
    java.nio.file.Files.write(java.nio.file.Paths.get(out, "${model}.gron"), w.toBytes())
    passed += 1
  } catch { case e: Exception => println("FAIL ${model} gron: " + e.getMessage); failed += 1 }
  (passed, failed)
}`;
}

const groups = {};
for (const model of models) {
  const nsStr = modelNamespaces[model] || "";
  const ns = nsStr ? nsStr.split(".") : [];
  const key = ns.length > 0 ? ns.join("_") : "_root";
  if (!groups[key]) groups[key] = [];
  groups[key].push(model);
}
function nsFuncName(key) { return key === "_root" ? "run_models" : "run_" + key; }
function nsFileName(key) { return "test_" + (key === "_root" ? "models" : key) + ".scala"; }

const outDir = path.join(__dir, "emit");
fs.mkdirSync(outDir, { recursive: true });

const nsImports = [...new Set(Object.values(manifest.modelNamespaces || {}))]
  .filter(Boolean).map(ns => `import ${dottedPathToPascalCase(ns)}._`).join("\n");

const header = `import specodec.*
import java.nio.file.{Files, Paths}

${nsImports}

`;

const groupKeys = Object.keys(groups);
const groupFuncNames = [];

// Scalars
if (Object.keys(scalars).length > 0) {
  let body = header;
  for (const [name, info] of Object.entries(scalars)) body += scalarFunc(name, info) + "\n";
  body += `def run_scalars(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  Files.createDirectories(Paths.get(out))
  Files.createDirectories(Paths.get(out, "scalars"))
`;
  for (const [name] of Object.entries(scalars)) body += `  { val r = test_${toSnakeCase(name)}(vec, out); passed += r._1; failed += r._2 }\n`;
  body += `  (passed, failed)\n}\n`;
  fs.writeFileSync(path.join(outDir, "test_scalars.scala"), body);
  groupFuncNames.push("run_scalars");
}

// Models
for (const key of groupKeys) {
  const funcName = nsFuncName(key);
  groupFuncNames.push(funcName);
  let body = header;
  for (const model of groups[key]) body += modelFunc(model) + "\n";
  body += `def ${funcName}(vec: String, out: String): (Int, Int) = {
  var passed = 0; var failed = 0
  Files.createDirectories(Paths.get(out))
`;
  for (const model of groups[key]) body += `  { val r = test_${toSnakeCase(model)}(vec, out); passed += r._1; failed += r._2 }\n`;
  body += `  (passed, failed)\n}\n`;
  fs.writeFileSync(path.join(outDir, nsFileName(key)), body);
  console.log(`Generated emit/${nsFileName(key)} with ${groups[key].length} models`);
}

// Main
let mainLines = [header];
mainLines.push(`@main def main(): Unit = {
  val vec = sys.env("VEC_DIR")
  val out = sys.env("OUT_DIR")
  var passed = 0; var failed = 0
`);
for (const fn of groupFuncNames) {
  mainLines.push(`  { val r = ${fn}(vec, out); passed += r._1; failed += r._2 }`);
}
mainLines.push(`
  println("emit-scala: " + passed + " passed, " + failed + " failed")
  if (failed > 0) sys.exit(1)
}`);
fs.writeFileSync(path.join(outDir, "main.scala"), mainLines.join("\n"));
console.log("Generated emit/main.scala");
