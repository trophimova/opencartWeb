package ru.opencart.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.opencart.model.UserData;

public class RegistrationHelper {
    ChromeDriver wd;

    public void registration() {
        gotoRegPage();
        fillRegForm(new UserData("Cthutq", "sdfghjkl", "test@mail.ru", "88888888", "123456", "123456"));
        confirmRegForm();
    }

    public void confirmRegForm() {
        wd.findElement(By.cssSelector(".btn-primary")).click();
    }

    public void fillRegForm(UserData userData) {
        wd.findElement(By.id("input-firstname")).click();
        wd.findElement(By.id("input-firstname")).sendKeys(userData.getUserFirstname());
        wd.findElement(By.id("input-lastname")).click();
        wd.findElement(By.id("input-lastname")).sendKeys(userData.getUserLastname());
        wd.findElement(By.id("input-email")).click();
        wd.findElement(By.id("input-email")).sendKeys(userData.getEmail());
        wd.findElement(By.id("input-telephone")).click();
        wd.findElement(By.id("input-telephone")).sendKeys(userData.getTelephone());
        wd.findElement(By.id("input-password")).click();
        wd.findElement(By.id("input-password")).sendKeys(userData.getPassword());
        wd.findElement(By.id("input-confirm")).click();
        wd.findElement(By.id("input-confirm")).sendKeys(userData.getConfirmPassword());
        wd.findElement(By.name("agree")).click();
    }

    public void gotoRegPage() {
        wd.get("https://learn-qa.ru/index.php?route=account/register");
    }
}
