package ru.opencart.tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import ru.opencart.model.ProductData;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.opencart.appmanager.CartHelper.*;

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
        app.cart().add(new ProductData().withProductGroup(cameras).withProductName(camera1));
        app.cart().add(new ProductData().withProductGroup(cameras).withProductName(camera2));
        app.goTo().goToCart();
        List<ProductData> after = app.cart().list();
        assertThat(after.size(), equalTo(before.size() + 2));

    }



}
