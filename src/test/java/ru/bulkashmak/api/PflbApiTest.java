package ru.bulkashmak.api;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.bulkashmak.api.config.BaseTest;
import ru.bulkashmak.api.models.user.UserRequest;
import ru.bulkashmak.api.models.user.UserResponse;
import ru.bulkashmak.api.steps.PflbApiStep;
import ru.bulkashmak.api.testdata.TestDataGenerator;

import java.util.List;
import java.util.Random;

public class PflbApiTest extends BaseTest {

    private static final TestDataGenerator testDataGenerator = new TestDataGenerator();

    @Test
    @DisplayName("Получение всех пользователей")
    public void getAllUsersTest() {
        PflbApiStep step = new PflbApiStep();
        List<UserResponse> usersRs = step.getUsers();

        usersRs.forEach(x -> assertNotNull(x.getId(),
                String.format("user's '%s' id is null", x.getFirstName())));
    }

    @Test
    @DisplayName("Создание пользователя")
    public void postAddUserTest() {
        PflbApiStep step = new PflbApiStep();
        UserRequest userRq = testDataGenerator.generateUser();
        UserResponse userRs = step.postAddUser(userRq);

        assertEquals(userRs, step.getUserById(userRs.getId()),
                "пользователь создан некорректно");
    }

    @Test
    @DisplayName("Изменение суммы у пользователя")
    public void postUserMoneyTest() {
        PflbApiStep step = new PflbApiStep();
        List<UserResponse> usersRs = step.getUsers();
        UserResponse randomUser = usersRs.get(new Random().nextInt(usersRs.size()));
        Double money = TestDataGenerator.generateRandomMoney();
        UserResponse response = step.postUserByIdMoney(randomUser.getId(), money);

        assertEquals(randomUser.getMoney() + money, response.getMoney(),
                "Сумма денег пользователя изменена некорректно");
    }
}
