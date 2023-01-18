package ru.opencart.appmanager;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.opencart.model.RegData;



public class RegistrationHelper extends HelperBase {

    public RegistrationHelper(WebDriver wd) {
        super(wd);
    }

    public void setValidRegistration(RegData regData) {
        fillRegForm(regData);
        confirmRegForm();
    }

    public void confirmRegForm() {
        click(submit);
    }

    public void fillRegForm(RegData regData) {
        type(inputFirstname, regData.getUserFirstname());
        type(inputLastname, regData.getUserLastname());
        type(inputEmail, regData.getEmail());
        type(inputTelephone, regData.getTelephone());
        type(inputPassword, regData.getPassword());
        type(inputConfirm, regData.getConfirmPassword());
        click(checkbox);
    }

    public RegistrationHelper title() {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@id='content']//h1")));
        return this;
    }

    public String getNameTitle() {
        String nameTitle = getNameTitle(title);
        return nameTitle;
    }

    @FindBy(xpath = ".//input[@id='input-firstname']")
    private WebElement inputFirstname;

    @FindBy(xpath = ".//input[@id='input-lastname']")
    private WebElement inputLastname;

    @FindBy(xpath = ".//input[@id='input-email']")
    private WebElement inputEmail;

    @FindBy(xpath = ".//input[@id='input-telephone']")
    private WebElement inputTelephone;

    @FindBy(xpath = ".//input[@id='input-password']")
    private WebElement inputPassword;

    @FindBy(xpath = ".//input[@id='input-confirm']")
    private WebElement inputConfirm;

    @FindBy(xpath = ".//input[@type='checkbox']")
    private WebElement checkbox;

    @FindBy(xpath = ".//input[@type='submit']")
    private WebElement submit;

    @FindBy(xpath = ".//div[@id='content']//h1")
    public WebElement title;

    @FindBy(className = "form-control")
    private WebElement formFields;

    public static String successRegMessage = "Ваша учетная запись создана!";

}
