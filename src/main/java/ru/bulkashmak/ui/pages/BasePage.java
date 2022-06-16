package ru.bulkashmak.ui.pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.bulkashmak.ui.UiProperties;

import static org.junit.jupiter.api.Assertions.*;

import static com.codeborne.selenide.Selenide.*;

public class BasePage {

    private static final Logger LOGGER = LoggerFactory.getLogger(BasePage.class);

    private static final String BUTTON_PAGE_LANGUAGE_X = "//div[contains(@class, 'ph-lang-select')]";
    private static final String MODAL_PAGE_LANGUAGE_X = "//div[contains(@class, 'ph-lang-modal')]";

    public BasePage openOK() {
        String url =  UiProperties.getProperty("url");
        LOGGER.info(String.format("Переход на '%s'", url));
        open(url);

        return this;
    }

    public BasePage setLanguage(String language) {
        LOGGER.info(String.format("Установка '%s' языка на сайте", language));

        if ($x(BUTTON_PAGE_LANGUAGE_X).text().contains(language)) {
            return this;
        } else {
            $x(BUTTON_PAGE_LANGUAGE_X).click();
            $x(MODAL_PAGE_LANGUAGE_X + String.format("//*[text()='%s']", language)).click();

            assertTrue($x(BUTTON_PAGE_LANGUAGE_X).text().contains("Русский"),
                    "Не удалось переключить язык веб-сайта на русский");
        }

        return this;
    }
}
