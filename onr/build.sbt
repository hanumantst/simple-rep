name := """onr"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava,PlayEbean)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  javaJdbc,
  "mysql" % "mysql-connector-java" %"5.1.35",
  cache,
  javaWs,
  javaJpa,
  evolutions
)
Keys.javaOptions+="-Dconfig.file=conf/application.conf"
// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
//routesGenerator := InjectedRoutesGenerator
