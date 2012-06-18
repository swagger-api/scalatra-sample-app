package com.wordnik.swagger.sample

import org.scalatra.ScalatraServlet
import org.scalatra.swagger._

class PetServlet(implicit val swagger: Swagger) extends ScalatraServlet with SwaggerBase with SwaggerSupport {
  protected def buildFullUrl(path: String) = "http://localhost/%s" format path

  get("/:id",
    summary("Find by ID"),
    nickname("findById"),
    responseClass("Pet"),
    endpoint("{id}"),
    notes("Returns a pet when ID < 10. ID > 10 or nonintegers will simulate API error conditions"),
    parameters(
      Parameter("id", "ID of pet that needs to be fetched",
        DataType.String,
        paramType = ParamType.Path))) {
      "got a pet!"
    }

  post("/",
    summary("Add a new pet to the store"),
    nickname("addPet"),
    responseClass("void"),
    endpoint(""), // TODO shouldn't this be from the first param?  also missing the .{format}
    parameters(
      Parameter("body", "Pet object that needs to be added to the store",
        DataType("Pet"),
        paramType = ParamType.Body))) {
      "added a pet!"
    }

  put("/",
    summary("Update an existing pet"),
    nickname("updatePet"),
    responseClass("void"),
    endpoint(""),
    parameters(
      Parameter("body", "Pet object that needs to be updated in the store",
        DataType("Pet"),
        paramType = ParamType.Body))) {
      "added a pet!"
    }

  get("/findByStatus",
    summary("Finds Pets by status"),
    nickname("findPetsByStatus"),
    responseClass("Pet"), // TODO: missing multi-valued response?
    endpoint("findByStatus"),
    notes("Multiple status values can be provided with comma seperated strings"),
    parameters(
      Parameter("status",
        "Status values that need to be considered for filter",
        DataType.String,
        paramType = ParamType.Query,
        defaultValue = Some("available"),
        allowableValues = AllowableValues.Any))) { // TODO: set allowable values
      val status = params("status")
        "findByStatus"
    }
  
  get("/findByTags",
    summary("Finds Pets by tags"),
    nickname("findByTags"),
    responseClass("Pet"), // TODO: missing multi-valued response?
    endpoint("findByTags"),
    notes("Muliple tags can be provided with comma seperated strings. Use tag1, tag2, tag3 for testing."),
    parameters(
      Parameter("tags",
        "Tags to filter by",
        DataType.String,
        paramType = ParamType.Query))) {
      val tags = params("tags")
        "got a pet!"
    }
}