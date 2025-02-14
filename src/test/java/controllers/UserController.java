package controllers;

import config.TestPropertiesConfig;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.specification.RequestSpecification;
import org.aeonbits.owner.ConfigFactory;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;


public class UserController {
RequestSpecification requestSpecification;
private static final String BASE_URL = "https://petstore.swagger.io/v2/";
private static final String USER_ENDPOINT = "user";
TestPropertiesConfig configProperties = ConfigFactory.create(TestPropertiesConfig.class, System.getProperties());

    public UserController() {
        this.requestSpecification = given()
                .accept(JSON)
                .contentType(JSON)
                .baseUri(BASE_URL)
               // .baseUri(configProperties.getApiBaseUrl());
                .filter(new AllureRestAssured());

    }
}
