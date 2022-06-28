package ru.bulkashmak.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.bulkashmak.api.config.BaseTest;
import ru.bulkashmak.api.steps.PflbApiStep;
import ru.bulkashmak.api.testdata.TestDataGenerator;

public class PflbApiTest extends BaseTest {

    private static final TestDataGenerator testDataGenerator = new TestDataGenerator();

    @Test
    @DisplayName("Получение всех пользователей")
    public void getAllUsersTest() {
        PflbApiStep step = new PflbApiStep();
        step.getUsersStep();
    }

    @Test
    @DisplayName("Создание пользователя")
    public void postAddUserTest() {
        PflbApiStep step = new PflbApiStep();
        step.postAddUserStep();
    }

    @Test
    @DisplayName("Изменение суммы у пользователя")
    public void postUserMoneyTest() {
        PflbApiStep step = new PflbApiStep();
        step.postUserByIdMoneyStep();
    }
}
