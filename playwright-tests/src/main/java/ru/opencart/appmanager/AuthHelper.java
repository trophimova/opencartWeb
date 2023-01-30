package ru.opencart.appmanager;


import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import ru.opencart.model.AuthData;

public class AuthHelper extends HelperBase {


    public AuthHelper(Page page) {
        super(page);
    }


    public void login(AuthData authData) {
        fillLoginCredentials(authData);
        confirmLogin();
    }

    private void confirmLogin() {
        submit.click();
    }

    private void fillLoginCredentials(AuthData authData) {
        inputEmail.fill(authData.getEmail());
        inputPassword.fill(authData.getPassword());
    }

    public String getTitleName() {
        return myAccountTitle.textContent();
    }

    public static String successLoginTitle = "Моя учетная запись";
    Locator inputEmail = page.locator("[id=input-email]");
    Locator inputPassword = page.locator("[id=input-password]");
    Locator submit = page.locator("[type=submit]");
    Locator myAccountTitle = page.locator("xpath=.//div[@id='content']//h2[1]");



}
