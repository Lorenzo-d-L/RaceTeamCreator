package com.lorenzo.raceteamcreator_bp02.classes;

import com.lorenzo.raceteamcreator_bp02.screens.LoginScreen;
import javafx.scene.control.Alert;

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
    public void registerUser(String email, String password) {
        try {
            String query = "INSERT INTO login (email, password) VALUES ('" + email + "', '" + password + "')";
            stm.executeUpdate(query);
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Email already exists");
            alert.show();
        }
    }

    public boolean loginUser() {
        try {
            String query = "SELECT * FROM login WHERE email = '" + email + "' AND password = '" + password + "'";
            return stm.executeQuery(query).next();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Email or password is incorrect");
            alert.show();
            return false;
        }
    }

    public void setEmail(Object email) {
        this.email = email;
    }

    public void setPassword(Object password) {
        this.password = password;
    }
}




