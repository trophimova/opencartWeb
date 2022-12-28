package ru.opencart.model;

public class AuthData {
    private String email;
    private String password;

    public AuthData withEmail(String email) {
        this.email = email;
        return this;
    }

    public AuthData withPassword(String password) {
        this.password = password;
        return this;
    }


    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
