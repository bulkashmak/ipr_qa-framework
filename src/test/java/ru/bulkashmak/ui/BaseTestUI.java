package ru.bulkashmak.ui;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import ru.bulkashmak.ui.pages.LoginPage;

public class BaseTestUI {

    protected static LoginPage loginPage = new LoginPage();
    private static final User user = new User();

    @BeforeEach
    public void setUp() {
        loginPage.openOK();
        WebDriverRunner.getWebDriver().manage().window().maximize();
        loginPage.setLanguage(user.getLanguage());
    }

    @AfterEach
    public void tearDown() {
        WebDriverRunner.closeWebDriver();
    }
}
