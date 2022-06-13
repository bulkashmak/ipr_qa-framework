package ru.bulkashmak.ui.pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.bulkashmak.ui.enums.PhotoCategories;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;

public class NewPostPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(NewPostPage.class);

    public static final String NEW_POST_MODAL_X = "//*[@id='hook_Block_MediaTopicLayerBody']";
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

    public NewPostPage addPostPhoto(PhotoCategories category) {
        LOGGER.info("Добавление фото в событие");

        String modalX = "//*[contains(@class, 'modal-out-scroll-body')]";

        $x(POST_PHOTO_X).click();
        $x(category.getCategoryX()).click();
        $$x(modalX + "//*[contains(@class, 'photo-img-wrapper')]")
                .get(1).click();
        $x(modalX + "//*[contains(@class, 'attach-button')]").click();

        assertTrue($x(NEW_POST_MODAL_X + "//*[@class='posting_photo_img js-img']")
                .shouldBe(Condition.visible).isDisplayed(),
                "Фото не было добавлено в событие");

        return this;
    }

    public FeedPage sharePost(String postContent) {
        LOGGER.info("Поделиться событием");

        $x(NEW_POST_MODAL_X + "//*[@title='Поделиться']").click();

        assertTrue($x(String.format("//*[@id='hook_Block_MainFeedsNewFeed']//*[text()='%s']", postContent))
                .shouldBe(Condition.visible).isDisplayed(),
                "Новое событие не опубликовано");

        return new FeedPage();
    }
}
