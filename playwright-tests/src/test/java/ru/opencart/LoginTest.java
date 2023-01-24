package ru.opencart;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test
    public void loginWithValidCredentials() {
        page.navigate("https://learn-qa.ru/index.php?route=account/login");
        page.fill("[id=input-email]", "tegg88st@mail.ru");
        page.fill("[id=input-password]", "123456");
        page.click("[type=submit]");
    }


}
