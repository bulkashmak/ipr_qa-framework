package ru.bulkashmak.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.bulkashmak.Util.UiUtil;
import ru.bulkashmak.ui.enums.PhotoCategories;

import java.util.Random;

@DisplayName("UI тесты ok.ru")
public class OkTest extends BaseTestUI {

    final static String postContent = "Тестовое событие " + new Random().nextInt(10000);
    static UiUtil uiUtil = new UiUtil();
    final static String commentString = uiUtil.generateRandomStringOfLength(20);

    @Test
    @DisplayName("Добавление нового события с фотографией в ленту")
    public void createNewPostTest() {

        loginPage.loginToOK()
                .createNewPost()
                .inputPostText(postContent)
                .addPostPhoto(PhotoCategories.PERSONAL_PHOTOS)
                .sharePost(postContent);
    }

    @Test
    @DisplayName("Удаление события")
    public void deletePostTest() {

        loginPage.loginToOK()
                .goToProfilePage()
                .openPost()
                .deletePost();
    }

    @Test
    @DisplayName("Добавление комментария со смайлом к событию")
    public void commentWithEmojiTest() {

        loginPage.loginToOK()
                .goToProfilePage()
                .openPost()
                .addComment(commentString);
    }

    @Test
    @DisplayName("Удаление комментария")
    public void deleteCommentTest() {

        loginPage.loginToOK()
                .goToProfilePage()
                .openPost()
                .deleteComment();
    }
}
