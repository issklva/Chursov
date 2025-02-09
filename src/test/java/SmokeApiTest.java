import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class SmokeApiTest {
    @Test
    public void simpleTest() {
        String body = """
                {
                  "id": 0,
                  "username": "string",
                  "firstName": "string",
                  "lastName": "string",
                  "email": "string",
                  "password": "string",
                  "phone": "string",
                  "userStatus": 0
                }""";
        ValidatableResponse response = given()
                .relaxedHTTPSValidation()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .baseUri("https://petstore.swagger.io/v2/")
                .when()
                .body(body)
                .post("user")
                .then()
                .log()
                .all()
                .statusCode(200)
                .body("code", equalTo(200))
                .body("type", equalTo("unknown"))
                .body("message", notNullValue(String.class));
        // .andReturn();

        //Assertions.assertEquals(200, response.getStatusCode());
    }


            @Test
            public void simpleTest2() {
                String body = """
                        {
                          "id": 0,
                          "username": "string",
                          "firstName": "string",
                          "lastName": "string",
                          "email": "string",
                          "password": "string",
                          "phone": "string",
                          "userStatus": 0
                        }""";
           Response response = given()
                        .relaxedHTTPSValidation()
                        .header("accept", "application/json")
                        .header("Content-Type", "application/json")
                        .baseUri("https://petstore.swagger.io/v2/")
                        .when()
                        .body(body)
                        .post("user")
                .andReturn();
           Assertions.assertEquals(200, response.getStatusCode());

            }
        }

