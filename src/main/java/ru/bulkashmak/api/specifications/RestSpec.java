package ru.bulkashmak.api.specifications;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import ru.bulkashmak.api.steps.BaseStep;

import static org.apache.http.HttpStatus.*;

public class RestSpec {

    public static RequestSpecification requestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(BaseStep.getBaseURI())
                .setContentType(ContentType.JSON)
                .build();
    }

    public static ResponseSpecification responseSpecOK200() {
        return new ResponseSpecBuilder()
                .expectStatusCode(SC_OK)
                .build();
    }

    public static ResponseSpecification responseSpecCreated201() {
        return new ResponseSpecBuilder()
                .expectStatusCode(SC_CREATED)
                .build();
    }

    public static void installSpecs(RequestSpecification requestSpec, ResponseSpecification responseSpec) {
        RestAssured.requestSpecification = requestSpec;
        RestAssured.responseSpecification = responseSpec;
    }
}
