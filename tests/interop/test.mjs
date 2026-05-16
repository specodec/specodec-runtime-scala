import { execSync } from "child_process";
import { readFileSync, existsSync, mkdirSync, rmSync, readdirSync } from "fs";
import { join, dirname } from "path";
import { fileURLToPath } from "url";

const __dir = dirname(fileURLToPath(import.meta.url));
const CACHE = join(__dir, ".tests-cache");
const GENERATED = join(__dir, "src", "generated");
const OUT_DIR = join(__dir, "output");
const RUNTIME = join(__dir, "..", "..", "src", "main", "scala", "specodec");

function run(cmd) { console.log("  >", cmd); execSync(cmd, { stdio: "inherit" }); }
function ensure(dir) { if (!existsSync(dir)) mkdirSync(dir, { recursive: true }); }

console.log("\n=== Step 0: Install deps ===");
run(`cd ${__dir} && npm install`);
run(`cd ${CACHE} && npm install`);
run(`cd ${CACHE} && node gen_types.mjs`);
const VEC_DIR = join(CACHE, "vectors");

console.log("\n=== Step 1: Generate Scala code ===");
if (existsSync(GENERATED)) rmSync(GENERATED, { recursive: true });
ensure(GENERATED);
run(`cd ${__dir} && node_modules/.bin/tsp compile ${CACHE}/alltypes.tsp --emit=@specodec/typespec-emitter-scala --option @specodec/typespec-emitter-scala.emitter-output-dir=${GENERATED}`);

console.log("\n=== Step 2: Generate test runner ===");
run(`cd ${__dir} && VEC_DIR=${VEC_DIR} node generate_emit_runner.mjs`);

console.log("\n=== Step 3: Compile and run ===");
if (existsSync(OUT_DIR)) rmSync(OUT_DIR, { recursive: true });
ensure(OUT_DIR);

// Build absolute file lists
const genFiles = readdirSync(GENERATED).filter(f => f.endsWith(".scala")).map(f => `${GENERATED}/${f}`);
const emitFiles = readdirSync(join(__dir, "emit")).filter(f => f.endsWith(".scala")).map(f => `${__dir}/emit/${f}`);
const ryuFiles = readdirSync(join(RUNTIME, "ryu")).filter(f => f.endsWith(".scala")).map(f => `${RUNTIME}/ryu/${f}`);
const rtFiles = readdirSync(RUNTIME).filter(f => f.endsWith(".scala")).map(f => `${RUNTIME}/${f}`);
const allFiles = [...emitFiles, ...genFiles, ...rtFiles, ...ryuFiles];

console.log(`  ${allFiles.length} source files`);
run(`VEC_DIR=${VEC_DIR} OUT_DIR=${OUT_DIR} scala-cli run --server=false ${allFiles.join(" ")}`);

console.log("\n=== Step 4: Compare output ===");
const manifest = JSON.parse(readFileSync(join(VEC_DIR, "manifest.json"), "utf-8"));
let match = 0, mismatch = 0;

for (const [name] of Object.entries(manifest.scalars || {})) {
  const expected = join(VEC_DIR, "scalars", `${name}.mp`);
  const actual = join(OUT_DIR, "scalars", `${name}.mp`);
  if (!existsSync(actual)) { mismatch++; console.log(`MISSING: ${name}.mp`); continue; }
  if (readFileSync(expected).equals(readFileSync(actual))) match++;
  else { mismatch++; console.log(`MISMATCH: ${name}.mp`); }
}
for (const model of [...(manifest.testModels || []), ...(manifest.testUnions || [])]) {
  for (const [outExt, vecExt] of [["msgpack","msgpack"], ["json","json"], ["unformatted.json","json"], ["gron","gron"]]) {
    const expected = join(VEC_DIR, `${model}.${vecExt}`);
    const actual = join(OUT_DIR, `${model}.${outExt}`);
    if (!existsSync(expected)) continue;
    if (!existsSync(actual)) { mismatch++; if (mismatch <= 5) console.log(`MISSING: ${model}.${outExt}`); continue; }
    if (readFileSync(expected).equals(readFileSync(actual))) match++;
    else { mismatch++; if (mismatch <= 5) console.log(`MISMATCH: ${model}.${outExt}`); }
  }
}
const total = match + mismatch;
console.log(`${match}/${total} match, ${mismatch} mismatch`);
if (mismatch > 0) process.exit(1);
console.log("\n=== ALL PASSED ===");
