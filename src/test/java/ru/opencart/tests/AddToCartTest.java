package ru.opencart.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTest extends TestBase {

    @Test
    public void testAddToCart() {
        app.goTo().gotoCart();
        int before = app.cart().count(By.xpath("//input[@size = '1']"));
        app.goTo().gotoProductPage();
        app.cart().addToCart();
        app.goTo().gotoCart();
        int after = app.cart().count(By.xpath("//input[@size = '1']"));
        Assert.assertEquals(after, before + 2);

    }
}
