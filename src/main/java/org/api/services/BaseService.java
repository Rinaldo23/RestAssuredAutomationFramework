package org.api.services;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class BaseService {

    private final RequestSpecification requestSpecification;
    private static final String BASE_URI = "https://petstore.swagger.io/v2/";

    public BaseService(){
        requestSpecification = given().baseUri(BASE_URI);
    }

    Response postRequest(String endpoint, Object payload){
        return requestSpecification
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .post(endpoint);
    }

    Response getRequest(String endpoint){
        return requestSpecification
                .accept(ContentType.JSON)
                .get(endpoint);
    }
}
