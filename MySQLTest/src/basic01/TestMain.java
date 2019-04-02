package basic01;

import java.sql.*;

public class TestMain {


	public static void insert() {
		Connection conn = null;
		Statement st = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// DB와 연결
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/world?verifyServerCertificate=false&useSSL=false", "javauser", "javapass");
			st = conn.createStatement();
			String sql = "select * from song;";
			String query = "insert into song (title, lyrics) values (?, ?);";

			PreparedStatement pStmt = conn.prepareStatement(query);
			pStmt.setString(1, "임시제목");
			pStmt.setString(2, "임시가사");
			pStmt.executeUpdate();

			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int songId = rs.getInt(1); // index 1부터 시작
				String title = rs.getString(2);
				String lyrics = rs.getString(3);
				System.out.printf("%8d  %-25s\t%s\n", songId, title, lyrics);
			}
			rs.close();
			st.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void select() {	
		Connection conn = null;
		Statement st = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// DB와 연결
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/world?verifyServerCertificate=false&useSSL=false", "javauser", "javapass");
			st = conn.createStatement();

			String sql = "select * from song where title like ?;";
		
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, "Gee");
			
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				int songId = rs.getInt(1);	// index 1부터 시작
				String title = rs.getString(2);
				String lyrics = rs.getString(3);
				System.out.printf("%8d  %-25s\t%s\n", songId, title, lyrics);
			}
			rs.close();
			st.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	public static void main(String[] args) {
		select();
	}
}
