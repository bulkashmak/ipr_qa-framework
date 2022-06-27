package ru.bulkashmak.api.requests;

import io.restassured.common.mapper.TypeRef;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.bulkashmak.api.models.user.UserRequest;
import ru.bulkashmak.api.models.user.UserResponse;
import ru.bulkashmak.api.requests.config.BaseRequest;

import java.math.BigDecimal;
import java.util.List;

public class PflbApiRequest {

    private static final Logger LOGGER = LoggerFactory.getLogger(PflbApiRequest.class);

    public List<UserResponse> getUsers() {
        LOGGER.info("Отправка запроса GET /users");

        return BaseRequest.getRequest()
                .when()
                .get("/users")

                .then()
                .extract().body().as(new TypeRef<>() {});
    }

    public UserResponse getUserById(Integer userId) {
        LOGGER.info("Отправка запроса GET /user/{}", userId);

        return BaseRequest.getRequest()
                .when()
                .get(String.format("/user/%s", userId))

                .then()
                .extract().as(UserResponse.class);
    }

    public UserResponse postAddUser(UserRequest userRequest) {
        LOGGER.info("Отправка запроса POST /addUser user.firstname={}", userRequest.getFirstName());

        return BaseRequest.postRequest()
                .body(userRequest)
                .when()
                .post("/addUser")

                .then()
                .extract().as(UserResponse.class);
    }

    public UserResponse pustUserByIdMoney(Integer userId, BigDecimal userMoney) {
        LOGGER.info("Отправка запроса POST /user/{}/money/{}", userId, userMoney);

        return BaseRequest.postRequest()
                .when()
                .post(String.format("/user/%s/money/%s", userId, userMoney))

                .then()
                .extract().as(UserResponse.class);
    }
}
