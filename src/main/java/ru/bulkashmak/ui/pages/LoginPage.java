package ru.bulkashmak.ui.pages;

import com.codeborne.selenide.Condition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.bulkashmak.ui.User;

import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.*;

public class LoginPage extends BasePage {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginPage.class);

    private static final String FIELD_EMAIL_X = "//*[@id='field_email']";
    private static final String FIELD_PASSWORD_X = "//*[@id='field_password']";
    private static final String BUTTON_LOGIN_X = "//*[@value='Войти в Одноклассники']";

    User user = new User();

    public FeedPage loginToOK() {
        LOGGER.info("Авторизация на сайте");

        $x(FIELD_EMAIL_X).sendKeys(user.getEmail());
        $x(FIELD_PASSWORD_X).sendKeys(user.getPassword());
        $x(BUTTON_LOGIN_X).click();

        assertTrue($x("//*[@class='layout-main']").shouldBe(Condition.visible).isDisplayed(),
                "Не был произведен переход на главную страницу");

        return new FeedPage();
    }
}
