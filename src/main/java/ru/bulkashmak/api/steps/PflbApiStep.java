package ru.bulkashmak.api.steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.bulkashmak.api.models.user.UserRequest;
import ru.bulkashmak.api.models.user.UserResponse;
import ru.bulkashmak.api.requests.PflbApiRequest;
import ru.bulkashmak.api.testdata.TestDataGenerator;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PflbApiStep {

    private static final Logger LOGGER = LoggerFactory.getLogger(PflbApiStep.class);
    private static final TestDataGenerator testDataGenerator = new TestDataGenerator();

    public List<UserResponse> getUsersStep() {
        PflbApiRequest request = new PflbApiRequest();
        List<UserResponse> usersResponse = request.getUsers();

        usersResponse.forEach(x -> assertNotNull(x.getId(),
                String.format("ID пользователя '%s' равен null", x.getFirstName())));

        return usersResponse;
    }

    public UserResponse postAddUserStep() {
        PflbApiRequest request = new PflbApiRequest();
        UserRequest userRequest = testDataGenerator.generateUser();
        UserResponse userResponse = request.postAddUser(userRequest);

        assertEquals(userResponse, request.getUserById(userResponse.getId()),
                "пользователь создан некорректно");

        return userResponse;
    }

    public UserResponse postUserByIdMoneyStep() {
        PflbApiRequest request = new PflbApiRequest();
        List<UserResponse> usersResponse = request.getUsers();
        UserResponse randomUser = usersResponse.get(new Random().nextInt(usersResponse.size()));
        BigDecimal money = TestDataGenerator.generateRandomMoney();
        UserResponse response = request.postUserByIdMoney(randomUser.getId(), money);

        BigDecimal expectedResult = randomUser.getMoney().add(money);

        assertEquals(0, expectedResult.compareTo(response.getMoney()),
                "Сумма денег пользователя изменена некорректно");

        return response;
    }
}
