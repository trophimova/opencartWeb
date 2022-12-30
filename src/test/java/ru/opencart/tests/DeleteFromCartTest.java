package ru.opencart.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.opencart.model.ProductData;

import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class DeleteFromCartTest extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().gotoCart();
        if (app.cart().list().size() == 0) {
            app.cart().add(new ProductData()
                    .withProductName(".product-layout:nth-child(1) .caption a")
                    .withProductGroup("li:nth-child(7) > a"));
            app.cart().add(new ProductData()
                    .withProductName(".product-layout:nth-child(2) .caption a")
                    .withProductGroup("li:nth-child(7) > a"));
            app.goTo().gotoCart();
        }
    }

    @Test
    public void testDeleteFromCart() {

        List<ProductData> before = app.cart().list();
        int index = before.size() - 1;
        app.cart().delete(index);
        List<ProductData> after = app.cart().list();
        Assert.assertEquals(after.size(), index);

        before.remove(index);
        //Assert.assertEquals(before, after);
        assertThat(after, equalTo(before));


    }
}
