package com.wordnik.swagger.sample

import org.scalatra.swagger.{ Swagger, SwaggerBase }

import org.scalatra.{ ScalatraServlet }

import org.eclipse.jetty.server.nio.SelectChannelConnector
import org.eclipse.jetty.server.Server
import org.eclipse.jetty.server.handler.ContextHandlerCollection
import org.eclipse.jetty.servlet.{ ServletContextHandler, ServletHolder }

object PetStore extends App {
  val server = new Server
  implicit val swagger = new PetstoreSwagger

  server setGracefulShutdown 5000
  server setSendServerVersion false
  server setSendDateHeader true
  server setStopAtShutdown true

  val connector = new SelectChannelConnector
  connector setPort 8080
  connector setMaxIdleTime 90000

  server addConnector connector

  val apiServlets = new ServletContextHandler(ServletContextHandler.SESSIONS)
  apiServlets setContextPath "/api"

  val handlers = new ContextHandlerCollection
  handlers addHandler apiServlets

  val petServlet = new PetServlet
  swagger register ("pet", "/pet", "Test", petServlet)
  apiServlets addServlet (new ServletHolder(petServlet), "/pet/*")
  apiServlets addServlet (new ServletHolder(new ResourcesApp), "/*")

  server setHandler handlers
  server start ()
}

class ResourcesApp(implicit val swagger: Swagger) extends ScalatraServlet with SwaggerBase {
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