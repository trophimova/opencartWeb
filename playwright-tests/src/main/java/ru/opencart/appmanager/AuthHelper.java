package ru.opencart.appmanager;


import com.microsoft.playwright.Browser;
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
        page.click(submit);
    }

    private void fillLoginCredentials(AuthData authData) {
        page.fill(inputEmail, authData.getEmail());
        page.fill(inputPassword, authData.getPassword());

    }

    public String getTitleName() {
        return page.locator(myAccountTitle).textContent();
    }

    public static String successLoginTitle = "Моя учетная запись";
    private final String inputEmail = "[id=input-email]";
    private final String inputPassword = "[id=input-password]";
    private final String submit = "[type=submit]";
    private final String myAccountTitle = "xpath=.//div[@id='content']//h2[1]";



}
