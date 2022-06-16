package ru.bulkashmak.api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.bulkashmak.api.config.BaseTest;
import ru.bulkashmak.api.models.user.User;

import java.util.List;

import static org.apache.http.HttpStatus.SC_OK;
import static ru.bulkashmak.api.config.RestSpec.*;

public class PflbApiTest extends BaseTest {

    @Test
    @DisplayName("Получение всех пользователей")
    public void getAllUsersTest() {
        installSpecs(requestSpec(), responseSpecOK200());

        List<User> users = RestAssured
                .given()

                .when()
                .get("/users")

                .then()
                .statusCode(SC_OK)
                .log().headers()
                .extract().body().jsonPath().getList(".", User.class);
    }
}
