package ru.opencart.generators;

import com.github.javafaker.Faker;


public class TestDataFaker {

    Faker data = new Faker();

    public String firstName() {
        return data.name().firstName();
    }

    public String lastName() {
        return data.name().lastName();
    }

    public String email() {
        return data.internet().emailAddress();
    }

    public String cellPhone() {
        return data.phoneNumber().cellPhone();
    }

    public String password() {
        return data.internet().password();
    }

}
