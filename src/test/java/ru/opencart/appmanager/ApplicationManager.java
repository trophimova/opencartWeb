package ru.opencart.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.BrowserType;


import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;

    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private RegistrationHelper registrationHelper;
    private CartHelper cartHelper;
    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        if (browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver();
        } else if (browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
        } else if (browser.equals(BrowserType.IE)) {
            wd = new InternetExplorerDriver();
        }
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("https://learn-qa.ru");
        registrationHelper = new RegistrationHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);
        //cartHelper = new CartHelper(wd);
    }

    public void stop() {
        wd.quit();
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }

    public RegistrationHelper getRegistrationHelper() {
        return registrationHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public CartHelper getCartHelper() {
        return cartHelper;
    }
}
