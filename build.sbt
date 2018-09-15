import play.ebean.sbt.PlayEbean.autoImport.playEbeanModels

name := """actor-oriented"""

lazy val commonSettings = Seq(
  organization := "com.github.qyf404",
  version := "1.0-SNAPSHOT",
  scalaVersion := "2.12.6",
  resourceDirectory in Test := baseDirectory.value / "test-resources",
  libraryDependencies ++= Seq(
    guice,
    evolutions,
    ws,
    "com.github.gitssie" %% "play-akkajobs" % "2.6.6",
    "javax.xml.bind" % "jaxb-api" % "2.3.0",
    "javax.el" % "javax.el-api" % "3.0.0",
    "commons-io" % "commons-io" % "2.5",
    "org.glassfish" % "javax.el" % "3.0.0",
    "org.postgresql" % "postgresql" % "9.3-1102-jdbc4",
    "org.hamcrest" % "hamcrest-library" % "1.3" % "test",
    "org.mockito" % "mockito-core" % "2.1.0" % "test"
  ),
  dependencyOverrides ++= Seq(
    "com.typesafe.akka" %% "akka-stream" % "2.5.11",
    "com.typesafe.akka" %% "akka-actor" % "2.5.11",
    "com.google.guava" % "guava" % "22.0",
    "org.avaje" % "avaje-classpath-scanner" % "3.1.1"
  ),
  playEbeanModels in Compile := Seq(
    "com.github.qyf404.*.model.*"
  ),
  playEbeanModels in Test := Seq(
    "com.github.qyf404.*.model.*"
  ),
  javacOptions ++= Seq("-source", "1.8", "-target", "1.8")
)

lazy val root = (project in file("."))
  .settings(commonSettings: _*)
  .enablePlugins(PlayJava, PlayEbean)

