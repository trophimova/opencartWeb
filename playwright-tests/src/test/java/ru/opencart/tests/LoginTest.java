package ru.opencart.tests;

import com.github.javafaker.Faker;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import ru.opencart.appmanager.AuthHelper;
import ru.opencart.appmanager.RegistrationHelper;
import ru.opencart.model.AuthData;
import ru.opencart.model.RegData;
import ru.opencart.readProperties.ConfigProvider;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

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
    @DisplayName("Проверка успешной авторизации")
    @Step("Проверка успешной авторизации")
    public void loginWithValidCredentials() {
        app.goTo().goToMainPage();
        app.goTo().goToLoginPage();
        app.authorization().login(new AuthData(ConfigProvider.USER_EMAIL, ConfigProvider.USER_PASSWORD));
        String nameTitle = app.authorization().getTitleName();
        assertThat(AuthHelper.successLoginTitle, equalTo(nameTitle));
    }

}
