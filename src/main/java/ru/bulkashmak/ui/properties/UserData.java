package ru.bulkashmak.ui.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UserData {
    private static final Properties prop = new Properties();

    static {
        try(InputStream inputStream = UserData.class.getClassLoader().getResourceAsStream("user.properties")) {
            prop.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String nameProperty) {
        return prop.getProperty(nameProperty);
    }
}
