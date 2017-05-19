package controllers

import models.User
import play.api.mvc.{Action, Controller}
import pdi.jwt._



class ApplicationController extends Controller {
  def index = Action {
    val jwt = JwtSession() + ("user", User( "Paul"))
    Ok("HI, you are \n" + jwt.serialize  )
  }


}
