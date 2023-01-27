package ru.opencart.tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import org.testng.ITestResult;
import org.testng.annotations.*;
import ru.opencart.appmanager.ApplicationManager;

import java.io.IOException;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager(System.getProperty("browserType", "webkit"));

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
