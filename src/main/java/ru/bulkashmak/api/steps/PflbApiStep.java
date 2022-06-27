package ru.bulkashmak.api.steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.bulkashmak.api.models.user.UserRequest;
import ru.bulkashmak.api.models.user.UserResponse;
import ru.bulkashmak.api.requests.PflbApiRequest;

import java.math.BigDecimal;
import java.util.List;

public class PflbApiStep {

    private static final Logger LOGGER = LoggerFactory.getLogger(PflbApiStep.class);

    public List<UserResponse> getUsers() {
        PflbApiRequest request = new PflbApiRequest();

        return request.getUsers();
    }

    public UserResponse getUserById(Integer userId) {
        PflbApiRequest request = new PflbApiRequest();

        return request.getUserById(userId);
    }

    public UserResponse postAddUser(UserRequest userRequest) {
        PflbApiRequest request = new PflbApiRequest();

        return request.postAddUser(userRequest);
    }

    public UserResponse postUserByIdMoney(Integer userId, BigDecimal userMoney) {
        PflbApiRequest request = new PflbApiRequest();

        return request.postUserByIdMoney(userId, userMoney);
    }
}
