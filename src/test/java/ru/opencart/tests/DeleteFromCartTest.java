package ru.opencart.tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.opencart.model.ProductData;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class DeleteFromCartTest extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().goToCart();
        if (app.cart().list().size() == 0) {
            app.cart().add(new ProductData()
                    .withProductName(".product-layout:nth-child(1) .caption a")
                    .withProductGroup("li:nth-child(7) > a"));
            app.cart().add(new ProductData()
                    .withProductName(".product-layout:nth-child(2) .caption a")
                    .withProductGroup("li:nth-child(7) > a"));
            app.goTo().goToCart();
        }
    }

    @Test
    @Owner("Анна Трофимова")
    @Description("Тест проверяет, что при удалении 1 товара из корзины, количество товара в корзине уменьшается на 1")
    @Link("https://github.com/trophimova/opencartWeb")
    @Severity(SeverityLevel.CRITICAL)
    @Step("Проверка успешной операции удаления из корзины")
    public void testPositiveDeleteFromCart() throws InterruptedException {

        List<ProductData> before = app.cart().list();
        int index = before.size() - 1;
        app.cart().delete(index);
        Thread.sleep(1000l);
        List<ProductData> after = app.cart().list();
        Assert.assertEquals(after.size(), index);

        before.remove(index);
        assertThat(after, equalTo(before));


    }
}
