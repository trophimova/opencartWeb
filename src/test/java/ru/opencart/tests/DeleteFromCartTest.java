package ru.opencart.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.opencart.model.ProductData;

public class DeleteFromCartTest extends TestBase{

    @Test
    public void testDeleteFromCart() {
        app.goTo().gotoCart();
        if (! app.cart().isThereAProduct()) {
            app.cart().addToCart(new ProductData(".product-layout:nth-child(1) .caption a", By.cssSelector("li:nth-child(7) > a")));
            app.cart().addToCart(new ProductData(".product-layout:nth-child(2) .caption a", By.cssSelector("li:nth-child(7) > a")));
            app.goTo().gotoCart();
        }
        int before = app.cart().count(By.xpath("//input[@size = '1']"));



        app.cart().deleteFromCart(0);
        int after = app.cart().count(By.xpath("//input[@size = '1']"));
        Assert.assertEquals(after, before - 1);

    }
}
