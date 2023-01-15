package ru.opencart.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class AuthorizationTest extends TestBase {


    @Test
    @Owner("Anna Trofimova")
    @Description("")
    public void testPositiveAuthorization() {
        app.goTo().gotoLoginPage();
        int count = app.authorization().count(By.className("form-control"));
        app.authorization().login();
        assertThat(2, equalTo(count - 1));
    }


}
