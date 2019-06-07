package com.example.rfmcafe.model;

/**
 * Created by 991435278: Ryle Cheyene Macaraig
 * on 2019-06-05.
 */

//model
public class Login {

    //refer info from email and password
    String email, password;

    public Login(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Login{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
