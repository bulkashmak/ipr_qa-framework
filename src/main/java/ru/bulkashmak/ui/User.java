package ru.bulkashmak.ui;

import lombok.Getter;
import lombok.Setter;
import ru.bulkashmak.ui.properties.UiProperties;

@Getter
@Setter
public class User {

    private String email = UiProperties.getProperty("email");
    private String password = UiProperties.getProperty("password");
    private String language = "Русский";
}
