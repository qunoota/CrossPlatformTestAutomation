package com.application.tests.api;

import com.google.gson.JsonObject;
import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class TestsOnLocalAPI {

    @Test
    public void get() {
        baseURI = "http://localhost:3000";
        given().get("/users").then().statusCode(200).log().all();
    }

    @Test
    public void post() {
        Faker faker = new Faker();
        String fName = faker.name().firstName();
        String lName = faker.name().lastName();

        JsonObject request = new JsonObject();
        request.addProperty("firstName", fName); // Use Faker-generated first name
        request.addProperty("lastName", lName); // Use Faker-generated last name
        request.addProperty("subjectId", 1);

        baseURI = "http://localhost:3000";

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toString()) // Convert JsonObject to string
                .when()
                .post("/users")
                .then()
                .statusCode(201);
    }

    @Test
    public void put() {
        Faker faker = new Faker();
        String fName = faker.name().firstName();
        String lName = faker.name().lastName();

        JsonObject request = new JsonObject();
        request.addProperty("firstName", fName);
        request.addProperty("lastName", lName);
        request.addProperty("subjectId", 2);

        baseURI = "http://localhost:3000";

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toString()) // Convert JsonObject to string
                .when()
                .put("/users/4")
                .then()
                .statusCode(200);
    }
}
