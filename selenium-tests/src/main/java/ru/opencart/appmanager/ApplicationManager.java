package ru.opencart.appmanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.BrowserType;
import ru.opencart.readProperties.ConfigProvider;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    public static WebDriver wd;


    private AuthHelper authHelper;
    private NavigationHelper navigationHelper;
    private RegistrationHelper registrationHelper;
    private CartHelper cartHelper;
    private String browser;


    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() throws IOException {
        if (browser.equals(BrowserType.FIREFOX)) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();

            options.addArguments(ConfigProvider.BROWSER_OPTIONS);
            wd = new FirefoxDriver(options);
        } else if (browser.equals(BrowserType.CHROME)) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments(ConfigProvider.BROWSER_OPTIONS);
            wd = new ChromeDriver(options);
        } else if (browser.equals(BrowserType.EDGE)) {
            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();
            options.addArguments(ConfigProvider.BROWSER_OPTIONS);
            wd = new EdgeDriver(options);
        }
        wd.manage().timeouts().implicitlyWait(ConfigProvider.IMPLICITWAIT, TimeUnit.SECONDS);
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
