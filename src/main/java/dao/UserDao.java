package dao;

import pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public User getUser(String name) {
        User user = null;
        Connection conn = DatabaseConnection.getConnection();
        String sql = "SELECT * FROM users WHERE name = ?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.close(rs);
            DatabaseConnection.close(pstmt);
            DatabaseConnection.close(conn);
        }
        return user;
    }

    public boolean insertUser(User user) {
        boolean ret = false;
        Connection conn = DatabaseConnection.getConnection();
        String sql = "INSERT INTO users(name, password) VALUES (?, ?);";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getPassword());
            ret = pstmt.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.close(pstmt);
            DatabaseConnection.close(conn);
        }
        return ret;
    }
}
