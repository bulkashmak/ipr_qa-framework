package ru.bulkashmak.ui.pages.interfaces;

import lombok.Getter;
import org.slf4j.Logger;
import ru.bulkashmak.ui.pages.ProfilePage;
import ru.bulkashmak.ui.properties.UserData;

import static com.codeborne.selenide.Selenide.*;

public interface LeftNavBar {

    default ProfilePage goToProfilePage() {
        $x(LeftNavBarElements.PROFILE.getXpath()).click();

        return new ProfilePage();
    }

    @Getter
    enum LeftNavBarElements {

        PROFILE(String.format("//*[@id='hook_Block_SideNavigation']//*[@href='/profile/%s']",
                UserData.getProperty("userId")));

        private final String xpath;

        LeftNavBarElements(String xpath) {
            this.xpath = xpath;
        }
    }
}
