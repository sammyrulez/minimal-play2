package models

import play.api.libs.json._
import play.api.libs.functional.syntax._
/**
  * Created by sam on 23/12/16.
  */
case class User(name: String) {
  val isAdmin = true
}

object User {
  implicit val userFormat = Json.format[User]
}
