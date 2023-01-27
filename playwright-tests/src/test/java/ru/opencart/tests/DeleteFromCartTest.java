package ru.opencart.tests;

import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.opencart.appmanager.CartHelper;
import ru.opencart.model.ProductData;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.opencart.appmanager.CartHelper.*;

public class DeleteFromCartTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        app.goTo().goToCart();
        if (app.cart().list().size() == 0) {
            app.cart().add(new ProductData().withProductGroup(cameras).withProductName(camera1));
            app.cart().add(new ProductData().withProductGroup(cameras).withProductName(camera2));
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
        app.goTo().goToCart();
        List<ProductData> after = app.cart().list();
        assertThat(after.size(), equalTo(index));
        before.remove(index);
        assertThat(after, equalTo(before));
    }
}
