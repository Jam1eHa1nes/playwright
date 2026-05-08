package steps;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    public static void loadProperties() {
        properties = new Properties();
        try (FileInputStream fis = new FileInputStream("src/test/resources/properties/core.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Could not find core.properties file");
        }
    }

    public static String getProperty(String key) {
        // Check System property first (for Maven CLI), then fallback to file
        return System.getProperty(key, properties.getProperty(key));
    }
}