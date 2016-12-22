package tests

import akka.stream.Materializer
import org.scalatest._
import org.scalatestplus.play._
import play.api.Play
import play.api.inject.guice.GuiceApplicationBuilder
import play.api.libs.ws.WSClient
import play.api.test._
import play.api.test.Helpers.{GET => GET_REQUEST, _}
/**
  * Created by sam on 22/12/16.
  */
class ExampleEssentialActionSpec extends PlaySpec with OneServerPerSuite {

  implicit lazy val materializer: Materializer = app.materializer

  implicit override lazy val app = new GuiceApplicationBuilder().configure(Map("ehcacheplugin" -> "disabled")).build()

  "The OneAppPerSuite trait" must {
    "provide an Application" in {
      app.configuration.getString("ehcacheplugin") mustBe Some("disabled")
    }
    "start the Application" in {
      Play.maybeApplication mustBe Some(app)
    }
    "test server logic" in {
      val wsClient = app.injector.instanceOf[WSClient]
      val myPublicAddress =  s"127.0.0.1:$port"
      val testPaymentGatewayURL = s"http://$myPublicAddress/api"
      val response = await(wsClient.url(testPaymentGatewayURL).get())

      response.status mustBe OK
    }
  }
}
