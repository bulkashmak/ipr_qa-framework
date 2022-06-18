package ru.bulkashmak.api.testdata;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.bulkashmak.api.models.user.UserRequest;
import ru.bulkashmak.api.models.user.UserResponse;

import java.io.*;
import java.util.*;

public class TestDataGenerator {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestDataGenerator.class);

    private static final Random RANDOM = new Random();

    public UserRequest generateUser() {
        return new UserRequest(
                generateRandomMaleFirstName(),
                generateRandomLastName(),
                generateRandomAge(),
                generateRandomSex(),
                generateRandomMoney()
        );
    }

    private static String generateRandomFemaleFirstName() {
        return getRandomStringFromList(readFileTXT(
                new File("src/main/resources/testdata/user/firstNames/femaleFirstNames.txt")));
    }

    private static String generateRandomMaleFirstName() {
        return getRandomStringFromList(readFileTXT(
                new File("src/main/resources/testdata/user/firstNames/maleFirstNames.txt")));
    }

    private static String generateRandomLastName() {
        return getRandomStringFromList(readFileTXT(
                new File("src/main/resources/testdata/user/lastNames/lastNames.txt")));
    }

    private static List<String> readFileTXT(File file) {
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

    private static String getRandomStringFromList(List<String> lines) {
        int index = RANDOM.nextInt(lines.size());
        return lines.get(index);
    }

    private static Integer generateRandomAge() {
        return RANDOM.nextInt(47) + 18;
    }

    private static UserResponse.Sex generateRandomSex() {
        List<UserResponse.Sex> userSex = Collections.unmodifiableList(Arrays.asList(UserResponse.Sex.values()));
        return userSex.get(RANDOM.nextInt(userSex.size()));
    }

    private static Double generateRandomMoney() {
        return Math.ceil(Math.random() * ((100000 - 1000) + 1) + 1000);
    }
}
