package ru.opencart;


import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class AuthHelper extends HelperBase {

    private Page page;

    public AuthHelper(Page page) {
        this.page = page;
    }


    public void login() {
        fillLoginCredentials();
        confirmLogin();
    }

    private void confirmLogin() {
        //submit.click();
        page.click("[type=submit]");
    }

    private void fillLoginCredentials() {
        page.fill("[id=input-email]", "tegg88st@mail.ru");
        page.fill("[id=input-password]", "123456");

    }

    public String getTitleName() {
        return page.locator("xpath=.//div[@id='content']//h2[1]").textContent();
    }

    public static String successLoginTitle = "Моя учетная запись";

    //Locator submit = page.locator("[type=submit]");
}
