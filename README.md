Want to start your [Play 2](https://www.playframework.com/documentation/2.5.x/Home) development, but don't feel like dealing with all the extra fluff that comes with [Typesafe Activator](https://www.typesafe.com/activator/docs) or the example applications?

Minimal json api featuring Circe serialization and swagger support.

Original work by [@futurice](https://github.com/futurice/minimal-play2.git)


# The minimal setup for a Play framework 2.5.3 Json/API project

[![Build Status](https://travis-ci.org/sammyrulez/minimal-play2.svg?branch=master)](https://travis-ci.org/sammyrulez/minimal-play2) [![Coverage Status](https://coveralls.io/repos/github/sammyrulez/minimal-play2/badge.svg?branch=master)](https://coveralls.io/github/sammyrulez/minimal-play2?branch=master)

##Features
* JSON serialization / deserialization
* Controller testing
* CI integration
* Coverage
* Monitoring with [markscheider](https://github.com/zalando-incubator/markscheider) publishing metrics to [ZMON](https://github.com/zalando/zmon) (see a [demo](https://demo.zmon.io))
* Release
* Heroku deploy

##Road map
* jwt authentication
* Docker image


##Intallation

* Install [Sbt](http://www.scala-sbt.org/index.html)
  * OS X: `brew install sbt`
* Clone this repo
* In the root of this repo: `sbt`
* In the Sbt console that just opened: `run`
* See [http://localhost:9000/webjars/swagger-ui/2.2.6/index.html?url=http://localhost:9000/swagger.json](http://localhost:9000/webjars/swagger-ui/2.2.6/index.html?url=http://localhost:9000/swagger.json)

##Demo

[Swagger ui](http://minimal-play2.herokuapp.com/webjars/swagger-ui/2.2.6/index.html?url=http://minimal-play2.herokuapp.com/swagger.json)

