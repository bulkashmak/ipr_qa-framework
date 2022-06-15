package ru.bulkashmak.api;

import ru.bulkashmak.ui.UiProperties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ApiProperties {
    private static Properties properties = new Properties();

    static {
        try(InputStream inputStream = UiProperties.class.getClassLoader().getResourceAsStream("api.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String nameProperty) {
        return properties.getProperty(nameProperty);
    }
}
