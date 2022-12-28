package ru.opencart.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

public class RegistrationTest extends TestBase {


    @Test
    public void testPositiveRegistration() {
        app.goTo().regPage();
//        List<RegData> count = app.getRegistrationHelper().getRegList();

        int count = app.registration().count(By.className("form-control"));
        app.registration().registration();
        Assert.assertEquals(count - 1, 6);


    }


}
