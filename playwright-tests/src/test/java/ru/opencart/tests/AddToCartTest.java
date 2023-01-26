package ru.opencart.tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import ru.opencart.appmanager.CartHelper;
import ru.opencart.appmanager.ProductData;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddToCartTest extends TestBase {

    @Test
    @Owner("Анна Трофимова")
    @Description("Тест проверяет, что при добавлении 2х товаров в корзину, количество товара в корзине увеличивается на 2")
    @Link("https://github.com/trophimova/opencartWeb")
    @Severity(SeverityLevel.CRITICAL)
    @Step("Проверка успешной операции добавления в корзину")
    public void testPositiveAddToCart() {
        app.goTo().goToCart();
        List<ProductData> before = app.cart().getSize();
        app.cart().add(new ProductData(CartHelper.cameras, CartHelper.camera1));
        app.cart().add(new ProductData(CartHelper.cameras, CartHelper.camera2));
        app.goTo().goToCart();
        List<ProductData> after = app.cart().getSize();
        assertThat(before.size() + 2, equalTo(after.size()));

    }



}
