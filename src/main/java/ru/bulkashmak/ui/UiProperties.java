package ru.bulkashmak.ui;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UiProperties {
    private static Properties properties = new Properties();

    static {
        try(InputStream inputStream = UiProperties.class.getClassLoader().getResourceAsStream("ui.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String nameProperty) {
        return properties.getProperty(nameProperty);
    }
}
