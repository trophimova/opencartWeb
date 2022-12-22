package ru.opencart;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

public class GroupCreationTest {

    ChromeDriver wd;

    @BeforeMethod
    public void setUp() throws Exception{
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @Test
    public void positiveReg() {
        wd.get("https://learn-qa.ru/index.php?route=account/register");
        wd.findElement(By.id("input-firstname")).click();
        wd.findElement(By.id("input-firstname")).sendKeys("Cthutq");
        wd.findElement(By.id("input-lastname")).click();
        wd.findElement(By.id("input-lastname")).sendKeys("sdfghjkl");
        wd.findElement(By.id("input-email")).click();
        wd.findElement(By.id("input-email")).sendKeys("test@mail.ru");
        wd.findElement(By.id("input-telephone")).click();
        wd.findElement(By.id("input-telephone")).sendKeys("88888888");
        wd.findElement(By.id("input-password")).click();
        wd.findElement(By.id("input-password")).sendKeys("123456");
        wd.findElement(By.id("input-confirm")).click();
        wd.findElement(By.id("input-confirm")).sendKeys("123456");
        wd.findElement(By.name("agree")).click();
        wd.findElement(By.cssSelector(".btn-primary")).click();
    }

    @AfterMethod
    public void tearDown() {
        wd.quit();
    }
}
