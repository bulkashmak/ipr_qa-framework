package ru.bulkashmak.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class LoginPage extends BasePage {

    static SelenideElement emailField = $x("//*[@id='user']");
    static SelenideElement passwordField = $x("//*[@id='password']");

    public LoginPage inputUsernameAndPassword() {
        emailField.sendKeys();
        return this;
    }
}
