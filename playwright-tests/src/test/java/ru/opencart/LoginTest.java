package ru.opencart;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.opencart.model.AuthData;
import ru.opencart.readProperties.ConfigProvider;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class LoginTest extends BaseTest {

    @Test
    public void loginWithValidCredentials() {
        app.goTo().goToMainPage();
        app.goTo().goToLoginPage();
        app.authorization().login(new AuthData(ConfigProvider.USER_EMAIL, ConfigProvider.USER_PASSWORD));
        assertThat(AuthHelper.successLoginTitle, equalTo(app.authorization().getTitleName()));
    }




}
