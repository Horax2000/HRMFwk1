package org.HRMFwk.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AttributeLoader {
    private Properties properties = new Properties();

    public AttributeLoader(String filePath) {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getAttribute(String key) {
        return properties.getProperty(key);
    }
}