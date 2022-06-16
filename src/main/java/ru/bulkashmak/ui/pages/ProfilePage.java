package ru.bulkashmak.ui.pages;

import static com.codeborne.selenide.Condition.*;

import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;

public class ProfilePage extends BasePage {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProfilePage.class);

    private static final String POSTS_LIST_X = "//*[@class='feed-list __compact']";
    private static final String POST_MODAL_X = "//*[@id='hook_Block_MediaTopicLayerBody']";

    public PostPage openPost(String postContent) {
        LOGGER.info(String.format("Открыть пост ''%s''", postContent));

        $x(POSTS_LIST_X + String.format("//*[text()='%s']/../../..", postContent))
                .shouldBe(and("Clickable", visible, enabled)).scrollIntoView(true).click();

        return new PostPage();
    }

    public PostPage openPost() {
        LOGGER.info("Открыть последнее событие");

        List<SelenideElement> posts = $$x(POSTS_LIST_X + "/*[@class='feed-w']");
        for (SelenideElement post :
                posts) {
            if (post.$x(".//*[@class='widget_count js-count']").exists()) {
                post.$x(".//*[@class='media-text_cnt']//a")
//                        .shouldBe(and("Clickable", visible, enabled), Duration.ofSeconds(5))
                        .shouldBe(visible)
//                        .scrollIntoView(true)
                        .click();
                break;
            }
        }

        assertTrue($x(POST_MODAL_X).shouldBe(visible).isDisplayed(),
                "Событие не открылось");

        return new PostPage();
    }
}
