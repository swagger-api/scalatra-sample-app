package com.wordnik.swagger.sample

import org.scalatra.ScalatraServlet
import org.scalatra.swagger._
import org.json4s.{DefaultFormats, Formats}
import org.scalatra.json.JacksonJsonSupport

class UserServlet(implicit val swagger: Swagger) extends ScalatraServlet with JacksonJsonSupport with SwaggerSupport {

  protected implicit val jsonFormats: Formats = DefaultFormats

  get("/:id", summary("Find by ID"), nickname("findById"), responseClass("Book"), endpoint("{id}"), parameters(
    Parameter("id", "ID", DataType.String, paramType = ParamType.Path))) {
    "got a pet!"
  }
}