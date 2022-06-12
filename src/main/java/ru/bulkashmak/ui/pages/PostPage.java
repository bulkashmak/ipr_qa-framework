package ru.bulkashmak.ui.pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.*;

public class PostPage extends BasePage {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostPage.class);

    private static final String SHORTCUT_MENU_ARROW_X = "//*[@class='new_topic_icodown']";
    private static final String SHORTCUT_MENU_X = "//*[@id='hook_Block_ShortcutMenu']";

    public PostPage deletePost() {
        LOGGER.info("Удалить событие");

        $x(SHORTCUT_MENU_ARROW_X).hover();
        $x(SHORTCUT_MENU_X + "//*[text()='Удалить']").click();

        return this;
    }

    public PostPage inputComment(String comment) {
        LOGGER.info(String.format("Ввести комментарий '%s'", comment));

        $x("//*[@class='comments_add']//form" +
                "//*[@class='itx js-comments_add js-ok-e comments_add-ceditable ']").sendKeys(comment);
        return this;
    }

    public PostPage addComment() {
        LOGGER.info("Кликнуть кнопку 'Добавить' комментарий");

        $x("//*[@class='comments_add-controls']//*[@class='button-pro form-actions_yes']").click();

        return this;
    }

    public ProfilePage closePost() {
        LOGGER.info("Закрыть событие");

        $x("//*[@class='ic media-layer_close_ico']").click();

        return new ProfilePage();
    }

}
