lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    organization := "com.github.sammyrulez",
    name := "minimal-play2",
    version <<= version in ThisBuild,
    scalaVersion := "2.11.8"
  )


resolvers += "Bintary JCenter" at "http://jcenter.bintray.com"

resolvers += "sammyrulez" at "https://raw.githubusercontent.com/sammyrulez/my-maven-repo/master/"

libraryDependencies += "play-circe" %% "play-circe" % "2.5-0.6.0"

libraryDependencies ++= Seq("io.swagger" %% "swagger-play2" % "1.5.4-SNAPSHOT")

libraryDependencies ++= Seq("org.zalando" %% "markscheider" % "2.5.2")

libraryDependencies ++= Seq("com.pauldijou" %% "jwt-play" % "0.9.2")

libraryDependencies ++= Seq("org.scalatestplus.play" %% "scalatestplus-play" % "1.5.0" % "test")

libraryDependencies ++= Seq(
  "org.webjars" 			%% 	"webjars-play" 			% "2.5.0-4",
  "org.webjars" % "swagger-ui" % "2.2.6"
)

coverageMinimum := 80

coverageFailOnMinimum := true


import sbtrelease.ReleaseStateTransformations._

releaseProcess := Seq(
  inquireVersions,
  setReleaseVersion,
  commitReleaseVersion,
  tagRelease,
  setNextVersion,
  commitNextVersion,
  pushChanges
)

coverageExcludedPackages := "controllers\\..*Reverse.*;router.Routes.*;org.zalando.markscheider.*"

publishTo := Some(Resolver.file("file",  new File( "/tmp/fakerepo" )) )







