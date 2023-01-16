package ru.opencart.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;


public class HelperBase {
    protected WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
        PageFactory.initElements(wd, this);
    }

    protected void click(By locator) {
        wd.findElement(locator).click();
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


}
