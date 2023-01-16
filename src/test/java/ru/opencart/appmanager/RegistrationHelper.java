package ru.opencart.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.opencart.model.RegData;
import ru.opencart.readProperties.ConfigProvider;


public class RegistrationHelper extends HelperBase {

    public RegistrationHelper(WebDriver wd) {
        super(wd);
    }

    public void registration() {
        fillRegForm(new RegData()
                .withUserFirstname("Cthutq")
                .withUserLastname("sdfghjkl")
                .withEmail("tetggok9888st@mail.ru")
                .withTelephone("88888888")
                .withPassword("123456")
                .withConfirmPassword("123456"));
        confirmRegForm();
    }

    public void confirmRegForm() {
        submit.click();
    }

    public void fillRegForm(RegData regData) {
        type(inputFirstname, regData.getUserFirstname());
        type(inputLastname, regData.getUserLastname());
        type(inputEmail, regData.getEmail());
        type(inputTelephone, regData.getTelephone());
        type(inputPassword, regData.getPassword());
        type(inputConfirm, regData.getConfirmPassword());
        checkbox.click();
    }

    //private final By inputFirstname = By.xpath(".//input[@id='input-firstname']");

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
    private WebElement title;

    @FindBy(className = "form-control")
    private WebElement formFields;

}
