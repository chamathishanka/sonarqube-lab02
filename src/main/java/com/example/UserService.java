package main.java.com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserService {

    public void findUser(String username) throws SQLException {
        String query = "SELECT name FROM users WHERE name = ?";
        try (Connection conn = getConnection();
             PreparedStatement st = conn.prepareStatement(query)) {
            st.setString(1, username);
            st.executeQuery();
        }
    }

    public void deleteUser(String username) throws SQLException {
        String query = "DELETE FROM users WHERE name = ?";
        try (Connection conn = getConnection();
             PreparedStatement st = conn.prepareStatement(query)) {
            st.setString(1, username);
            st.executeUpdate();
        }
    }

    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost/db";
        String user = "root";
        String password = System.getenv("DB_PASSWORD");
        return DriverManager.getConnection(url, user, password);
    }
}