package ru.bulkashmak.ui.pages;

import com.codeborne.selenide.Condition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.bulkashmak.ui.pages.navBars.LeftNavBar;

import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FeedPage extends BasePage {

    private static final Logger LOGGER = LoggerFactory.getLogger(FeedPage.class);

    public static final String NEW_POST_FIELD_X = "//*[@class='pf-head_itx_a']";
    public static final String FEED_LIST_X = "//*[@class='feed-list __compact']";
    public static final String FEED_LIST_ELEMENT_X = FEED_LIST_X + "//*[@class='feed-w']";
    LeftNavBar leftNavBar = new LeftNavBar();

    public NewPostPage createNewPost() {
        LOGGER.info("Создание нового события");

        $x(NEW_POST_FIELD_X).click();

        assertTrue(
                $x("//*[@id='hook_Block_MediaTopicLayerBody']").shouldBe(Condition.visible).isDisplayed(),
                "Не был произведен переход на страницу создания нового события");

        return new NewPostPage();
    }

    public ProfilePage goToProfilePage() {
        leftNavBar.goToProfilePage();

        return new ProfilePage();
    }
}
