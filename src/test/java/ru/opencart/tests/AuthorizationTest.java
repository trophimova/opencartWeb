package ru.opencart.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AuthorizationTest extends TestBase {


    @Test
    public void testPositiveAuthorization() {
        app.goTo().loginPage();
        int count = app.authorization().count(By.className("form-control"));
        app.authorization().login();
        assertThat(2, equalTo(count - 1));
    }


}
