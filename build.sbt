name := "specodec-runtime-scala"
version := "0.0.1"
scalaVersion := "3.6.4"

// Disable cross-compilation
crossPaths := false

// Publish to Forgejo Maven
publishTo := Some("Forgejo Maven" at "http://10.199.64.20:30000/api/packages/specodec/maven")
credentials += Credentials("Forgejo Maven", "10.199.64.20:30000", "ytr", "12345678")  // Override in CI

organization := "io.specodec"
publishMavenStyle := true

// Scala library is the only dependency (multiplatform API)
libraryDependencies += "org.scala-lang" %% "scala3-library" % "3.6.4" % "provided"
