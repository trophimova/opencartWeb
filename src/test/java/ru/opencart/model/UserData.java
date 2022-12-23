package ru.opencart.model;

public class UserData {
    private final String userFirstname;
    private final String userLastname;
    private final String email;
    private final String telephone;
    private final String password;
    private final String confirmPassword;

    public UserData(String userFirstname, String userLastname, String email, String telephone, String password, String confirmPassword) {
        this.userFirstname = userFirstname;
        this.userLastname = userLastname;
        this.email = email;
        this.telephone = telephone;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public String getUserFirstname() {
        return userFirstname;
    }

    public String getUserLastname() {
        return userLastname;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }
}
