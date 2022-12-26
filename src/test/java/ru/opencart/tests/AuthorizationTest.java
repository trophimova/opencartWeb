package ru.opencart.tests;

import org.testng.annotations.Test;

public class AuthorizationTest extends TestBase {


    @Test
    public void testPositiveAuthorization() {
        app.getNavigationHelper().gotoRegPage();
        app.getRegistrationHelper().registration();
        app.getNavigationHelper().gotoLoginPage();
        app.getSessionHelper().login();



    }


}
