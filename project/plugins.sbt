resolvers += "Typesafe repository" at "https://repo.typesafe.com/typesafe/releases/"

addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.6.0-M5")

addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.5.0")

addSbtPlugin("org.scoverage" % "sbt-coveralls" % "1.1.0")

addSbtPlugin("com.github.gseitz" % "sbt-release" % "1.0.3")

addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.8.2")