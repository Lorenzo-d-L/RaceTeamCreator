package com.lorenzo.raceteamcreator_bp02.classes;

import java.security.MessageDigest;

public class User {
    private int userId;
    private String email;
    private String password;

    // Constructor for the user
    public User(int userId, String username, String password) {
        this.userId = userId;
        this.email = username;
        this.password = password;
    }

    // Below are the getters for the user
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

}
