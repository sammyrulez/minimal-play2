package controllers

/**
  * Created by sam on 17/12/16.
  */
import io.circe.generic.auto._
import io.circe.syntax._
import io.swagger.annotations._
import io.swagger.config.ConfigFactory
import models.User
import pdi.jwt._
import play.api._
import play.api.libs.circe.Circe
import play.api.mvc._
import play.modules.swagger.{PlayConfigFactory, PlaySwaggerConfig}


@Api(
value = "/api",
produces = "application/json",
consumes = "application/json"

  // authorizations = Array(new ApiKeyAuthDefinition("api_key",In.HEADER))
)
@SwaggerDefinition(securityDefinition = new SecurityDefinition(apiKeyAuthDefintions = Array(new ApiKeyAuthDefinition(name= "api_key", key="api_key", in=ApiKeyAuthDefinition.ApiKeyLocation.HEADER))))
class CirceController extends Controller with Circe {

  case class Bar(bar: Int)
  case class Foo(foo: String, bar: Bar)
  val bar = Bar(1)
  val foo = Foo("foo", bar)
  val config: PlaySwaggerConfig = PlayConfigFactory.getConfig



  @ApiOperation(value = "get All Todos",
    notes = "Returns List of all Todos",
    response = classOf[Foo], httpMethod = "GET",authorizations = Array(new Authorization(value="api_key")))
  def get = AuthenticatedAction { request =>

    val foo = Foo(request.jwtSession.getAs[User]("user").getOrElse(new User("Anonymous")).name, bar)

    Ok(foo.asJson)
  }

  /*parse json to case class
  def post = Action(circe.json[Foo]) { implicit request =>
    val isEqual = request.body == foo
    Ok(isEqual.toString)
  }

  def postJson = Action(circe.json) { implicit request =>
    val isEqual = request.body == foo.asJson
    Ok(isEqual.toString)
  }

  def postTolerate = Action(circe.tolerantJson[Foo]) { implicit request =>
    val isEqual = request.body == foo
    Ok(isEqual.toString)
  }

  def postTolerateJson = Action(circe.tolerantJson) { implicit request =>
    val isEqual = request.body == foo.asJson
    Ok(isEqual.toString)
  }*/
}