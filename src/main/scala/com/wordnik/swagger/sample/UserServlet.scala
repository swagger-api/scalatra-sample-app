package com.wordnik.swagger.sample

import org.scalatra.ScalatraServlet
import org.scalatra.swagger._

class UserServlet(implicit val swagger: Swagger) extends ScalatraServlet with SwaggerBase with SwaggerSupport {
  protected def buildFullUrl(path: String) = "http://localhost/%s" format path

  get("/:id", summary("Find by ID"), nickname("findById"), responseClass("Book"), endpoint("{id}"), parameters(
    Parameter("id", "ID", DataType.String, paramType = ParamType.Path))) {
    "got a pet!"
  }
}