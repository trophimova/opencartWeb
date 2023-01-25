package ru.opencart;


import com.microsoft.playwright.Page;
import ru.opencart.readProperties.ConfigProvider;

public class NavigationHelper extends HelperBase {

    private final Page page;

    public NavigationHelper(Page page) {
        this.page = page;
    }

    public void goToMainPage() {
        page.navigate(ConfigProvider.MAINPAGE);
    }
    public void goToLoginPage() {
        page.click(personalAccount);
        page.click("xpath=.//ul[@class='dropdown-menu dropdown-menu-right']/li[2]//a");
    }

    public void signOut() {
        page.click(personalAccount);
        page.click(signOut);
    }

    private final String personalAccount = "xpath=.//a[@title='Личный кабинет']";
    private final String signOut = "xpath=.//ul[@class='dropdown-menu dropdown-menu-right']/li[5]//a";
}
