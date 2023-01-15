package ru.opencart.readProperties;

import org.testng.annotations.Test;
import ru.opencart.tests.TestBase;

import java.io.IOException;

public class PropertiesTest extends TestBase {
    @Test
    public void readProperties() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("application.properties"));
        String urlFromProperty = System.getProperty("url");
    }


}
