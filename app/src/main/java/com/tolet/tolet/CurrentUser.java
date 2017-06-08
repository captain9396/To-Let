package com.tolet.tolet;

public class CurrentUser {
    private static final CurrentUser user = new CurrentUser();

    private String username;
    private String password;


    private CurrentUser() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static CurrentUser getInstance() {
        return user;
    }
}