package ru.bulkashmak.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.bulkashmak.api.config.BaseTest;
import ru.bulkashmak.api.models.user.UserRequest;
import ru.bulkashmak.api.models.user.UserResponse;
import ru.bulkashmak.api.steps.PflbApiStep;
import ru.bulkashmak.api.testdata.TestDataGenerator;

import java.math.BigDecimal;

public class PflbApiTest extends BaseTest {

    private final PflbApiStep step = new PflbApiStep();
    TestDataGenerator testDataGenerator = new TestDataGenerator();

    @Test
    @DisplayName("Получение всех пользователей")
    public void getAllUsersTest() {
        step.getAllUsers();
    }

    @Test
    @DisplayName("Создание пользователя")
    public void postAddUserTest() {
        UserRequest userRequest = testDataGenerator.generateUser();
        step.addUser(userRequest);
    }

    @Test
    @DisplayName("Изменение суммы у пользователя")
    public void postUserMoneyTest() {
        BigDecimal money = TestDataGenerator.generateRandomMoney();
        UserResponse user = step.getRandomUser();
        step.addMoneyToUserById(user.getId(), money);
    }
}
