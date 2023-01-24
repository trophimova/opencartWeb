package ru.opencart.model;





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

    @Override
    public String toString() {
        return "RegData{" +
                "userFirstname='" + userFirstname + '\'' +
                ", userLastname='" + userLastname + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }
}
