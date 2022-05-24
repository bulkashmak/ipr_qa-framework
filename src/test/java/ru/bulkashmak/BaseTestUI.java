package ru.bulkashmak;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class BaseTestUI {

    @BeforeAll
    public static void setUp() {
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @AfterAll
    public static void tearDown() {
        WebDriverRunner.closeWebDriver();
    }
}
