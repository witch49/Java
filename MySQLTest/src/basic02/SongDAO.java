package basic02;

import java.sql.*;
import java.util.*;

public class SongDAO {
	private Connection conn;
	private static final String USERNAME = "javauser";
	private static final String PASSWORD = "javapass";
	private static final String URL = "jdbc:mysql://localhost:3306/world?verifyServerCertificate=false&useSSL=false";

	public SongDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			if (conn != null && conn.isClosed())
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertSong(SongDTO song) {
		String query = "insert into song(title, lyrics) values (?,?);";
		PreparedStatement pStmt = null;
		try {
			pStmt = conn.prepareStatement(query);
			pStmt.setString(1, song.getTitle());
			pStmt.setString(2, song.getLyrics());
			pStmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public SongDTO selectOne(int id) {
		String query = "select * from song where _id=?;";
		PreparedStatement pStmt = null;
		SongDTO song = new SongDTO();
		try {
			pStmt = conn.prepareStatement(query);
			pStmt.setInt(1, id);
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				song.setId(rs.getInt("_id")); // rs.getInt(1)
				song.setTitle(rs.getString("title")); // rs.getString(2)
				song.setLyrics(rs.getString("lyrics")); // rs.getString(3)
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null && !pStmt.isClosed())
					pStmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return song;
	}

	public void updateSong(SongDTO song) {
		String query = "update song set title=? lyrics=? where _id=?;";
		PreparedStatement pStmt = null;
		try {
			pStmt = conn.prepareStatement(query);
			pStmt.setString(1, song.getTitle());
			pStmt.setString(2, song.getLyrics());
			pStmt.setInt(3, song.getId());

			pStmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null && !pStmt.isClosed())
					pStmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void deleteSong(SongDTO song) {
		String query = "delete from song where _id=?";
		PreparedStatement pStmt = null;
		try {
			pStmt = conn.prepareStatement(query);
			pStmt.setInt(1, song.getId());

			pStmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null && !pStmt.isClosed())
					pStmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * songDTO[] : 몇 개 들어올 지 모르므로 이거 말고 List 사용
	 * 			 : ArrayLisy<SongDTO> / List<SongDTO>
	 */
	public List<SongDTO> selectAll() {
		String query = "select * from song";
		PreparedStatement pStmt = null;
		List<SongDTO> list = new ArrayList<SongDTO>();
		try {
			pStmt = conn.prepareStatement(query);
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				SongDTO song = new SongDTO();
				song.setId(rs.getInt("_id"));
				song.setTitle(rs.getString("title"));
				song.setLyrics(rs.getString("lyrics"));
				list.add(song);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null && !pStmt.isClosed())
					pStmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

}
