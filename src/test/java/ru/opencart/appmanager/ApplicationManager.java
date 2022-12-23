package ru.opencart.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    private final RegistrationHelper registrationHelper = new RegistrationHelper();

    public static boolean isAlertPresent(ChromeDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public void init() {
        registrationHelper.wd = new ChromeDriver();
        registrationHelper.wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        registrationHelper.wd.get("https://learn-qa.ru");
        //registration();
        //login();
    }

    public void gotoLoginPage() {
        registrationHelper.wd.get("https://learn-qa.ru/index.php?route=account/login");
    }

    public void stop() {
        registrationHelper.wd.quit();
    }

    public void login() {
        registrationHelper.wd.findElement(By.id("input-email")).click();
        registrationHelper.wd.findElement(By.id("input-email")).sendKeys("test@mail.ru");
        registrationHelper.wd.findElement(By.id("input-password")).click();
        registrationHelper.wd.findElement(By.id("input-password")).sendKeys("123456");
    }

    public RegistrationHelper getRegistrationHelper() {
        return registrationHelper;
    }
}
