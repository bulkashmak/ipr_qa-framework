package ru.bulkashmak.api;

import static org.apache.http.HttpStatus.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.bulkashmak.api.models.user.User;
import ru.bulkashmak.api.config.BaseTest;

import java.util.List;

public class PflbApiTest extends BaseTest {

    @Test
    @DisplayName("Получение всех пользователей")
    public void getAllUsersTest() {

        List<User> users = RestAssured
                .given()

                .when()
                .contentType(ContentType.JSON)
                .get("http://77.50.236.203:4880/users")

                .then()
                .statusCode(SC_OK)
                .log().all()
                .extract().body().jsonPath().getList(".", User.class);
    }
}
