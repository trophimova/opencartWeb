package ru.opencart;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class BaseTest {


    protected final ApplicationManager app = new ApplicationManager();

    @BeforeSuite
    public void setUp() {
        app.init();
    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }


    @AfterMethod
        public void attachFilesToFailedTest(ITestResult result) throws IOException {
        app.attachFilesToTest(result);
    }

    public ApplicationManager getApp() {
        return app;
    }
}
