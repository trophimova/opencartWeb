package ru.opencart;


import com.microsoft.playwright.Page;

public class NavigationHelper extends HelperBase {

    private final Page page;

    public NavigationHelper(Page page) {
        this.page = page;
    }

    public void goToMainPage() {
        page.navigate("https://learn-qa.ru/");
    }
    public void goToLoginPage() {
        page.click("xpath=.//a[@title='Личный кабинет']");
        page.click("xpath=.//ul[@class='dropdown-menu dropdown-menu-right']/li[2]//a");
    }

}
