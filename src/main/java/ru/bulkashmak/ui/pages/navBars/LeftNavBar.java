package ru.bulkashmak.ui.pages.navBars;

import com.codeborne.selenide.Condition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.bulkashmak.ui.pages.ProfilePage;

import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LeftNavBar {
    private static final Logger LOGGER = LoggerFactory.getLogger(LeftNavBar.class);

    public ProfilePage goToProfilePage() {
        LOGGER.info("Переход на страницу 'Профиль'");

        $x("//*[@id='hook_Block_SideNavigation']//*[@data-l='t,userPage']").click();

        assertTrue($x("//*[@id='hook_Block_UserProfileCoverWrapper']")
                        .shouldBe(Condition.visible).isDisplayed(),
                "Не произошел переход на страницу Профиля");

        return new ProfilePage();
    }
}
