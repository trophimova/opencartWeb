package ru.opencart.tests;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class AuthorizationTest extends TestBase {


    @Test
    @Owner("Анна Трофимова")
    @Description("Тест проверяет наличие двух полей для ввода данных")
    @Link("https://github.com/trophimova/opencartWeb")
    @Severity(SeverityLevel.BLOCKER)
    public void testPositiveAuthorization() {
        app.goTo().gotoLoginPage();
        int count = app.authorization().count(By.className("form-control"));
        assertThat(2, equalTo(count - 1));
        app.authorization().login();


    }


}
