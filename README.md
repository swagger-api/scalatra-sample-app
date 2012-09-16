1. Launch [SBT](http://code.google.com/p/simple-build-tool).

```
./sbt
```

2. Run Jetty

```
container:start
```

3. Go to `http://localhost:8080/api/resources.json` to get the full service description
   If everything is alright you should see this json:

```json
{
  "apiVersion": "1", 
  "apis": [
     {
        "description": "The pets api", 
        "path": "/api/pet.{format}"
     }
  ], 
  "basePath": "http://localhost:8080/api/", 
  "swaggerVersion": "1.0"
}
```

4. Go to `http://localhost:8080/api/pet.json` to see the description of a single service

```json
{
    "apiVersion": "1", 
    "apis": [
        {
            "description": "", 
            "operations": [
                {
                    "deprecated": false, 
                    "errorResponses": [], 
                    "httpMethod": "GET", 
                    "nickname": "allPets", 
                    "notes": "shows all the pets in the data store", 
                    "parameters": [], 
                    "responseClass": "Pet", 
                    "summary": "Show all pets"
                }, 
                {
                    "deprecated": false, 
                    "errorResponses": [], 
                    "httpMethod": "PUT", 
                    "nickname": "updatePet", 
                    "parameters": [
                        {
                            "allowMultiple": false, 
                            "dataType": "Pet", 
                            "description": "Pet object that needs to be updated in the store", 
                            "name": "body", 
                            "paramType": "body", 
                            "required": true
                        }
                    ], 
                    "responseClass": "void", 
                    "summary": "Update an existing pet"
                }, 
                {
                    "deprecated": false, 
                    "errorResponses": [], 
                    "httpMethod": "POST", 
                    "nickname": "addPet", 
                    "parameters": [
                        {
                            "allowMultiple": false, 
                            "dataType": "Pet", 
                            "description": "Pet object that needs to be added to the store", 
                            "name": "body", 
                            "paramType": "body", 
                            "required": true
                        }
                    ], 
                    "responseClass": "void", 
                    "summary": "Add a new pet to the store"
                }
            ], 
            "path": "/api/pet/", 
            "secured": true
        }, 
        {
            "description": "", 
            "operations": [
                {
                    "deprecated": false, 
                    "errorResponses": [], 
                    "httpMethod": "GET", 
                    "nickname": "findPetsByStatus", 
                    "notes": "Multiple status values can be provided with comma seperated strings", 
                    "parameters": [
                        {
                            "allowMultiple": false, 
                            "dataType": "string", 
                            "defaultValue": "available", 
                            "description": "Status values that need to be considered for filter", 
                            "name": "status", 
                            "paramType": "query", 
                            "required": true
                        }
                    ], 
                    "responseClass": "Pet", 
                    "summary": "Finds Pets by status"
                }
            ], 
            "path": "/api/pet/findByStatus", 
            "secured": true
        }, 
        {
            "description": "", 
            "operations": [
                {
                    "deprecated": false, 
                    "errorResponses": [], 
                    "httpMethod": "GET", 
                    "nickname": "findByTags", 
                    "notes": "Muliple tags can be provided with comma seperated strings. Use tag1, tag2, tag3 for testing.", 
                    "parameters": [
                        {
                            "allowMultiple": false, 
                            "dataType": "string", 
                            "description": "Tags to filter by", 
                            "name": "tags", 
                            "paramType": "query", 
                            "required": true
                        }
                    ], 
                    "responseClass": "Pet", 
                    "summary": "Finds Pets by tags"
                }
            ], 
            "path": "/api/pet/findByTags", 
            "secured": true
        }, 
        {
            "description": "", 
            "operations": [
                {
                    "deprecated": false, 
                    "errorResponses": [], 
                    "httpMethod": "GET", 
                    "nickname": "findById", 
                    "notes": "Returns a pet when ID < 10. ID > 10 or nonintegers will simulate API error conditions", 
                    "parameters": [
                        {
                            "allowMultiple": false, 
                            "dataType": "string", 
                            "description": "ID of pet that needs to be fetched", 
                            "name": "id", 
                            "paramType": "path", 
                            "required": true
                        }
                    ], 
                    "responseClass": "Pet", 
                    "summary": "Find by ID"
                }
            ], 
            "path": "/api/pet/{id}", 
            "secured": true
        }
    ], 
    "basePath": "http://localhost:8080/api/", 
    "description": "The pets api", 
    "models": {
        "Pet": {
            "description": "Pet", 
            "id": "Pet", 
            "properties": {
                "category": {
                    "description": null, 
                    "enum": [], 
                    "name": "category", 
                    "required": true, 
                    "type": "Category"
                }, 
                "id": {
                    "description": null, 
                    "enum": [], 
                    "name": "id", 
                    "required": true, 
                    "type": "long"
                }, 
                "name": {
                    "description": null, 
                    "enum": [], 
                    "name": "name", 
                    "required": true, 
                    "type": "string"
                }, 
                "status": {
                    "description": null, 
                    "enum": [], 
                    "name": "status", 
                    "required": true, 
                    "type": "string"
                }, 
                "tags": {
                    "description": null, 
                    "enum": [], 
                    "name": "tags", 
                    "required": true, 
                    "type": "List[Tag]"
                }, 
                "urls": {
                    "description": null, 
                    "enum": [], 
                    "name": "urls", 
                    "required": true, 
                    "type": "List[string]"
                }
            }
        }
    }, 
    "resourcePath": "/api/pet", 
    "swaggerVersion": "1.0"
}
```

5. Visit `http://localhost:8080/api/pet/1` to see a single pet json

```json
{
    "category": {
        "id": 2, 
        "name": "Cats"
    }, 
    "id": 1, 
    "name": "Cat 1", 
    "status": "available", 
    "tags": [
        {
            "id": 1, 
            "name": "tag1"
        }, 
        {
            "id": 2, 
            "name": "tag2"
        }
    ], 
    "urls": [
        "url1", 
        "url2"
    ]
}
```

