package com.example.mobileapp;

public class AccountClass {

    private String username;
    private String email;

    private String password;
    private String type;

    public AccountClass(){

    }

    public AccountClass(String username, String email, String password, String type) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.type = type;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getType() {
        return type;
    }
}
