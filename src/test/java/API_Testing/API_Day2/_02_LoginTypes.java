package API_Testing.API_Day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class _02_LoginTypes {

    /*
    Log in with Full URL with query params
    and verify status code and Content-type is equal to JSON
     */
    @Test
    public void testUsingQueryParams() {
        RestAssured.given()
                .when()
                .post("https://api.octoperf.com/public/users/login?password=aldar1018&username=nikolaygarmaev91@gmail.com")
                .then()
                .assertThat().statusCode(200)
                .and()
                .assertThat().contentType(ContentType.JSON);
    }
    /*
    Log in using Map to verify Content type
    Map => Stores Key and Value -> Hashmap implements Map, We can store different data type of Object
     */
    @Test
    public void logInUsingMap() {
        RestAssured.baseURI = "https://api.octoperf.com";
        String path = "/public/users/login";
        // WRITE A MAP
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("username", "nikolaygarmaev91@gmail.com");
        data.put("password", "aldar1018");

        RestAssured.given()
                .queryParams(data)
                .when()
                .post(path)
                .then()
                .assertThat()
                .contentType(ContentType.JSON)
                .and()
                .assertThat()
                .statusCode(200);
    }

    // Using query Param
    @Test
    public void logInUsingQueryParam() {
        RestAssured.baseURI = "https://api.octoperf.com";
        String path = "/public/users/login";

        RestAssured.given()
                .queryParam("username", "nikolaygarmaev91@gmail.com")
                .queryParam("password", "aldar1018")
                .when()
                .post(path)
                .then()
                .assertThat()
                .contentType(ContentType.JSON)
                .and()
                .assertThat()
                .statusCode(200);
    }
}