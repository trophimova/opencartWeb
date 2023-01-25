package ru.opencart;


import com.microsoft.playwright.Page;
import ru.opencart.model.AuthData;

public class AuthHelper extends HelperBase {

    private Page page;

    public AuthHelper(Page page) {
        this.page = page;
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
    private String inputEmail = "[id=input-email]";
    private String inputPassword = "[id=input-password]";
    private String submit = "[type=submit]";
    private String myAccountTitle = "xpath=.//div[@id='content']//h2[1]";



}
