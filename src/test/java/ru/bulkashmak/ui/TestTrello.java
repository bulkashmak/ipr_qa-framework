package ru.bulkashmak.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

@DisplayName("UI тесты Trello")
public class TestTrello {

    @Test
    public void loginTest() {
        open("https://trello.com/");

    }
}
