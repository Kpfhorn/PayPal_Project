package com.mycompany.paypaltest1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Write {
	private final String url = "jdbc:postgresql://localhost/store";
	private final String user = "postgres";
	private final String password = "Anime4263";


	public void write(String username, String password, String email) {
		String SQL = "INSERT INTO customer (username,password,email,points) VALUES(?,?,?,?)";
		try (Connection conn = connect();
				PreparedStatement pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {

			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setString(3, email);
			pstmt.setInt(4,0);

			pstmt.executeUpdate();
// all shaded code might need depending on what we do
			/*if (affectedRows > 0) {
				try (ResultSet rs = pstmt.getGeneratedKeys()) {
					if (rs.next()) {
						id = rs.getLong(0);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}*/
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/* 
		 * try { FileWriter writer = new FileWriter("AccountFile.txt", true);
		 * BufferedWriter bw = new BufferedWriter(writer);
		 * 
		 * bw.write(username); bw.newLine(); bw.write(password); bw.newLine();
		 * bw.write(email); bw.newLine();
		 * 
		 * bw.close(); } catch (IOException e) { e.printStackTrace(); }
		 */
	}
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

	public void account(String name, String address, String birthday, String email, String phonenum, String ssn,
			String license) {
		String SQL = "INSERT INTO employee (name,address,birthday,email,phonenumber,ssn,licensenumber) VALUES(?,?,?,?,?,?,?)";
		try (Connection conn = connect();
				PreparedStatement pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {

			pstmt.setString(1, name);
			pstmt.setString(2, address);
			pstmt.setString(3, birthday);
			pstmt.setString(4, email);
			pstmt.setString(5, phonenum);
			pstmt.setString(6, ssn);
			pstmt.setInt(7, Integer.parseInt(license));

			pstmt.executeUpdate();

			/*if (affectedRows > 0) {
				try (ResultSet rs = pstmt.getGeneratedKeys()) {
					if (rs.next()) {
						id = rs.getLong(0);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}*/
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		/*
		 * int update = 0; try { FileWriter writer = new FileWriter("PersonalInfo.txt",
		 * true); BufferedWriter bw = new BufferedWriter(writer); FileReader reader =
		 * new FileReader("PersonalInfo.txt"); BufferedReader br = new
		 * BufferedReader(reader);
		 * 
		 * String ID = br.readLine();
		 * 
		 * update = Integer.parseInt(ID); update += 1; ID = String.valueOf(update);
		 * 
		 * bw.newLine(); bw.append(ID); bw.newLine(); bw.append(address); bw.newLine();
		 * bw.append(birthday); bw.newLine(); bw.append(email); bw.newLine();
		 * bw.append(phonenum); bw.newLine(); bw.append(ssn); bw.newLine();
		 * bw.append(license); bw.newLine(); bw.append(name); bw.newLine(); br.close();
		 * bw.close();
		 * 
		 * } catch (IOException e) { e.printStackTrace(); } replace(update);
		 */
	}

	/*
	 * public void replace(int Id) { try { int oldId = Id - 1; String IdS = Id + "";
	 * String IdSN = oldId + "";
	 * 
	 * FileWriter writer = new FileWriter("PersonalInfo2.txt"); FileReader reader =
	 * new FileReader("PersonalInfo.txt"); BufferedReader br = new
	 * BufferedReader(reader); String oldContent = ""; String line = br.readLine();
	 * 
	 * while (line != null) { oldContent = oldContent + line +
	 * System.lineSeparator(); line = br.readLine(); } String newContent =
	 * oldContent.replaceFirst(IdSN, IdS); writer.write(newContent); writer.close();
	 * br.close(); reader.close();
	 * 
	 * File f1 = new File("PersonalInfo.txt");
	 * 
	 * File f2 = new File("PersonalInfo2.txt"); f1.delete(); f2.renameTo(f1); }
	 * catch (Exception e) { e.printStackTrace(); } }
	 */
}
