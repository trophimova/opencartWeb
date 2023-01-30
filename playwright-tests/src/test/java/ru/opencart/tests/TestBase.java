package ru.opencart.tests;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import ru.opencart.appmanager.ApplicationManager;

import java.io.IOException;

import static ru.opencart.readProperties.ConfigProvider.BROWSER;

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
