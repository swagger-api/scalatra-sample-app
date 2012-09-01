package com.wordnik.swagger.sample

import org.scalatra.swagger.{JacksonSwaggerBase, Swagger, SwaggerBase}

import org.scalatra.ScalatraServlet
import com.fasterxml.jackson.databind._
import org.json4s.jackson.Json4sScalaModule
import org.json4s.{DefaultFormats, Formats}


class ResourcesApp(implicit val swagger: Swagger) extends ScalatraServlet with JacksonSwaggerBase {

  protected implicit val jsonFormats: Formats = DefaultFormats

  before() {
    response.headers += ("Access-Control-Allow-Origin" -> "*")
  }

  protected def buildFullUrl(path: String) = if (path.startsWith("http")) path else {
    "http://%s:%s/%s/%s".format(
      request.getServerName,
      request.getServerPort,
      request.getContextPath,
      path)
  }
}

class PetstoreSwagger extends Swagger("1.0", "1")