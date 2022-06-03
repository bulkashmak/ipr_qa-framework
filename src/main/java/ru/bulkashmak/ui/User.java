package ru.bulkashmak.ui;

import lombok.Getter;
import lombok.Setter;
import ru.bulkashmak.ui.properties.UserData;

@Getter
@Setter
public class User {

    private String email = UserData.getProperty("email");
    private String password = UserData.getProperty("password");
}
