package ru.bulkashmak.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.bulkashmak.BaseTestUI;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

@DisplayName("UI тесты Trello")
public class TrelloTest extends BaseTestUI {

    @Test
    public void loginTest() {

        loginPage.loginToOK();

    }
}
