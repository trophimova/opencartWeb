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

public class RegistrationTest extends TestBase {

    @AfterMethod
    public void signOut() {
        app.goTo().signOut();
    }

    @Test
    @Owner("Анна Трофимова")
    @Description("Тест проверяет, что после ввода пользователем валидных данных и подтверждения регистрации, пользователь видит сообщение об успешной регистрации")
    @Link("https://github.com/trophimova/opencartWeb")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка успешной регистрации")
    @Step("Проверка успешной регистрации")
    public void registerWithValidData() {

        app.goTo().goToMainPage();
        app.goTo().goToRegPage();
        Faker data = new Faker();
        String password = data.internet().password();

        app.registration().setValidRegistration(new RegData(data.name().firstName(), data.name().lastName(), data.internet().emailAddress(),
                data.phoneNumber().cellPhone(), password, password));
        String nameTitle = app.registration().getTitleName();
        assertThat(nameTitle, equalTo(RegistrationHelper.successRegMessage));
    }

}
