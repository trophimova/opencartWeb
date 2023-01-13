package ru.opencart.appmanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
            WebDriverManager.firefoxdriver().setup();
            wd = new FirefoxDriver();
        } else if (browser.equals(BrowserType.CHROME)) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            options.addArguments("start-maximized");
            wd = new ChromeDriver(options);
        } else if (browser.equals(BrowserType.IE)) {
            WebDriverManager.iedriver().setup();
            wd = new InternetExplorerDriver();
        }
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
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
