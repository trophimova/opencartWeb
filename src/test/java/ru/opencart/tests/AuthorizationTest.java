package ru.opencart.tests;

import org.testng.annotations.Test;

public class AuthorizationTest extends TestBase {


    @Test
    public void testPositiveAuthorization() {
        app.getRegistrationHelper().registration();
        app.gotoLoginPage();
        app.login();

        //здесь должна быть проверка успешной авторизации

    }


}
