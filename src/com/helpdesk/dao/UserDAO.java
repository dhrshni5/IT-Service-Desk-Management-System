package com.helpdesk.dao;

import java.sql.ResultSet;
import com.helpdesk.model.User;
import com.helpdesk.util.DBConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
public class UserDAO {
    public boolean registerUser(User user) {
            String sql =
"INSERT INTO users(name, email, password, role) VALUES (?, ?, ?, ?)";
            try (
    Connection conn = DBConnection.getConnection();
) {
    PreparedStatement ps =
        conn.prepareStatement(sql);
        ps.setString(1, user.getName());
ps.setString(2, user.getEmail());
ps.setString(3, user.getPassword());
ps.setString(4, user.getRole());
int rowsAffected = ps.executeUpdate();
return rowsAffected > 0;
}
catch (SQLException e) {
    e.printStackTrace();
    
}
return false;
}
public User loginUser(String email, String password) {

    String sql = "SELECT * FROM users WHERE email = ? AND password = ?";

    try (
            Connection conn = DBConnection.getConnection();
    ) {
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, email);
        ps.setString(2, password);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            User user = new User(0, sql, sql, sql, sql, null);

            user.setUserId(rs.getInt("user_id"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            user.setRole(rs.getString("role"));
            user.setCreatedAt(rs.getTimestamp("created_at"));

            return user;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return null;
}
}
