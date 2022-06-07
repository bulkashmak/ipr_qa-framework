package ru.bulkashmak.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.bulkashmak.BaseTestUI;
import ru.bulkashmak.ui.enums.PhotoCategories;

import java.util.Random;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

@DisplayName("UI тесты ok.ru")
public class OkTest extends BaseTestUI {

    final static String postContent = "Тестовое событие " + new Random().nextInt(10000);

    @Test
    public void createNewPostTest() {

        loginPage.loginToOK()
                .createNewPost()
                .inputPostText(postContent)
                .addPostPhoto(PhotoCategories.PERSONAL_PHOTOS)
                .sharePost();
    }

    @Test
    public void deletePostTest() {

        loginPage.loginToOK()
                .goToProfilePage()
                .openPost(postContent)
                .deletePost();

        System.out.println();
    }
}
