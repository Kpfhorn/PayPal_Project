package com.mycompany.paypaltest1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Customer {

	private String username;
	private final String url = "jdbc:postgresql://localhost/store";
	private final String user = "postgres";
	private final String password = "Anime4263";

	public void loadDriver() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection connect() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}

	public String getUsername() {
		return username;
	}

	public boolean getUsernameDB(String username) {

		String SQL = "SELECT username FROM customer WHERE username=?";
		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(SQL)) {

			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				this.username = rs.getString("username");
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return true;
	}

	public String getEmail() {
		String email = "";
		String SQL = "SELECT email FROM customer WHERE username=?";
		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(SQL)) {

			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				email = rs.getString("email");
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return email;
	}

	public String getPassword() {
		String password = "";
		String SQL = "SELECT password FROM customer WHERE username=?";
		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(SQL)) {

			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				password = rs.getString("password");
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return password;
	}

	public void replacePswd(String newpassword) {
		String SQL = "UPDATE customer SET password=? WHERE username= ?";
		try (Connection conn = connect();
				PreparedStatement pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {
			pstmt.setString(1, newpassword);
			pstmt.setString(2, username);

			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void replaceEmail(String newemail) {
		String SQL = "UPDATE customer SET email=? WHERE username= ?";
		try (Connection conn = connect();
				PreparedStatement pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {
			pstmt.setString(1, newemail);
			pstmt.setString(2, username);

			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String checkPoints() {
		String SQL = "SELECT points FROM customer WHERE username=?";
		int points = 0;

		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(SQL)) {

			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				points = rs.getInt("points");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return points + "";

	}

}
