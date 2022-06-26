package ru.bulkashmak.api.steps;

import io.restassured.RestAssured;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.bulkashmak.api.models.user.UserRequest;
import ru.bulkashmak.api.models.user.UserResponse;

import java.math.BigDecimal;
import java.util.List;

import static ru.bulkashmak.api.specifications.ApiSpec.*;

public class PflbApiStep {

    private static final Logger LOGGER = LoggerFactory.getLogger(PflbApiStep.class);

    public List<UserResponse> getUsers() {
        LOGGER.info("Отправка запроса GET /users");
        installSpecs(requestSpec(), responseSpecOK200());

        return RestAssured.given()
                .when()
                .get("/users")

                .then()
                .log().all()
                .extract().body().jsonPath().getList(".", UserResponse.class);
    }

    public UserResponse getUserById(Integer id) {
        LOGGER.info("Отправка запроса GET /user/{}", id);
        installSpecs(requestSpec(), responseSpecOK200());

        return RestAssured.given()
                .when()
                .get(String.format("/user/%s", id))

                .then()
                .log().all()
                .extract().as(UserResponse.class);
    }

    public UserResponse postAddUser(UserRequest userRq) {
        LOGGER.info("Отправка запроса POST /addUser user.firstname={}", userRq.getFirstName());
        installSpecs(requestSpec(), responseSpecCreated201());

        return RestAssured.given()
                .body(userRq)
                .when()
                .post("/addUser")

                .then()
                .log().all()
                .extract().as(UserResponse.class);
    }

    public UserResponse postUserByIdMoney(Integer userId, BigDecimal money) {
        LOGGER.info("Отправка запроса POST /user/{}/money/{}", userId, money);
        installSpecs(requestSpec(), responseSpecOK200());

        return RestAssured.given()
                .when()
                .post(String.format("/user/%s/money/%s", userId, money))

                .then()
                .log().all()
                .extract().as(UserResponse.class);
    }
}
