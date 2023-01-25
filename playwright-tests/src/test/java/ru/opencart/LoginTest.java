package ru.opencart;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginWithValidCredentials() {
        app.goTo().goToMainPage();
        app.goTo().goToLoginPage();
        app.authorization().login();
        Assert.assertEquals(app.authorization().getTitleName(), app.authorization().successLoginTitle );
    }




}
