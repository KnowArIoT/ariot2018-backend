val ScalatraVersion = "2.6.2"

organization := "no.knowit"

name := "ariot2018-backend"

version := "1.0.0-SNAPSHOT"

scalaVersion := "2.12.4"

resolvers += Classpaths.typesafeReleases

libraryDependencies ++= Seq(
  "org.scalatra" %% "scalatra" % ScalatraVersion,
  "org.scalatra" %% "scalatra-scalatest" % ScalatraVersion % "test",
  "ch.qos.logback" % "logback-classic" % "1.2.3" % "runtime",
  "org.eclipse.jetty" % "jetty-webapp" % "9.4.8.v20171121" % "container",
  "javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided",
  "org.scalikejdbc" %% "scalikejdbc" % "3.2.1",
  "com.auth0" % "java-jwt" % "3.0.1",
  "com.corundumstudio.socketio" % "netty-socketio" % "1.7.14",
  "ch.qos.logback" % "logback-classic" % "1.2.3",
  "org.json4s" %% "json4s-jackson" % "3.5.3",
  "org.scalatra" %% "scalatra-json" % "2.6.2",
  "org.scalikejdbc" %% "scalikejdbc-config"  % "3.2.1",
  "org.postgresql" % "postgresql" % "42.2.1"
)

enablePlugins(SbtTwirl)
enablePlugins(ScalatraPlugin)
