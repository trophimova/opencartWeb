package ru.opencart.tests;

import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import ru.opencart.appmanager.AuthHelper;
import ru.opencart.model.AuthData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.opencart.readProperties.ConfigProvider.USER_EMAIL;
import static ru.opencart.readProperties.ConfigProvider.USER_PASSWORD;

public class LoginTest extends TestBase {

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
    public void loginWithValidCredentials() {
        app.goTo().goToMainPage();
        app.goTo().goToLoginPage();
        app.authorization().login(new AuthData(USER_EMAIL, USER_PASSWORD));
        String nameTitle = app.authorization().getTitleName();
        assertThat(AuthHelper.successLoginTitle, equalTo(nameTitle));
    }

}
