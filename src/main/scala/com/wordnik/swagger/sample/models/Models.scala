package com.wordnik.swagger.sample.models

case class Pet(id: Long, category: Category, name: String, urls: List[String], tags: List[Tag], status: String)
case class Tag(id: Long, name: String)
case class Category(id: Long, name: String)

case class ApiResponse(code: String, msg: String)

object ApiResponseType {
  val ERROR = "error"
  val WARNING = "warning"
  val INFO = "info"
  val OK = "ok"
  val TOO_BUSY = "too busy"
}