package com.application.tests.api;
import com.application.api.FakeDataUtil;
import com.google.gson.JsonObject;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class TestsOnLocalAPI {
    String userId;
    String fName = FakeDataUtil.getFirstName();
    String lName = FakeDataUtil.getLastName();
    int id = FakeDataUtil.getUniqueId();

    @Test(priority = 1)
    public void get() {
        baseURI = "http://localhost:3000";
        given().get("/users").then().statusCode(200).log().all();
    }

    @Test(priority = 2)
    public void post() {
        JsonObject request = new JsonObject();
        request.addProperty("id", id);
        request.addProperty("firstName", fName);
        request.addProperty("lastName", lName);
        request.addProperty("subjectId", 1);

        baseURI = "http://localhost:3000";
        Response response =  given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toString())
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .extract().response();
        userId = response.jsonPath().getString("id");
    }

    @Test(priority = 3)
    public void put() {
        JsonObject request = new JsonObject();
        request.addProperty("id", id);
        request.addProperty("firstName", fName);
        request.addProperty("lastName", lName);
        request.addProperty("subjectId", 2);

        baseURI = "http://localhost:3000";
         given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toString())
                .when()
                .put("/users/" + userId)
                .then()
                .statusCode(200);
    }

    @Test(priority = 4)
    public void delete(){
        JsonObject request = new JsonObject();
        request.addProperty("id", id);
        request.addProperty("firstName", fName);
        request.addProperty("lastName", lName);
        request.addProperty("subjectId", 2);

        baseURI = "http://localhost:3000";
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .delete("/users/" + userId)
                .then()
                .statusCode(200);
    }
}
