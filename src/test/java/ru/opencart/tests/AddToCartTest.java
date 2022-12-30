package ru.opencart.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.opencart.model.ProductData;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddToCartTest extends TestBase {

    @Test
    public void testAddToCart() {
        app.goTo().gotoCart();
        List<ProductData> before = app.cart().list();

        app.cart().add(new ProductData()
                .withProductName(".product-layout:nth-child(1) .caption a")
                .withProductGroup("li:nth-child(7) > a"));
        app.cart().add(new ProductData()
                .withProductName(".product-layout:nth-child(2) .caption a")
                .withProductGroup("li:nth-child(7) > a"));
        app.goTo().gotoCart();
        List<ProductData> after = app.cart().list();
        //Assert.assertEquals(after.size(), before.size() + 2);
        assertThat(before.size() + 2, equalTo(after.size()));



    }
}
