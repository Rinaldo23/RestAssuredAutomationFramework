package org.api.tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class APITests {

    @Test(description = "Create a new user using swagger pet store api.")
    void TestOne() {

        HashMap<String, Object> payLoad = new HashMap<>();
        payLoad.put("id", 1);
        payLoad.put("username", "Virat23");
        payLoad.put("firstName", "Virat");
        payLoad.put("lastName", "Kolhi");
        payLoad.put("email", "virat.kolhi@gmail.com");
        payLoad.put("phone", "9512357486");
        payLoad.put("userStatus", 2);

        Response response = given()
                .baseUri("https://petstore.swagger.io/v2/")
                .pathParam("basePath", "user")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payLoad)
                .when()
                .post("{basePath}");

        Assert.assertEquals(response.statusCode(), 200);
        System.out.println(response.asPrettyString());

    }
}
