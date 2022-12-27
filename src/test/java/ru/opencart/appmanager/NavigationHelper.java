package ru.opencart.appmanager;

import org.openqa.selenium.WebDriver;


public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void gotoLoginPage() {
        wd.get("https://learn-qa.ru/index.php?route=account/login");
    }

    public void gotoRegPage() {
        wd.get("https://learn-qa.ru/index.php?route=account/register");
    }

    public void gotoProductPage() {
        wd.get("https://learn-qa.ru/index.php?route=product/category&path=33");
    }
}
