package tests

import controllers.{ApplicationController, CirceController}
import org.scalatestplus.play._

import scala.collection.mutable
import org.scalatestplus.play._
import play.api.mvc._
import play.api.test._
import play.api.test.Helpers._
import io.circe.generic.auto._
import io.circe.syntax._
import models.User
import pdi.jwt.JwtSession

import scala.concurrent.Future

class ExampleControllerSpec extends PlaySpec with Results {


  val foo: String = "{\"foo\":\"Anonymous\",\"bar\":{\"bar\":1}}"


  "Example Application#index" should {
    "should be OK" in {
      val controller = new ApplicationController()
      val result: Future[Result] = controller.index().apply(FakeRequest())
      val bodyText: String = contentAsString(result)
      bodyText.startsWith( "HI, you are") mustBe true

    }
  }



  "Example CirceController#get" should {
    "should be valid json a Foo" in {
      val controller = new CirceController ()
      val session2 = JwtSession() + ("user", User("Paul"))
      val request = FakeRequest().withHeaders(("Authorization", "Bearer " + session2.serialize))
      val result: Future[Result] = controller.get().apply(request)
      val bodyText: String = contentAsString(result)
      bodyText mustBe foo

    }

    
  }
}