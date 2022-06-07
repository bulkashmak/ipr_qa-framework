package ru.bulkashmak.ui.pages;

import static com.codeborne.selenide.Condition.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.*;

public class ProfilePage extends BasePage {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProfilePage.class);

    private static final String POSTS_LIST_X = "//*[@class='feed-list __compact']";

    public PostPage openPost(String postContent) {
        LOGGER.info(String.format("Открыть пост ''%s''", postContent));

        $x(POSTS_LIST_X + String.format("//*[text()='%s']/../../..", postContent))
                .shouldBe(and("Clickable", visible, enabled)).scrollIntoView(true).click();

        return new PostPage();
    }
}
