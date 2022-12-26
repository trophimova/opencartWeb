package ru.opencart.tests;

import org.testng.annotations.*;

public class RegistrationTest extends TestBase {


    @Test
    public void testPositiveRegistration() {
        app.getNavigationHelper().gotoRegPage();
        app.getRegistrationHelper().registration();


    }


}
