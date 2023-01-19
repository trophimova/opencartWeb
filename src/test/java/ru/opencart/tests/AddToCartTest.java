package ru.opencart.tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import ru.opencart.model.ProductData;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class AddToCartTest extends TestBase {

    @Test
    @Owner("Анна Трофимова")
    @Description("Тест проверяет, что при добавлении 2х товаров в корзину, количество товара в корзине увеличивается на 2")
    @Link("https://github.com/trophimova/opencartWeb")
    @Severity(SeverityLevel.CRITICAL)
    public void testPositiveAddToCart() throws InterruptedException {
        app.goTo().gotoMainPage();
        app.goTo().gotoCart();
        Thread.sleep(1000l);
        List<ProductData> before = app.cart().list();
        app.cart().add(new ProductData()
                .withProductName(".product-layout:nth-child(1) .caption a")
                .withProductGroup("li:nth-child(7) > a"));
        Thread.sleep(1000l);
        app.cart().add(new ProductData()
                .withProductName(".product-layout:nth-child(2) .caption a")
                .withProductGroup("li:nth-child(7) > a"));
        app.goTo().gotoCart();
        List<ProductData> after = app.cart().list();
        assertThat(before.size() + 2, equalTo(after.size()));



    }
}
