package ru.bulkashmak.ui.pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.bulkashmak.ui.enums.PhotoCategories;

import static com.codeborne.selenide.Selenide.*;

public class NewPostPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(NewPostPage.class);

    public static final String NEW_POST_MODAL_X = "//*[@id='hook_Block_MediaTopicLayerBody']";
    public static final String POST_TEXT_X = NEW_POST_MODAL_X + "//*[@data-module='postingForm/mediaText']";
    public static final String POST_PHOTO_X = NEW_POST_MODAL_X + "//*[@title='Добавить фото']";

    public NewPostPage inputPostText(String postText) {
        LOGGER.info(String.format("Ввод содержания события ''%s''", postText));

        $x(POST_TEXT_X).sendKeys(postText);

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

        return this;
    }

    public FeedPage sharePost() {
        LOGGER.info("Поделиться событием");

        $x(NEW_POST_MODAL_X + "//*[@title='Поделиться']").click();

        return new FeedPage();
    }
}
