package ru.bulkashmak.ui.pages.interfaces;

import com.codeborne.selenide.Condition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.bulkashmak.ui.pages.ProfilePage;

import static org.junit.jupiter.api.Assertions.*;

import static com.codeborne.selenide.Selenide.*;

public interface LeftNavBar {
    Logger LOGGER = LoggerFactory.getLogger(LeftNavBar.class);

    default ProfilePage goToProfilePage() {
        LOGGER.info("Переход на страницу 'Профиль'");

        $x("//*[@id='hook_Block_SideNavigation']//*[@data-l='t,userPage']").click();

        assertTrue($x("//*[@id='hook_Block_UserProfileCoverWrapper']")
                .shouldBe(Condition.visible).isDisplayed(),
                "Не произошел переход на страницу Профиля");

        return new ProfilePage();
    }
}
