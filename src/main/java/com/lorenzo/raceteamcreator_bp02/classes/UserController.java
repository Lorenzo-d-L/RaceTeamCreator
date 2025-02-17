package com.lorenzo.raceteamcreator_bp02.classes;

import com.lorenzo.raceteamcreator_bp02.screens.LoginScreen;
import javafx.scene.control.Alert;

import java.sql.SQLException;
import java.sql.Statement;

public class UserController {
    private User user;
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
    public void registerUser( String email, String password) {
        user = new User(0, email, password);
        try {
            String query = "INSERT INTO login (email, password) VALUES ('" + user.getEmail() + "', '" + user.getPassword() + "')";
            stm.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean loginUser() {
        user = new User(0, user.getEmail(), user.getPassword());
        try {
            String query = "SELECT * FROM login WHERE email = '" + user.getEmail() + "' AND password = '" + user.getPassword() + "'";
            return stm.executeQuery(query).next();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public void setEmail(String email) {
        if (user == null) {
            user = new User(0, email, "");
        } else {
            user.setEmail(email);
        }
    }

    public void setPassword(String password) {
        if (user == null) {
            user = new User(0, "", password);
        } else {
            user.setPassword(password);
        }
    }

    public User getUser() {
        return user;
    }
}




