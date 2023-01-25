package ru.opencart.model;

public class AuthData {
    private final String email;
    private final String password;

    public AuthData(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
