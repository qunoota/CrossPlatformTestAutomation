package com.application.tests.api;

import com.application.api.FakeDataUtil;
import com.google.gson.JsonObject;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reporting.ExtentManager;
import com.aventstack.extentreports.ExtentTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static io.restassured.RestAssured.*;

public class TestsOnLocalAPI {
    String userId;
    String fName = FakeDataUtil.getFirstName();
    String lName = FakeDataUtil.getLastName();
    int id = FakeDataUtil.getUniqueId();
    private static final Logger logger = LogManager.getLogger(TestsOnLocalAPI.class);
    private ExtentTest test;

    @BeforeMethod
    public void setUp() {
        ExtentManager.initReports();
    }

    @Test(priority = 1)
    public void get() {
        test = ExtentManager.createTest("GET Request - Retrieve Users");
        logger.info("Starting GET request to retrieve users.");
        baseURI = "http://localhost:3000";

        test.info("Sending GET request to retrieve users.");
        given()
                .get("/users")
                .then()
                .statusCode(200)
                .log().all();

        logger.info("GET request successful. Status code 200.");
        test.pass("GET request successful with status code 200.");
    }

    @Test(priority = 2)
    public void post() {
        test = ExtentManager.createTest("POST Request - Create New User");
        logger.info("Starting POST request to create a new user.");

        JsonObject request = new JsonObject();
        request.addProperty("id", id);
        request.addProperty("firstName", fName);
        request.addProperty("lastName", lName);
        request.addProperty("subjectId", 1);

        baseURI = "http://localhost:3000";
        logger.debug("POST request payload: " + request.toString());
        test.info("Sending POST request with payload: " + request.toString());

        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toString())
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .extract().response();

        userId = response.jsonPath().getString("id");
        logger.info("POST request successful. User ID created: " + userId);
        test.pass("POST request successful. User ID created: " + userId);
    }

    @Test(priority = 3)
    public void put() {
        test = ExtentManager.createTest("PUT Request - Update User");
        logger.info("Starting PUT request to update user with ID: " + userId);

        JsonObject request = new JsonObject();
        request.addProperty("id", id);
        request.addProperty("firstName", fName);
        request.addProperty("lastName", lName);
        request.addProperty("subjectId", 2);

        baseURI = "http://localhost:3000";
        logger.debug("PUT request payload: " + request.toString());
        test.info("Sending PUT request to update user with payload: " + request.toString());

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toString())
                .when()
                .put("/users/" + userId)
                .then()
                .statusCode(200);

        logger.info("PUT request successful. User ID: " + userId + " updated.");
        test.pass("PUT request successful for User ID: " + userId);
    }

    @Test(priority = 4)
    public void delete() {
        test = ExtentManager.createTest("DELETE Request - Remove User");
        logger.info("Starting DELETE request to remove user with ID: " + userId);

        baseURI = "http://localhost:3000";
        test.info("Sending DELETE request for User ID: " + userId);

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .delete("/users/" + userId)
                .then()
                .statusCode(200);

        logger.info("DELETE request successful. User ID: " + userId + " deleted.");
        test.pass("DELETE request successful for User ID: " + userId);
    }

    @AfterMethod
    public void tearDown() {
        ExtentManager.flushReports(); // Write the report to file
    }
}