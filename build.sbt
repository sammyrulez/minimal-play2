lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    organization := "com.github.sammyrulez",
    name := "minimal-play2",
    version := "1.1.0",
    scalaVersion := "2.11.8"
  )

resolvers += "Bintary JCenter" at "http://jcenter.bintray.com"

libraryDependencies += "play-circe" %% "play-circe" % "2.5-0.6.0"

libraryDependencies ++= Seq("io.swagger" %% "swagger-play2" % "1.5.3")

libraryDependencies ++= Seq("org.scalatestplus.play" %% "scalatestplus-play" % "1.5.0" % "test")

libraryDependencies ++= Seq(
  "org.webjars" 			%% 	"webjars-play" 			% "2.5.0-4",
  "org.webjars" % "swagger-ui" % "2.2.6"
)

coverageMinimum := 80

coverageFailOnMinimum := true

coverageExcludedPackages := """controllers\..*Reverse.*;router.Routes.*;"""







