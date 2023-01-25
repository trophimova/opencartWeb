package ru.opencart;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginWithValidCredentials() {
        goTo().goToMainPage();
        goTo().goToLoginPage();
        authorization().login();
        Assert.assertEquals(authorization().getTitleName(),authorization().successLoginTitle );
    }




}
