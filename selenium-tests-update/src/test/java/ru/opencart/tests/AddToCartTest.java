package ru.opencart.tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import ru.opencart.appmanager.CartHelper;
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
    @Step("Проверка успешной операции добавления в корзину")
    public void testPositiveAddToCart() throws InterruptedException {

        app.goTo().goToCart();
        List<ProductData> before = app.cart().list();
        app.cart().add(new ProductData()
                .withProductName(CartHelper.camera1)
                .withProductGroup(CartHelper.cameras));
        app.cart().add(new ProductData()
                .withProductName(CartHelper.camera2)
                .withProductGroup(CartHelper.cameras));
        app.goTo().goToCart();
        List<ProductData> after = app.cart().list();
        assertThat(before.size() + 2, equalTo(after.size()));



    }
}