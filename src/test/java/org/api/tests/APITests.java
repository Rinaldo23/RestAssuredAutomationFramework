package org.api.tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.api.services.UserService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class APITests {

    private HashMap<String, Object> payLoad;

    @BeforeClass
    void generatePayLoad(){
        payLoad = new HashMap<>();
        payLoad.put("id", 150);
        payLoad.put("username", "Virat23");
        payLoad.put("firstName", "Virat");
        payLoad.put("lastName", "Kolhi");
        payLoad.put("email", "virat.kolhi@gmail.com");
        payLoad.put("phone", "9512357486");
        payLoad.put("userStatus", 2);
    }

    @Test(description = "Create a new user using swagger pet store api.")
    void TestOne() {
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

    @Test(description = "Create a new user using swagger pet store api.")
    void TestTwo() {
        Response response = new UserService()
                .createUser(payLoad);

        Assert.assertEquals(response.statusCode(), 200);
        System.out.println(response.asPrettyString());
    }
}
