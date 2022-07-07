package API_Testing.StudentPractice;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class api_Activities {
    // Testing URI = https://fakerestapi.azurewebsites.net/api/v1/

    // Task 1: Using Rest Assured validate the status code for endpoint / Activities
    @Test
    public void verifyStatusCode() {
        RestAssured.given()
                .when()
                .get("https://fakerestapi.azurewebsites.net/api/v1/Activities")
                .then()
                .statusCode(200);
        System.out.println("Test verified, status code is 200");
    }

    // Task 2: Using Rest Assured Validate Content-Type is application/json; charset=utf-8; v=1.0
    // for endpoint /Activities
    @Test
    public void verifyContentType() {
        RestAssured.given()
                .when()
                .get("https://fakerestapi.azurewebsites.net/api/v1/Activities")
                .then()
                .contentType(ContentType.JSON);
        System.out.println("Test verified content type is JSON");
    }

    // Task 1: Using Rest Assured validate the status code for endpoint / Activities/ 12
    @Test
    public void verifyStatusCode1() {
        RestAssured.given()
                .when()
                .get("https://fakerestapi.azurewebsites.net/api/v1/Activities/12")
                .then()
                .statusCode(200);
        System.out.println("Test verified status code is 200");
    }

    // Task 2: Using Rest Assured Validate Content-Type is application/json; charset=utf-8; v=1.0
    // for endpoint /Activities
    @Test
    public void verifyContentType1() {
        RestAssured.given()
                .when()
                .get("https://fakerestapi.azurewebsites.net/api/v1/Activities/12")
                .then()
                .contentType(ContentType.JSON);
        System.out.println("Test verified content type is JSON");
    }
}