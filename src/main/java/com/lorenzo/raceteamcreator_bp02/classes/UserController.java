package com.lorenzo.raceteamcreator_bp02.classes;

import com.lorenzo.raceteamcreator_bp02.screens.LoginScreen;

import java.sql.SQLException;
import java.sql.Statement;

public class UserController {
    private Object email;
    private Object password;
    Database db = new Database();
    Statement stm;

    public UserController(Database db) {
        this.db = db;
        try {
            this.stm = db.getConn().createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
//    public void registerUser(LoginScreen loginScreen) {
//        String email = LoginScreen.getUsername();
//        String password = LoginScreen.getPassword();
//        try {
//            stm.executeUpdate("INSERT INTO login (email, password) VALUES ('" + email + "', '" + password + "')");
//            System.out.println("User registered");
//        } catch (Exception e) {
//            System.out.println("Error: " + e.getMessage());
//        }
//    }

    public boolean loginUser() {
        try {
            return stm.execute("SELECT * FROM login WHERE email = '" + email + "' AND password = '" + password + "'");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
}




