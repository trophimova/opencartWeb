package ru.opencart.tests;

import org.testng.annotations.*;

public class RegistrationTest extends TestBase {


    @Test
    public void testPositiveRegistration() {
        app.getRegistrationHelper().registration();
        //здесь должна быть проверка успешной регистрации

    }
/*
    @Test
    public void testAddToCart() {
        app.registration();
        app.wd.get("https://learn-qa.ru/index.php?route=product/category&path=33");
    }
*/

}
