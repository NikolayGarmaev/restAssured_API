package workspaceRestAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.apache.http.HttpStatus.SC_OK;
import java.util.HashMap;
import java.util.Map;

public class E2E_Project {

    public String path;
    String memberOf = "/workspaces/member-of";

    // What is a TestNG annotation that allows us to run a Test Before each method
    @BeforeTest
    public String setupLogInAndToken() {
        RestAssured.baseURI = "https://api.octoperf.com";
        path = "/public/users/login";

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("password", "aldar1018");
        map.put("username", "nikolaygarmaev91@gmail.com");


        return RestAssured.given()
                .queryParams(map)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .post(path)// send request to end point
                .then()
                .statusCode(SC_OK) // Verify status code = 200 or OK
                .extract() // Method that extracts response JSON data
                .body() // Body Extracted as JSON format
                .jsonPath() // Navigate using jsonPath
                .get("token"); // get value for key Token
    }
    @Test
    public void verifyToken() {

        Response response = RestAssured.given()
                .header("Authorization", setupLogInAndToken())
                .when()
                .get(memberOf)
                .then()
                .log().all()
                .extract().response();

        // verify status code
        Assert.assertEquals(SC_OK, response.statusCode());
        Assert.assertEquals("Default", response.jsonPath().getString("name[0]"));
    }
    @Test
    public void verifyId() {
        Response response = RestAssured.given()
                .header("Authorization", setupLogInAndToken())
                .when()
                .get(memberOf)
                .then()
                .log().all()
                .extract().response();
        Assert.assertEquals("OZOixX0BtLxR4Bgecgc0", response.jsonPath().getString("id[0]"));
    }
    @Test
    public void verifyUserId() {
        Response response = RestAssured.given()
                .header("Authorization", setupLogInAndToken())
                .when()
                .get(memberOf)
                .then()
                .log().all()
                .extract().response();
        Assert.assertEquals("ppkPvH0B9ik-roTygi4F", response.jsonPath().getString("userId[0]"));
    }
    @Test
    public void verifyDescription() {
        Response response = RestAssured.given()
                .header("Authorization", setupLogInAndToken())
                .when()
                .get(memberOf)
                .then()
                .log().all()
                .extract().response();
        Assert.assertEquals("", response.jsonPath().getString("description[0]"));
    }
}