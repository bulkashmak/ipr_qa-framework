package ru.bulkashmak.ui.pages;

import static org.junit.jupiter.api.Assertions.*;

import static com.codeborne.selenide.Selenide.*;

public class BasePage {

    private static final String BUTTON_PAGE_LANGUAGE_X = "//div[contains(@class, 'ph-lang-select')]";
    private static final String MODAL_PAGE_LANGUAGE_X = "//div[contains(@class, 'ph-lang-modal')]";

    public BasePage openOK() {
        open("https://ok.ru/");

        return this;
    }

    public BasePage setLanguage() {

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
