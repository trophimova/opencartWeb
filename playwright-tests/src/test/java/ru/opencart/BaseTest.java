package ru.opencart;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class BaseTest extends ApplicationManager{


    @BeforeSuite
    public void setUp() {
        init();
    }

    @AfterSuite
    public void tearDown() {
        stop();
    }


    @AfterMethod
        public void attachFilesToFailedTest(ITestResult result) throws IOException {
        attachFilesToTest(result);
    }

}
