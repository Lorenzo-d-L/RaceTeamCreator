package com.lorenzo.raceteamcreator_bp02.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private Connection conn;

    // Connect to the database
    public Database() {
        try{
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raceteamcreator", "root", "");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Get the connection
    public Connection getConn() {
        return conn;
    }
}
