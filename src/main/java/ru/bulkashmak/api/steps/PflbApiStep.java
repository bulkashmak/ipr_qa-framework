package ru.bulkashmak.api.steps;

import io.restassured.RestAssured;
import ru.bulkashmak.api.models.user.UserResponse;

import java.util.List;

import static ru.bulkashmak.api.specifications.RestSpec.*;

public class PflbApiStep extends BaseStep {

    public List<UserResponse> getUsers() {
        installSpecs(requestSpec(), responseSpecOK200());

        return RestAssured.given()
                .when()
                .get("/users")

                .then()
                .extract().body().jsonPath().getList(".", UserResponse.class);
    }
}
