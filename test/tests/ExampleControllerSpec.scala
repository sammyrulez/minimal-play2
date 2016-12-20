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

import scala.concurrent.Future

class ExampleControllerSpec extends PlaySpec with Results {


  val foo: String = "{\"foo\":\"foo\",\"bar\":{\"bar\":1}}"

  "Example Application#index" should {
    "should be OK" in {
      val controller = new ApplicationController()
      val result: Future[Result] = controller.index().apply(FakeRequest())
      val bodyText: String = contentAsString(result)
      bodyText mustBe "OK!"

    }
  }



  "Example CirceController#get" should {
    "should be valid json a Foo" in {
      val controller = new CirceController ()
      val result: Future[Result] = controller.get().apply(FakeRequest())
      val bodyText: String = contentAsString(result)
      bodyText mustBe foo

    }

    
  }
}