package com.mycompany.paypaltest1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Delete {
	
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
	public boolean delete(String name, String ID) {
		String SQL = "DELETE FROM employee WHERE id = ? AND name= ?";
		 
        try (Connection conn = connect();
                PreparedStatement pstmt = conn.prepareStatement(SQL)) {
 
            pstmt.setInt(1, Integer.parseInt(ID));
            pstmt.setString(2, name);
            
 
            pstmt.executeUpdate();
 
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
		
		/* maybe better for mysql with some adjustment
        
		 * try { boolean found = false; File changeFile = new File("PersonalInfo.txt");
		 * 
		 * BufferedReader reader = new BufferedReader(new FileReader(changeFile));
		 * FileWriter writer = new FileWriter("PersonalInfo2.txt");
		 * 
		 * String oldContent = "";
		 * 
		 * String line = reader.readLine(); int largeID = Integer.parseInt(line); int
		 * IDNum = Integer.parseInt(ID); if (largeID < IDNum) { writer.close();
		 * reader.close(); File f1 = new File("PersonalInfo2.txt"); f1.delete(); return
		 * false; } while (line != null) {
		 * 
		 * if (line.equals(ID)) { for (int i = 0; i < 7; i++) { line =
		 * reader.readLine(); } if (!line.equals(name)) { writer.close();
		 * reader.close(); File f1 = new File("PersonalInfo2.txt"); f1.delete(); return
		 * false; } found = true; line = reader.readLine();
		 * 
		 * } oldContent = oldContent + line + System.lineSeparator(); line =
		 * reader.readLine(); } if (found == false) { writer.close(); reader.close();
		 * File f1 = new File("PersonalInfo2.txt"); f1.delete(); return false; }
		 * writer.write(oldContent); writer.close(); reader.close();
		 * 
		 * File f1 = new File("PersonalInfo.txt");
		 * 
		 * File f2 = new File("PersonalInfo2.txt"); f1.delete(); f2.renameTo(f1);
		 * 
		 * return true; } catch (Exception e) { e.printStackTrace(); return false; }
		 */
	}
}
