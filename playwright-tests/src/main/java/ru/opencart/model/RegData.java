package ru.opencart.model;

public class RegData {
    private final String userFirstName;
    private final String userLastName;
    private final String email;
    private final String telephone;
    private final String password;
    private final String passwordConfirm;

    public RegData(String userFirstName, String userLastName, String email, String telephone, String password, String passwordConfirm) {
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.email = email;
        this.telephone = telephone;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
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

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    @Override
    public String toString() {
        return "RegData{" +
                "userFirstName='" + userFirstName + '\'' +
                ", userLastName='" + userLastName + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", password='" + password + '\'' +
                ", passwordConfirm='" + passwordConfirm + '\'' +
                '}';
    }
}
