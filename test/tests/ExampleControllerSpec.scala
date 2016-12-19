package tests

import controllers.CirceController
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

  "Example CirceController#get" should {
    "should be valid json list of FooS" in {
      val controller = new CirceController ()
      val result: Future[Result] = controller.get().apply(FakeRequest())
      val bodyText: String = contentAsString(result)
      bodyText mustBe "{\"foo\":\"foo\",\"bar\":{\"bar\":1}}"

    }
  }
}