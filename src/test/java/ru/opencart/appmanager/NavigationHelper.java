package ru.opencart.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.opencart.readProperties.ConfigProvider;


public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void gotoMainPage() {
        wd.get(ConfigProvider.MAINPAGE);
    }

    public void gotoLoginPage() {
        if (isElementPresent(By.tagName("h2"))
                && wd.findElement(By.tagName("h2")).getText().equals("Зарегистрированный клиент")) {
            return;
        }
        click(personalAccount);
        click(authorization);


    }

    public void gotoRegPage() {
        if (isElementPresent(By.tagName("h1"))
                && wd.findElement(By.tagName("h1")).getText().equals("Регистрация")) {
            return;
        }
        click(personalAccount);
        click(registration);
    }

    public void signOut() {
        click(personalAccount);
        click(signOut);
    }

    public void gotoProductPage() {
        wd.get("https://learn-qa.ru/index.php?route=product/category&path=33");
    }

    public void gotoCart() {
        wd.get("https://learn-qa.ru/index.php?route=checkout/cart");
    }


    @FindBy(xpath = ".//a[@title='Личный кабинет']")
    private WebElement personalAccount;

    @FindBy(xpath = ".//ul[@class='dropdown-menu dropdown-menu-right']//a")
    private WebElement registration;

    @FindBy(xpath = ".//ul[@class='dropdown-menu dropdown-menu-right']/li[2]//a")
    private WebElement authorization;

    @FindBy(xpath = ".//ul[@class='dropdown-menu dropdown-menu-right']/li[5]//a")
    private WebElement signOut;


}
