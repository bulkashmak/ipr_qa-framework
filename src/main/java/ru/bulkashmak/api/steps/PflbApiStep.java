package ru.bulkashmak.api.steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.bulkashmak.api.models.user.UserRequest;
import ru.bulkashmak.api.models.user.UserResponse;
import ru.bulkashmak.api.rests.PflbApiRests;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PflbApiStep {

    private static final Logger LOGGER = LoggerFactory.getLogger(PflbApiStep.class);
    private final PflbApiRests api = new PflbApiRests();

    public List<UserResponse> getAllUsers() {
        List<UserResponse> usersResponse = api.getUsersOK();

        usersResponse.forEach(x -> assertNotNull(x.getId(),
                String.format("ID пользователя '%s' равен null", x.getFirstName())));

        return usersResponse;
    }

    public UserResponse getUserById(Integer userId) {
        UserResponse userResponse = api.getUserByIdOK(userId);
        assertEquals(userId, userResponse.getId(),
                "id не соответствует ожидаемому");

        return userResponse;
    }

    public UserResponse addUser(UserRequest userRequest) {
        UserResponse userResponse = api.postAddUserOK(userRequest);

        assertEquals(userResponse, getUserById(userResponse.getId()),
                "пользователь создан некорректно");

        return userResponse;
    }

    public UserResponse addMoneyToUserById(Integer userId, BigDecimal money) {
        UserResponse userBefore = getUserById(userId);
        UserResponse userAfter = api.postUserByIdMoneyOK(userId, money);
        BigDecimal expectedMoney = userBefore.getMoney().add(money);

        assertEquals(0, expectedMoney.compareTo(userAfter.getMoney()),
                "Сумма денег пользователя изменена некорректно");

        return userAfter;
    }

    public UserResponse getRandomUser() {
        List<UserResponse> userResponses = getAllUsers();
        return userResponses.get(new Random().nextInt(userResponses.size()));
    }
}
