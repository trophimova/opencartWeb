package ru.opencart.appmanager;


import com.microsoft.playwright.Page;
import ru.opencart.appmanager.HelperBase;
import ru.opencart.readProperties.ConfigProvider;

public class NavigationHelper extends HelperBase {


    public NavigationHelper(Page page) {
        super(page);
    }

    public void goToMainPage() {
        page.navigate(ConfigProvider.MAINPAGE);
    }
    public void goToLoginPage() {
        page.click(personalAccount);
        page.click("xpath=.//ul[@class='dropdown-menu dropdown-menu-right']/li[2]//a");
    }

    public void goToRegPage() {
        page.click(personalAccount);
        page.click(registration);
    }

    public void signOut() {
        page.click(personalAccount);
        page.click(signOut);
    }

    private final String personalAccount = "xpath=.//a[@title='Личный кабинет']";
    private final String signOut = "xpath=.//ul[@class='dropdown-menu dropdown-menu-right']/li[5]//a";
    private final String registration = "xpath=.//ul[@class='dropdown-menu dropdown-menu-right']//a";


}
