package ru.opencart;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class GroupCreationTest {

    ChromeDriver wd;

    @BeforeMethod
    public void setUp() throws Exception {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("https://learn-qa.ru");
        registration();
    }

    private void registration() {
        gotoRegPage();
        fillRegForm(new UserData("Cthutq", "sdfghjkl", "test@mail.ru", "88888888", "123456", "123456"));
        confirmRegForm();
    }

    private void confirmRegForm() {
        wd.findElement(By.cssSelector(".btn-primary")).click();
    }

    private void fillRegForm(UserData userData) {
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

    private void gotoRegPage() {
        wd.get("https://learn-qa.ru/index.php?route=account/register");
    }


    @Test
    public void testPositiveRegistration() {
        //здесь должна быть проверка успешной регистрации
        wd.get("https://learn-qa.ru/index.php?route=product/category&path=33");
    }



    @AfterMethod
    public void tearDown() {
        wd.quit();
    }

    public static boolean isAlertPresent(ChromeDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
