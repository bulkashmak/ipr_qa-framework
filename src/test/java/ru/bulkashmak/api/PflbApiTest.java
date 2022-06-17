package ru.bulkashmak.api;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.bulkashmak.api.config.BaseTest;
import ru.bulkashmak.api.models.user.UserResponse;
import ru.bulkashmak.api.steps.PflbApiStep;

import java.util.List;

public class PflbApiTest extends BaseTest {

    @Test
    @DisplayName("Получение всех пользователей")
    public void getAllUsersTest() {
        PflbApiStep step = new PflbApiStep();

        List<UserResponse> users = step.getUsers();

        users.forEach(x -> assertNotNull(x.getId(), String.format("user '%s' id is null", x.getFirstName())));
    }
}
