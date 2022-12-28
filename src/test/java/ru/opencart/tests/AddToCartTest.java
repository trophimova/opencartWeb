package ru.opencart.tests;

import org.testng.annotations.Test;

public class AddToCartTest extends TestBase {

    @Test(enabled = false)
    public void testPositiveAddToCart() {
        app.goTo().gotoProductPage();
        app.cart().addToCart();


    }
}
