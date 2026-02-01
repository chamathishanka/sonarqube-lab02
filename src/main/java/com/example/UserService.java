package main.java.com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class UserService {

    // SECURITY ISSUE: Hardcoded credentials
    private String password = "admin123";

    // VULNERABILITY: SQL Injection - FIXED with PreparedStatement
    public void findUser(String username) throws SQLException {

        try (Connection conn =
            DriverManager.getConnection("jdbc:mysql://localhost/db",
                    "root", password);
             PreparedStatement pst = conn.prepareStatement(
                "SELECT * FROM users WHERE name = ?")) {

            pst.setString(1, username);
            pst.executeQuery();
        }
    }

    // SMELL: Unused method
    public void notUsed() {
        System.out.println("I am never called");
    }

    // SQL injection - FIXED with PreparedStatement
    public void deleteUser(String username) throws SQLException {
        try (Connection conn =
            DriverManager.getConnection("jdbc:mysql://localhost/db",
                    "root", password);
             PreparedStatement pst = conn.prepareStatement(
                "DELETE FROM users WHERE name = ?")) {
            pst.setString(1, username);
            pst.execute();
        }
    }

}
