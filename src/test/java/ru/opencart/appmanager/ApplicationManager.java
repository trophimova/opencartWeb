package ru.opencart.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;


import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;

    private AuthHelper authHelper;
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
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.get("https://learn-qa.ru");
        registrationHelper = new RegistrationHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        authHelper = new AuthHelper(wd);
        cartHelper = new CartHelper(wd);
    }

    public void stop() {
        wd.quit();
    }

    public AuthHelper authorization() {
        return authHelper;
    }

    public RegistrationHelper registration() {
        return registrationHelper;
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }

    public CartHelper cart() {
        return cartHelper;
    }
}
