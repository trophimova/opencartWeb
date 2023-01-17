package ru.opencart.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.opencart.appmanager.ApplicationManager;


public class TestBase {

    protected static final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

    @BeforeSuite
    public void setUp() throws Exception {
        app.init();
    }

    @BeforeMethod
    public void gotoMainPage() {
        app.goTo().gotoMainPage();
    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }

}
