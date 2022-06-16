package ru.bulkashmak.api.steps;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import ru.bulkashmak.api.ApiProperties;

public class BaseStep {

    public void setBaseURI() {
        RestAssured.baseURI = ApiProperties.getProperty("uri");
    }

    public void setBasePath() {
        RestAssured.basePath = "";
    }

    public void setContentType(ContentType type) {
        RestAssured.given().contentType(type);
    }
}