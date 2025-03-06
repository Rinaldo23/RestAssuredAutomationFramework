package org.api.tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.api.models.request.CreateUserBPRequest;
import org.api.models.request.CreateUserRequest;
import org.api.models.response.CreateUserResponse;
import org.api.services.UserService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class APITests {

    private HashMap<String, Object> payLoad;

    @BeforeClass
    void generatePayLoad() {
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

    @Test(description = "Get user by using username - swagger pet store api.")
    void TestThree() {
        String username = "Virat23";

        Response response = new UserService()
                .getUserByUsername(username);

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.body().jsonPath().getInt("id"), 150);
        System.out.println(response.asPrettyString());
    }

    @Test(description = "Create a new user from Models - using swagger pet store api.")
    void TestFour() {

        CreateUserRequest data = new CreateUserRequest("abc@gmail.com", "demo", 200,
                "user", "9874562317", "demoUser", 10);

        Response response = new UserService()
                .createUser(data);

        CreateUserResponse createUserResponse = response.as(CreateUserResponse.class);

        Assert.assertEquals(createUserResponse.getMessage(), "200");
        Assert.assertEquals(createUserResponse.getCode(), "200");
        Assert.assertEquals(response.statusCode(), 200);
        System.out.println(response.asPrettyString());
    }

    @Test(description = "Create a new user from Models using Builder Pattern- using swagger pet store api.")
    void TestFive() {

        CreateUserBPRequest payload = new CreateUserBPRequest.Builder()
                .setFirstName("Rohit")
                .setLastName("Sharma")
                .setEmail("rohit.sharma@gmail.com")
                .setUsername("rohit23")
                .setPhone("9874563217")
                .setId(25)
                .setUserStatus(15)
                .build();

        Response response = new UserService()
                .createUser(payload);

        CreateUserResponse createUserResponse = response.as(CreateUserResponse.class);

        Assert.assertEquals(createUserResponse.getMessage(), "25");
        Assert.assertEquals(createUserResponse.getCode(), "200");
        Assert.assertEquals(response.statusCode(), 200);
        System.out.println(response.asPrettyString());
    }
}
