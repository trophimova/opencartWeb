package ru.opencart.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.opencart.model.AuthData;
import ru.opencart.readProperties.ConfigProvider;


public class AuthHelper extends HelperBase {

    public AuthHelper(WebDriver wd) {
        super(wd);
    }

    public void login() {
        fillAuthForm(new AuthData()
                .withEmail(ConfigProvider.USER_EMAIL)
                .withPassword(ConfigProvider.USER_PASSWORD));
        confirmAuthForm();
    }



    public void fillAuthForm(AuthData authData) {
        type(inputEmail, authData.getEmail());
        type(inputPassword, authData.getPassword());

    }


    public void confirmAuthForm() {
        confirm();
    }

    private void confirm() {
        submit.click();
    }


    @FindBy(xpath = ".//input[@id='input-email']")
    private WebElement inputEmail;

    @FindBy(xpath = ".//input[@id='input-password']")
    private WebElement inputPassword;

    @FindBy(xpath = ".//input[@type='submit']")
    private WebElement submit;


}
