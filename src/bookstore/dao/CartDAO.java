package bookstore.dao;

import bookstore.controller.DBConnection;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class CartDAO {

    public static Map<String, Integer> getCartItems(String userId) {
        Map<String, Integer> items = new HashMap<>();
        String sql = "SELECT BOOK_ID, QUANTITY FROM cartdb WHERE USER_ID = ?";
        try (Connection conn = DBConnection.makeConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, userId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                items.put(rs.getString("BOOK_ID"), rs.getInt("QUANTITY"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    public static void addOrUpdateItem(String userId, String bookId, int quantity) {
        String sql = "MERGE INTO cartdb c USING dual ON (c.USER_ID = ? AND c.BOOK_ID = ?) " +
                     "WHEN MATCHED THEN UPDATE SET QUANTITY = c.QUANTITY + ? " +
                     "WHEN NOT MATCHED THEN INSERT (USER_ID, BOOK_ID, QUANTITY) VALUES (?, ?, ?)";
        // String sql = "insert into cartdb (user_id, book_id, quantity) values(?, ?, ?)";
        try (Connection conn = DBConnection.makeConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, userId);
            stmt.setString(2, bookId);
            stmt.setInt(3, quantity);
            stmt.setString(4, userId);
            stmt.setString(5, bookId);
            stmt.setInt(6, quantity);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateQuantity(String userId, String bookId, int quantity) {
        if (quantity <= 0) {
            removeItem(userId, bookId);
            return;
        }
        String sql = "UPDATE cartdb SET QUANTITY = ? WHERE USER_ID = ? AND BOOK_ID = ?";
        try (Connection conn = DBConnection.makeConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, quantity);
            stmt.setString(2, userId);
            stmt.setString(3, bookId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void removeItem(String userId, String bookId) {
        String sql = "DELETE FROM cartdb WHERE USER_ID = ? AND BOOK_ID = ?";
        try (Connection conn = DBConnection.makeConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, userId);
            stmt.setString(2, bookId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void clearCart(String userId) {
        String sql = "DELETE FROM cartdb WHERE USER_ID = ?";
        try (Connection conn = DBConnection.makeConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, userId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
