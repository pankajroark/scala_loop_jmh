name := """sbt-jmh-seed"""

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  // Add your own project dependencies in the form:
  // "group" % "artifact" % "version"
)

enablePlugins(JmhPlugin)


fork in run := true