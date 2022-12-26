package ru.opencart.appmanager;

import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(ChromeDriver wd) {
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
