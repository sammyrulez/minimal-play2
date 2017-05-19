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

libraryDependencies += guice

libraryDependencies ++= Seq("com.pauldijou" %% "jwt-play" % "0.12.1")

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







