package ru.opencart.tests;

import org.testng.annotations.Test;
import ru.opencart.MainPage;

public class TestLoginSelenide {

    @Test
    public void userCanLoginWithValidCredentials() {
        MainPage.open()
                .loginAs("tegg88st@mail.ru", "123456");
    }
}
