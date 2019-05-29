package dao;

import pojo.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDao {
    public List<Item> getItems(String name) {
        List<Item> items = null;
        Connection conn = DatabaseConnection.getConnection();
        String sql = "SELECT * FROM items WHERE user = ?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            rs = pstmt.executeQuery();
            items = new ArrayList<Item>();
            while (rs.next()) {
                Item item = new Item();
                item.setId(rs.getInt("id"));
                item.setStart(rs.getDate("start"));
                item.setEnd(rs.getDate("end"));
                item.setLabel(rs.getString("label"));
                items.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.close(rs);
            DatabaseConnection.close(pstmt);
            DatabaseConnection.close(conn);
        }
        return items;
    }

    public boolean addItem(String name, Item item) {
        boolean ret = false;
        Connection conn = DatabaseConnection.getConnection();
        String sql = "INSERT INTO items(user, start, end, label) VALUES (?, ?, ?, ?)";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setDate(2, new Date(item.getStart().getTime()));
            pstmt.setDate(3, new Date(item.getEnd().getTime()));
            pstmt.setString(4, item.getLabel());
            ret = pstmt.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.close(pstmt);
            DatabaseConnection.close(conn);
        }
        return ret;
    }

    public boolean deleteItem(int id) {
        boolean ret = false;
        Connection conn = DatabaseConnection.getConnection();
        String sql = "DELETE FROM items WHERE id = ?";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ret = pstmt.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.close(pstmt);
            DatabaseConnection.close(conn);
        }
        return ret;
    }

    public boolean removeItem(String name) {
        boolean ret = false;
        Connection conn = DatabaseConnection.getConnection();
        String sql = "DELETE FROM items WHERE user = ?";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            ret = pstmt.executeUpdate() >= 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.close(pstmt);
            DatabaseConnection.close(conn);
        }
        return ret;
    }
}
