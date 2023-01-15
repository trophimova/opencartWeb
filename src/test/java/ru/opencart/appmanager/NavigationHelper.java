package ru.opencart.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.opencart.readProperties.ConfigProvider;


public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void gotoMainPage() {
        wd.get(ConfigProvider.readConfig().getString("mainPage"));
    }

    public void gotoLoginPage() {
        if (isElementPresent(By.tagName("h2"))
                && wd.findElement(By.tagName("h2")).getText().equals("Зарегистрированный клиент")) {
            return;
        }
        wd.get("https://learn-qa.ru/index.php?route=account/login");
    }

    public void gotoRegPage() {
        if (isElementPresent(By.tagName("h1"))
                && wd.findElement(By.tagName("h1")).getText().equals("Регистрация")) {
            return;
        }
        wd.get("https://learn-qa.ru/index.php?route=account/register");
    }

    public void gotoProductPage() {
//        if (isElementPresent(By.tagName("h2"))
//                && wd.findElement(By.tagName("h2")).getText().equals("Камеры")) {
//            return;
//        }

        wd.get("https://learn-qa.ru/index.php?route=product/category&path=33");
    }

    public void gotoCart() {
        wd.get("https://learn-qa.ru/index.php?route=checkout/cart");
    }
}
