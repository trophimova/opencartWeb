package ru.opencart.model;

import java.util.Objects;

public class RegData {
    private String userFirstname;
    private String userLastname;
    private String email;
    private String telephone;
    private String password;

    private String confirmPassword;

    public RegData withUserFirstname(String userFirstname) {
        this.userFirstname = userFirstname;
        return this;
    }

    public RegData withUserLastname(String userLastname) {
        this.userLastname = userLastname;
        return this;
    }

    public RegData withEmail(String email) {
        this.email = email;
        return this;
    }

    public RegData withTelephone(String telephone) {
        this.telephone = telephone;
        return this;
    }

    public RegData withPassword(String password) {
        this.password = password;
        return this;
    }

    public RegData withConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }


//    public RegData(String userFirstname, String userLastname, String email, String telephone, String password, String confirmPassword) {
//        this.userFirstname = userFirstname;
//        this.userLastname = userLastname;
//        this.email = email;
//        this.telephone = telephone;
//        this.password = password;
//        this.confirmPassword = confirmPassword;
//    }

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

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        RegData regData = (RegData) o;
//        return Objects.equals(userFirstname, regData.userFirstname) && Objects.equals(userLastname, regData.userLastname) && Objects.equals(email, regData.email) && Objects.equals(telephone, regData.telephone) && Objects.equals(password, regData.password) && Objects.equals(confirmPassword, regData.confirmPassword);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(userFirstname, userLastname, email, telephone, password, confirmPassword);
//    }
//
//    @Override
//    public String toString() {
//        return "RegData{" +
//                "userFirstname='" + userFirstname + '\'' +
//                ", userLastname='" + userLastname + '\'' +
//                ", email='" + email + '\'' +
//                ", telephone='" + telephone + '\'' +
//                ", password='" + password + '\'' +
//                ", confirmPassword='" + confirmPassword + '\'' +
//                '}';
//    }
}
