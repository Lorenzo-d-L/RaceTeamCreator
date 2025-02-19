package com.lorenzo.raceteamcreator_bp02.classes;

import com.lorenzo.raceteamcreator_bp02.screens.LoginScreen;
import javafx.scene.control.Alert;

import java.sql.SQLException;
import java.sql.Statement;

public class UserController {
    private User user;
    Database db = new Database();
    Statement stm;

    // Constructor for the user controller
    public UserController(Database db) {
        this.db = db;
        try {
            this.stm = db.getConn().createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Register the user
    // Check if the email and password are not empty
    // Check if the email contains an @ and a .
    // Create a new user with the email and password
    // Insert the email and password into the database
    public void registerUser( String email, String password) {
        if (email.isEmpty() || password.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Empty fields");
            alert.setContentText("Please fill in all fields");
            alert.showAndWait();
            return;
        }

        if (!email.contains("@") && !email.contains(".")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid email");
            alert.setContentText("Please enter a valid email");
            alert.showAndWait();
            return;
        }
        user = new User(0, email, password);
        try {
            String query = "INSERT INTO login (email, password) VALUES ('" + user.getEmail() + "', '" + user.getPassword() + "')";
            stm.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Login the user
    // Check if the email and password are not empty
    // Check if the email and password are in the database
    // If all is correct return true and login the user
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

    // Get the email
    public void setEmail(String email) {
        if (user == null) {
            user = new User(0, email, "");
        } else {
            user.setEmail(email);
        }
    }

    // Get the password
    public void setPassword(String password) {
        if (user == null) {
            user = new User(0, "", password);
        } else {
            user.setPassword(password);
        }
    }
}




