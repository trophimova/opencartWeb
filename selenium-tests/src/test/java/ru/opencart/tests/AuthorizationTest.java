package ru.opencart.tests;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import ru.opencart.appmanager.AuthHelper;
import ru.opencart.model.AuthData;
import ru.opencart.readProperties.ConfigProvider;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class AuthorizationTest extends TestBase {

    @AfterMethod
    public void signOut() {
        app.goTo().signOut();
    }


    @Test
    @Owner("Анна Трофимова")
    @Description("Тест проверяет, что после ввода пользователем валидных данных и подтверждения авторизации, пользователь  переходит на страницу своей учетной записи")
    @Link("https://github.com/trophimova/opencartWeb")
    @Severity(SeverityLevel.CRITICAL)
    @Step("Проверка успешной авторизации")
    public void testPositiveAuthorization() {
        app.goTo().goToMainPage();
        app.goTo().goToLoginPage();
        int count = app.authorization().count(By.className("form-group"));
        assertThat(2, equalTo(count));
        app.authorization().login(new AuthData()
                .withEmail(ConfigProvider.USER_EMAIL)
                .withPassword(ConfigProvider.USER_PASSWORD));
        app.authorization().title();
        String nameTitle = app.authorization().getNameTitle();
        assertThat(nameTitle, equalTo(AuthHelper.successAuthTitle));

    }


}
