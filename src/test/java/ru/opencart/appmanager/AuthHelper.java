package ru.opencart.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.opencart.model.AuthData;
import ru.opencart.model.RegData;


public class AuthHelper extends HelperBase {

    public AuthHelper(WebDriver wd) {
        super(wd);
    }

    public void login() {
        fillAuthForm(new AuthData()
                .withEmail("tegg88st@mail.ru")
                .withPassword("123456"));
        confirmAuthForm();
    }

    public void fillAuthForm(AuthData authData) {
        type(By.id("input-email"), authData.getEmail());
        type(By.id("input-password"), authData.getPassword());
    }

    public void confirmAuthForm() {
        click();
    }

    private void click() {
        click(By.cssSelector(".btn-primary"));
    }


}
