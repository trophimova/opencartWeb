package ru.opencart.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SessionHelper extends HelperBase {

    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void login() {
        fillAuthForm(null, null); //"test@mail.ru", "123456"
        confirmAuthForm();
    }

    public void fillAuthForm(String email, String password) {
        type(By.id("input-email"), email);
        type(By.id("input-password"), password);
    }

    public void confirmAuthForm() {
        click();
    }

    private void click() {
        click(By.cssSelector(".btn-primary"));
    }

}
