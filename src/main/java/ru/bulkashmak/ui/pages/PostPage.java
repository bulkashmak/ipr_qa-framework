package ru.bulkashmak.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;

public class PostPage extends BasePage {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostPage.class);

    private static final String SHORTCUT_MENU_ARROW_X = "//*[@class='new_topic_icodown']";
    private static final String SHORTCUT_MENU_X = "//*[@id='hook_Block_ShortcutMenu']";
    private static final String COMMENT_LIST_X = "//*[@class='comments_lst_cnt']";
    private static final String POST_MODAL_X = "//*[@id='hook_Block_MediaTopicLayerBody']";
    private static final String POST_MODAL_COMMENT_FIELD_X = "//*[@class='comments_add']//form" +
            "//*[@class='itx js-comments_add js-ok-e comments_add-ceditable ']";

    public PostPage deletePost() {
        LOGGER.info("Удалить событие");

        $x(SHORTCUT_MENU_ARROW_X).hover();
        $x(SHORTCUT_MENU_X + "//*[text()='Удалить']").click();

        assertTrue($x(POST_MODAL_X + "//*[text()='Заметка удалена']")
                        .shouldBe(Condition.visible).isDisplayed(),
                "Сообщение об удалении события не отображается");

        return this;
    }

    public PostPage inputComment(String comment) {
        LOGGER.info(String.format("Ввести комментарий '%s'", comment));

        $x(POST_MODAL_COMMENT_FIELD_X).sendKeys(comment);

        assertEquals(comment, $x(POST_MODAL_COMMENT_FIELD_X).getText(),
                "Комментарий вводится некорректно");

        return this;
    }

    public PostPage addComment() {
        LOGGER.info("Кликнуть кнопку 'Добавить' комментарий");

        $x("//*[@class='comments_add-controls']//*[@class='button-pro form-actions_yes']").click();

        return this;
    }
    public PostPage addComment(String comment) {
        LOGGER.info("Кликнуть кнопку 'Добавить' комментарий");

        inputComment(comment);

        $x("//*[@class='comments_add-controls']//*[@class='button-pro form-actions_yes']").click();

        assertTrue($x(COMMENT_LIST_X +
                String.format("//*[@class='comments_body']//*[text()='%s']", comment))
                        .shouldBe(Condition.visible).isDisplayed(),
                "Опубликованный комментарий не отображается");

        return this;
    }

    public PostPage deleteComment() {
        LOGGER.info("Удалить комментарий");

        List<SelenideElement> comments = $$x(COMMENT_LIST_X + "//*[@class='comments_body']");
        comments.get(0).$x(".//*[@title='Удалить']").hover().click();

        assertTrue($x(POST_MODAL_X + "//*[@class='delete-stub_i']")
                        .shouldBe(Condition.visible).isDisplayed(),
                "Сообщение об удалении не отображается");

        return this;
    }

    public ProfilePage closePost() {
        LOGGER.info("Закрыть событие");

        $x("//*[@class='ic media-layer_close_ico']").click();

        return new ProfilePage();
    }

}
