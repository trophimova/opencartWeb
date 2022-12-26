package ru.opencart.tests;

import org.testng.annotations.Test;

public class AddToCartTest extends TestBase {

    @Test
    public void testPositiveAddToCart() {
        app.getNavigationHelper().gotoRegPage();
        app.getRegistrationHelper().registration();
        //app.getNavigationHelper().gotoLoginPage();
        //app.getSessionHelper().login();
        app.getNavigationHelper().gotoProductPage();
        //app.getCartHelper().addToCart();


    }
}
