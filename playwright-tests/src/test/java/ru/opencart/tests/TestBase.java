package ru.opencart.tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import org.testng.ITestResult;
import org.testng.annotations.*;
import ru.opencart.appmanager.ApplicationManager;
import ru.opencart.readProperties.ConfigProvider;

import java.io.IOException;

import static ru.opencart.readProperties.ConfigProvider.*;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager(BROWSER);

    @BeforeClass
    public void setUp() {
        app.init();
    }

    @AfterClass
    public void tearDown() {
        app.stop();
    }



    @AfterMethod
        public void attachFilesToFailedTest(ITestResult result) throws IOException {
        app.attachFilesToTest(result);
    }

}
