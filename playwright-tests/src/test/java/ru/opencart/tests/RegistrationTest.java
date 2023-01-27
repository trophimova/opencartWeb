package ru.opencart.tests;

import com.github.javafaker.Faker;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.opencart.appmanager.RegistrationHelper;
import ru.opencart.model.RegData;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.opencart.readProperties.ConfigProvider.REG_DATA_COUNT;

public class RegistrationTest extends TestBase {

    @DataProvider
    public Iterator<Object[]> validRegistrationData() {
        Faker data = new Faker();
        String password = data.internet().password();
        List<Object[]> list = new ArrayList<>();
        for (int i = 0; i < REG_DATA_COUNT; i++) {
            list.add(new Object[] {new RegData(data.name().firstName(),
                    data.name().lastName(),
                    data.internet().emailAddress(),
                    data.phoneNumber().cellPhone(),
                    password,
                    password)});
        }
        return list.iterator();
    }

    @AfterMethod
    public void signOut() {
        app.goTo().signOut();
    }

    @Test(dataProvider = "validRegistrationData")
    @Owner("Анна Трофимова")
    @Description("Тест проверяет, что после ввода пользователем валидных данных и подтверждения регистрации, пользователь видит сообщение об успешной регистрации")
    @Link("https://github.com/trophimova/opencartWeb")
    @Severity(SeverityLevel.CRITICAL)
    @Step("Проверка успешной регистрации")
    public void registerWithValidData(RegData reg) {
        app.goTo().goToMainPage();
        app.goTo().goToRegPage();
        app.registration().setValidRegistration(reg);
        String nameTitle = app.registration().getTitleName();
        assertThat(nameTitle, equalTo(RegistrationHelper.successRegMessage));
    }

}
