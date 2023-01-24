package ru.opencart;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    public static MainPage open() {
        Selenide.open("https://learn-qa.ru/index.php?route=account/login");
        return new MainPage();
    }

    public void loginAs(String email, String password) {
        $("#input-email").click();
        $("input-email").setValue(email);
        $("#input-password").click();
        $("#input-password").setValue(password);
        $("[type='submit']").click();
    }
}
