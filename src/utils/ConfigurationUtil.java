package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationUtil {
    private static final Properties PROPERTY = getProperties();

    private static Properties getProperties() {
        Properties property = new Properties();
        try (FileInputStream fis = new FileInputStream("setup.properties")) {
            property.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return property;
    }

    public static String getBaseUrl() {
        return PROPERTY.getProperty("base_url");
    }

    public static String getUserEmail() {
        return PROPERTY.getProperty("user_email");
    }

    public static String getUserPassword() {
        return PROPERTY.getProperty("user_password");
    }

    public static String getPdpUrl() {
        return PROPERTY.getProperty("pdp_url");
    }
}