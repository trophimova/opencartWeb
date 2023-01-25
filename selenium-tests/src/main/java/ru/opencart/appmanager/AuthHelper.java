package ru.opencart.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.opencart.model.AuthData;


public class AuthHelper extends HelperBase {


    public AuthHelper(WebDriver wd) {
        super(wd);
    }

    public void login(AuthData authData) {
        fillAuthForm(authData);
        confirmAuthForm();
    }


    public void fillAuthForm(AuthData authData) {
        type(inputEmail, authData.getEmail());
        type(inputPassword, authData.getPassword());

    }


    public void confirmAuthForm() {
        confirm();
    }

    public void confirm() {
        submit.click();
    }

    public AuthHelper title() {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@id='content']//h2[1]")));
        return this;
    }

    public String getNameTitle() {
        String nameTitle = getNameTitle(myAccountTitle);
        return nameTitle;
    }

    @FindBy(xpath = ".//input[@id='input-email']")
    private WebElement inputEmail;

    @FindBy(xpath = ".//input[@id='input-password']")
    private WebElement inputPassword;

    @FindBy(xpath = ".//input[@type='submit']")
    private WebElement submit;

    @FindBy(xpath = ".//div[@id='content']//h2[1]")
    private WebElement myAccountTitle;

    public static String successAuthTitle = "Моя учетная запись";

}
