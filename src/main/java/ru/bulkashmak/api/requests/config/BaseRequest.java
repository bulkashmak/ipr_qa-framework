package ru.bulkashmak.api.requests.config;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import ru.bulkashmak.api.ApiProperties;

public class BaseRequest {

    private static RequestSpecification createBaseRequest() {

        return RestAssured.given()
                .log().all()
                .baseUri(ApiProperties.getProperty("uri"));
    }

    public static RequestSpecification getRequest() {

        return createBaseRequest();
    }

    public static RequestSpecification postRequest() {

        return createBaseRequest()
                .contentType(ContentType.JSON);
    }
}
