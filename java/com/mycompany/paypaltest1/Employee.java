package com.mycompany.paypaltest1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

public class Employee {

	private int id;
	private final String url = "jdbc:postgresql://localhost/store";
	private final String user = "postgres";
	private final String password = "Anime4263";
	private int idTimestamp;

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

	public int getID() {
		return id;
	}

	public boolean getIDDB(int ID) {

		String SQL = "SELECT id FROM employee WHERE id=?";
		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(SQL)) {

			pstmt.setInt(1, ID);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				id = rs.getInt("id");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public String getPassword() {
		String password = "";
		String SQL = "SELECT password FROM employee WHERE id=?";
		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(SQL)) {

			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				password = rs.getString("password");
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return password;
	}

	public void clockIn() {
		String SQL = "INSERT INTO timetable  (clockindate,clockintime,employeeid,clockouttime) VALUES(?,?,?,?)";
		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(SQL)) {
			long millis = System.currentTimeMillis();
			Date date = new Date(millis);
			Time timestamp = new Time(millis);
			
			

			pstmt.setDate(1, date);
			pstmt.setString(2, timestamp.toString());
			pstmt.setInt(3, id);
			pstmt.setString(4, "0");
			
			pstmt.executeUpdate();
			timeStampID();
			
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void clockOut() {
		String SQL = "UPDATE timetable SET clockoutdate=?, clockouttime=? WHERE employeeid=? AND id=?";
		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(SQL)) {
			long millis = System.currentTimeMillis();
			Date date = new Date(millis);
			Time timestamp = new Time(millis);
			
			timeStampID();

			pstmt.setDate(1, date);
			pstmt.setString(2, timestamp.toString());
			pstmt.setInt(3, id);
			pstmt.setInt(4, idTimestamp);
			
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	private void timeStampID() {
		String SQL = "SELECT id FROM timetable WHERE employeeid=? and clockouttime=?";
		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(SQL)) {
			pstmt.setInt(1, id);
			pstmt.setString(2, "0");
			ResultSet rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				this.idTimestamp=rs.getInt("id");
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	public boolean isValidClockIn() {
		String SQL ="SELECT clockintime FROM timetable WHERE employeeid=? AND id=? AND clockouttime=?";
		String clockIn=null;
		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(SQL)){
			timeStampID();
			pstmt.setInt(1, id);
			pstmt.setInt(2, idTimestamp);
			pstmt.setString(3, "0");
			
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next()) {
				clockIn=rs.getString("clockintime");
			}
			
			if(clockIn==null) {
				return true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
}
