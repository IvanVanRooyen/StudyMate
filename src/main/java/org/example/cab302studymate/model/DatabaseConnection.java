package org.example.cab302studymate.model;

// Imports
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Connection to database
public class DatabaseConnection {
    private static Connection instance = null;

    private DatabaseConnection() {
        // Get current connection instance
        String url = "jdbc:sqlite:database.db";
        try {
            instance = DriverManager.getConnection(url);
        } catch (SQLException sqlEx) {
            System.err.println(sqlEx);
        }
    }
    // If connection does not exist, create one
    public static Connection getInstance() {
        if (instance == null) {
            new DatabaseConnection();
        }
        return instance;
    }
}
