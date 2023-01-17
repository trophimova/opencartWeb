package ru.opencart.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HelperBase {
    protected WebDriver wd;
    private WebDriverWait wait;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
        wait = new WebDriverWait(wd, Duration.ofSeconds(3));
        PageFactory.initElements(wd, this);
    }

    protected WebDriverWait getWait(){
        return this.wait;
    }

    protected void click(By locator) {
        wd.findElement(locator).click();
    }

    protected void click(WebElement webElement) {
        webElement.click();
    }

//    protected void type(By locator, String text) {
//        wd.findElement(locator).click();
//        wd.findElement(locator).sendKeys(text);
//    }

    protected void type(WebElement webElement, String authData) {
        webElement.click();
        webElement.sendKeys(authData);
    }

    public boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    protected boolean isElementPresent(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }

    }

    public int count(By locator) {
        return wd.findElements(locator).size();
    }


    public String getNameTitle(WebElement webElement) {
        String nameTitle = webElement.getText();
        return nameTitle;
    }
}
