package ru.bulkashmak.api;

import io.restassured.RestAssured;
import static org.apache.http.HttpStatus.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PflbApiTest extends BaseTest {

    @Test
    @DisplayName("Получение всех пользователей")
    public void getAllUsersTest() {

        RestAssured
                .when()
                    .get("/users")
                .then()
                    .statusCode(SC_OK);
    }
}
