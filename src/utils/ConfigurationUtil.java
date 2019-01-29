package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationUtil {
    public static String getBaseUrl() {
        Properties property = getProperties();
        return property.getProperty("base_url");
    }

    private static Properties getProperties() {
        Properties property = new Properties();
        try (FileInputStream fis = new FileInputStream("setup.properties")) {
            property.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return property;
    }

    public static String getUserEmail() {
        Properties property = getProperties();
        return property.getProperty("user_email");
    }

    public static String getUserPassword() {
        Properties property = getProperties();
        return property.getProperty("user_password");
    }
}