package ru.opencart.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.opencart.model.UserData;

public class RegistrationHelper extends HelperBase {

    public RegistrationHelper(ChromeDriver wd) {
        super(wd);
    }

    public void registration() {
        fillRegForm(new UserData("Cthutq", "sdfghjkl", "teggst@mail.ru", "88888888", "123456", "123456"));
        confirmRegForm();
    }

    public void confirmRegForm() {
        click(By.cssSelector(".btn-primary"));
    }

    public void fillRegForm(UserData userData) {
        type(By.id("input-firstname"), userData.getUserFirstname());
        type(By.id("input-lastname"), userData.getUserLastname());
        type(By.id("input-email"), userData.getEmail());
        type(By.id("input-telephone"), userData.getTelephone());
        type(By.id("input-password"), userData.getPassword());
        type(By.id("input-confirm"), userData.getConfirmPassword());
        click(By.name("agree"));
    }


}
