package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.TransactionModel;
import com.model.UserModel;
import com.utility.Utility;

public class UserDao {
	private Connection conn;

	public UserDao() throws SQLException {
		this.conn = Utility.getConnection();
	}

	public boolean registerUser(UserModel u) throws SQLException {
		String sql = "INSERT INTO usersb (username, password) VALUES (?, ?)";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, u.getUsername());
			stmt.setString(2, u.getPassword());
			return stmt.executeUpdate() > 0;
		}
	}

	public boolean validateUser(String username, String password) throws SQLException {
		String sql = "SELECT * FROM usersb WHERE username = ? AND password = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, username);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			return rs.next();

		}

	}

	public double getBalance(String username) throws SQLException {
		String sql = "SELECT balance FROM usersb WHERE username = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getDouble("balance");
			}
			return 0;
		}
	}

	public boolean updateBalance(String username, double amount) throws SQLException {
		String sql = "UPDATE usersb SET balance = ? WHERE username = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setDouble(1, amount);
			stmt.setString(2, username);
			return stmt.executeUpdate() > 0;
		}
	}

	public int getUserId(String username) throws SQLException {
		String sql = "SELECT id FROM usersb WHERE username = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getInt("id");
			}
		}
		return -1; // user not found
	}

	public void logTransaction(String username, String type, double amount) throws SQLException {
		int userId = getUserId(username); // get the ID from username
		String sql = "INSERT INTO transactions (user_id, type, amount) VALUES (?, ?, ?)";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, userId);
			stmt.setString(2, type);
			stmt.setDouble(3, amount);
			stmt.executeUpdate();
		}
	}

	public List<TransactionModel> getTransactions(String username) throws SQLException {
		List<TransactionModel> list = new ArrayList<>();

		// First get user_id from username
		int userId = getUserId(username);
		if (userId == -1) {
			// user not found, return empty list or handle accordingly
			return list;
		}

		String sql = "SELECT * FROM transactions WHERE user_id = ? ORDER BY date DESC";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, userId);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				TransactionModel tx = new TransactionModel();
				tx.setType(rs.getString("type"));
				tx.setAmount(rs.getDouble("amount"));
				tx.setTimestamp(rs.getTimestamp("date")); // note column name 'date'
				list.add(tx);
			}
		}
		return list;
	}
}
