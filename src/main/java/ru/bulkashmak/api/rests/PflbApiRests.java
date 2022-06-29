package ru.bulkashmak.api.rests;

import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.bulkashmak.api.models.user.UserRequest;
import ru.bulkashmak.api.models.user.UserResponse;
import ru.bulkashmak.api.rests.config.BaseRequest;

import java.math.BigDecimal;
import java.util.List;

import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;

public class PflbApiRests {

    private static final Logger LOGGER = LoggerFactory.getLogger(PflbApiRests.class);

    public Response getUsers() {
        LOGGER.info("Отправка запроса GET /users");

        return BaseRequest.getRequest()
                .get("/users");
    }

    public List<UserResponse> getUsersOK() {

        return getUsers().then()
                .statusCode(SC_OK)
                .extract().as(new TypeRef<>() {});
    }

    public Response getUserById(Integer userId) {
        LOGGER.info("Отправка запроса GET /user/{}", userId);

        return BaseRequest.getRequest()
                .get(String.format("/user/%s", userId));
    }

    public UserResponse getUserByIdOK(Integer userId) {

        return getUserById(userId).then()
                .statusCode(SC_OK)
                .extract().as(UserResponse.class);
    }

    public Response postAddUser(UserRequest userRequest) {
        LOGGER.info("Отправка запроса POST /addUser user.firstname={}", userRequest.getFirstName());

        return BaseRequest.postRequest()
                .body(userRequest)
                .post("/addUser");
    }

    public UserResponse postAddUserOK(UserRequest userRequest) {

        return postAddUser(userRequest).then()
                .statusCode(SC_CREATED)
                .extract().as(UserResponse.class);
    }

    public Response postUserByIdMoney(Integer userId, BigDecimal userMoney) {
        LOGGER.info("Отправка запроса POST /user/{}/money/{}", userId, userMoney);

        return BaseRequest.postRequest()
                .pathParam("userId", userId)
                .pathParam("userMoney", userMoney)
                .post("/user/{userId}/money/{userMoney}");
    }

    public UserResponse postUserByIdMoneyOK(Integer userId, BigDecimal userMoney) {

        return postUserByIdMoney(userId, userMoney).then()
                .statusCode(SC_OK)
                .extract().as(UserResponse.class);
    }
}
