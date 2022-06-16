package ru.bulkashmak.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NewPostPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(NewPostPage.class);

    public static final String NEW_POST_MODAL_X = "//*[@id='hook_Block_MediaTopicLayerBody']";
    public static final String ADD_PHOTO_MODAL_X = "//*[contains(@class, 'modal-out-scroll-body')]";
    public static final String POST_TEXT_X = NEW_POST_MODAL_X + "//*[@data-module='postingForm/mediaText']";
    public static final String POST_PHOTO_X = NEW_POST_MODAL_X + "//*[@title='Добавить фото']";

    public NewPostPage inputPostText(String postText) {
        LOGGER.info(String.format("Ввод содержания события ''%s''", postText));

        $x(POST_TEXT_X).sendKeys(Keys.CONTROL + "A");
        $x(POST_TEXT_X).sendKeys(Keys.DELETE);
        $x(POST_TEXT_X).sendKeys(postText);

        assertTrue($x(NEW_POST_MODAL_X + String.format("//div[text()='%s']", postText))
                .shouldBe(Condition.visible).isDisplayed(),
                "Содержимое события не было введено");

        return this;
    }

    public NewPostPage addPostPhotoFromAlbum(String album) {
        LOGGER.info(String.format("Добавление фото из альбома '%s' в событие", album));

        $x(POST_PHOTO_X).click();
        $x(ADD_PHOTO_MODAL_X + String.format("//*[text()='%s']", album)).click();
        $$x(ADD_PHOTO_MODAL_X + "//*[contains(@class, 'photo-img-wrapper')]")
                .get(1).click();
        $x(ADD_PHOTO_MODAL_X + "//*[contains(@class, 'attach-button')]").click();

        assertTrue($x(NEW_POST_MODAL_X + "//*[@class='posting_photo_img js-img']")
                .shouldBe(Condition.visible).isDisplayed(),
                "Фото не было добавлено в событие");

        return this;
    }

    public FeedPage sharePost(String postContent) {
        LOGGER.info("Поделиться событием");

        $x(NEW_POST_MODAL_X + "//*[@title='Поделиться']").click();

        $x(FeedPage.FEED_LIST_X).shouldBe(Condition.visible);
        Selenide.refresh();
        assertTrue($x(String.format(FeedPage.FEED_LIST_ELEMENT_X + "//*[text()='%s']", postContent))
                .shouldBe(Condition.visible).isDisplayed(),
                "Новое событие не опубликовано");

        return new FeedPage();
    }
}
