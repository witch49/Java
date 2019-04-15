package basic01;

import java.sql.*;

public class ConnectMain {
	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// DB와 연결
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/world?verifyServerCertificate=false&useSSL=false", "javauser", "javapass");
			st = conn.createStatement();
//			String sql = "select * from song;";
			String sql2 = "select * from song where title like ?;";
//			String sql3 = "select id, date_format(datetime, '%Y-%m-%d %r') from date_table;";
			
//			String query = "insert into song (title, lyrics) values (?, ?);";
//			String query2 = "update song set title=?,lyrics=? where _id=?;";
//			String query3 = "insert into song (title, lyrics) values (?,?);";
//			String query4 = "delete from song where _id=?;";
			
			PreparedStatement pStmt = conn.prepareStatement(sql2);
			pStmt.setString(1, "Gee");
//			pStmt.setString(1, "가시나");
//			pStmt.setString(2, "왜 예쁜 날 두고 가시나 (날 두고 가시나)");
//			pStmt.setInt(3, 117);
//			pStmt.executeUpdate();
			
			ResultSet rs = pStmt.executeQuery();
//			ResultSet rs = st.executeQuery(sql2);
			while (rs.next()) {
				int songId = rs.getInt(1);	// index 1부터 시작
				String title = rs.getString(2);
				String lyrics = rs.getString(3);
				System.out.printf("%8d  %-25s\t%s\n", songId, title, lyrics);
//				int id = rs.getInt(1);
//				String datetime = rs.getString(2);
//				System.out.printf("%d  %s\n", id, datetime);
			}
			rs.close();
			st.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
