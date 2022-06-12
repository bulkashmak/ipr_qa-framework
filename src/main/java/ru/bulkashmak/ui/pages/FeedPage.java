package ru.bulkashmak.ui.pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.bulkashmak.ui.pages.interfaces.LeftNavBar;

import static com.codeborne.selenide.Selenide.*;

public class FeedPage extends BasePage implements LeftNavBar {

    private static final Logger LOGGER = LoggerFactory.getLogger(FeedPage.class);

    private static final String NEW_POST_FIELD_X = "//*[@class='pf-head_itx_a']";

    public NewPostPage createNewPost() {
        LOGGER.info("Создание нового события");

        $x(NEW_POST_FIELD_X).click();

        return new NewPostPage();
    }
}
