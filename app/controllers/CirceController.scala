package controllers

/**
  * Created by sam on 17/12/16.
  */
import io.circe.generic.auto._
import io.circe.syntax._
import io.swagger.annotations.{Api, ApiOperation}
import play.api._
import play.api.libs.circe.Circe
import play.api.mvc._


@Api(value = "/api", description = "Operations with Todos")
class CirceController extends Controller with Circe {

  case class Bar(bar: Int)
  case class Foo(foo: String, bar: Bar)

  val bar = Bar(1)
  val foo = Foo("foo", bar)

  @ApiOperation(value = "get All Todos",
    notes = "Returns List of all Todos",
    response = classOf[Foo], httpMethod = "GET")
  def get = Action {
    Ok(foo.asJson)
  }

  //parse json to case class
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
  }
}