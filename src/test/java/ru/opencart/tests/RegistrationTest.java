package ru.opencart.tests;

import org.openqa.selenium.By;
import org.testng.annotations.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class RegistrationTest extends TestBase {


    @Test
    public void testPositiveRegistration() {

        app.goTo().gotoRegPage();
        int count = app.registration().count(By.className("form-control"));
        app.registration().registration();
        assertThat(6, equalTo(count - 1));
    }


}
