package ru.bulkashmak.ui.pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

import static com.codeborne.selenide.Selenide.*;

public class BasePage {

    private static final Logger LOGGER = LoggerFactory.getLogger(BasePage.class);

    private static final String BUTTON_PAGE_LANGUAGE_X = "//div[contains(@class, 'ph-lang-select')]";
    private static final String MODAL_PAGE_LANGUAGE_X = "//div[contains(@class, 'ph-lang-modal')]";

    public BasePage openOK() {
        LOGGER.info("Переход на 'https://ok.ru/'");
        open("https://ok.ru/");

        return this;
    }

    public BasePage setLanguage() {
        LOGGER.info("Установка русского языка на сайте");

        if ($x(BUTTON_PAGE_LANGUAGE_X).text().contains("Русский")) {
            return this;
        } else {
            $x(BUTTON_PAGE_LANGUAGE_X).click();
            $x(MODAL_PAGE_LANGUAGE_X + "//*[text()='Русский']").click();

            assertTrue($x(BUTTON_PAGE_LANGUAGE_X).text().contains("Русский"),
                    "Не удалось переключить язык веб-сайта на русский");
        }

        return this;
    }
}
