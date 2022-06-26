package ru.bulkashmak.api.testdata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.bulkashmak.api.models.user.UserRequest;
import ru.bulkashmak.api.models.user.UserResponse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

public class TestDataGenerator {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestDataGenerator.class);

    private static final Random RANDOM = new Random();

    public UserRequest generateUser() {
        return new UserRequest(
                generateRandomFirstName(),
                generateRandomLastName(),
                generateRandomAge(),
                generateRandomSex(),
                generateRandomMoney()
        );
    }

    public static String generateRandomFirstName() {
        return getRandomStringFromList(readFileTXT(
                new File("src/main/resources/testdata/user/firstNames/maleFirstNames.txt")));
    }

    public static String generateRandomLastName() {
        return getRandomStringFromList(readFileTXT(
                new File("src/main/resources/testdata/user/lastNames/lastNames.txt")));
    }

    public static List<String> readFileTXT(File file) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            while (line != null) {
                lines.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            LOGGER.error(String.format("Ошибка при чтении файла '%s'", file), e);
            throw new RuntimeException();
        }
        return lines;
    }

    public static String getRandomStringFromList(List<String> lines) {
        int index = RANDOM.nextInt(lines.size());
        return lines.get(index);
    }

    public static Integer generateRandomAge() {
        return RANDOM.nextInt(47) + 18;
    }

    private static UserResponse.Sex generateRandomSex() {
        UserResponse.Sex[] sexArr = UserResponse.Sex.values();

        return sexArr[RANDOM.nextInt(sexArr.length)];
    }

    public static BigDecimal generateRandomMoney() {
        return BigDecimal.valueOf(Math.ceil(Math.random() * ((100000 - 1000) + 1) + 1000));
    }
}
