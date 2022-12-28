package ru.opencart.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthorizationTest extends TestBase {


    @Test
    public void testPositiveAuthorization() {
//        app.getNavigationHelper().gotoRegPage();
//        app.getRegistrationHelper().registration();
        app.goTo().loginPage();
        int count = app.authorization().count(By.className("form-control"));
        app.authorization().login();
        Assert.assertEquals(count - 1, 2);


    }


}
