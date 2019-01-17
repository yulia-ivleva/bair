package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationUtil {
    public static String getBaseUrl() {
        Properties property = new Properties();
        try (FileInputStream fis = new FileInputStream("setup.properties")) {
            property.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return property.getProperty("base_url");
    }
}
