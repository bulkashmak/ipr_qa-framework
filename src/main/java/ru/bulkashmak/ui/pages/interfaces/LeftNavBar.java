package ru.bulkashmak.ui.pages.interfaces;

import com.codeborne.selenide.Condition;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.bulkashmak.ui.pages.ProfilePage;

import static org.junit.jupiter.api.Assertions.*;

import static com.codeborne.selenide.Selenide.*;

public interface LeftNavBar {
    Logger LOGGER = LoggerFactory.getLogger(LeftNavBar.class);

    default ProfilePage goToProfilePage() {
        LOGGER.info("Переход на страницу 'Профиль'");

        $x(LeftNavBarElements.PROFILE.getXpath()).click();

        assertTrue($x("//*[@id='hook_Block_UserProfileCoverWrapper']")
                .shouldBe(Condition.visible).isDisplayed(),
                "Не произошел переход на страницу Профиля");

        return new ProfilePage();
    }

    @Getter
    enum LeftNavBarElements {

        PROFILE("//*[@id='hook_Block_SideNavigation']//*[@data-l='t,userPage']");

        private final String xpath;

        LeftNavBarElements(String xpath) {
            this.xpath = xpath;
        }
    }
}
