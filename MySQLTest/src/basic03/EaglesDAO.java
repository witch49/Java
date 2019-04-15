package basic03;

import java.sql.*;
import java.util.*;

public class EaglesDAO {
	private Connection conn;
	private static final String USERNAME = "javauser";
	private static final String PASSWORD = "javapass";
	private static final String URL = "jdbc:mysql://localhost:3306/world?verifyServerCertificate=false&useSSL=false";

	public EaglesDAO() {
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

	public EaglesDTO selectOne(int backNo) {
		String query = "select * from Eagles where player_back_number=?;";
		PreparedStatement pStmt = null;
		EaglesDTO player = new EaglesDTO();
		try {
			pStmt = conn.prepareStatement(query);
			pStmt.setInt(1, backNo);
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				player.setPlayerBackNo(rs.getInt(1));
				player.setPlayerName(rs.getString(2));
				player.setPlayerPosition(rs.getString(3));
				player.setPlayerHometown(rs.getString(4));
				player.setPlayerThrowingHand(rs.getString(5));
				player.setPlayerHitHand(rs.getString(6));
				player.setPlayerSalary(rs.getString(7));
				player.setPlayerBirth(rs.getString(8));

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
		return player;
	}

	public void insertPlayer(EaglesDTO player) {
		String query = "insert into eagles values (?, ?, ?, ?, ?, ?, ?, ?);";
		PreparedStatement pStmt = null;
		try {
			pStmt = conn.prepareStatement(query);
			pStmt.setInt(1, player.getPlayerBackNo());
			pStmt.setString(2, player.getPlayerName());
			pStmt.setString(3, player.getPlayerPosition());
			pStmt.setString(4, player.getPlayerHometown());
			pStmt.setString(5, player.getPlayerThrowingHand());
			pStmt.setString(6, player.getPlayerHitHand());
			pStmt.setString(7, player.getPlayerSalary());
			pStmt.setString(8, player.getPlayerBirth());
			pStmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updatePlayer(EaglesDTO player) {
		String query = "update eagles set player_name=?, player_position=?, player_hometown=?, "
				+ "player_throwing_hand=?, player_hit_hand=?, player_salary=?, player_birth=? where player_back_number=?;";
		PreparedStatement pStmt = null;
		try {
			pStmt = conn.prepareStatement(query);
			pStmt.setString(1, player.getPlayerName());
			pStmt.setString(2, player.getPlayerPosition());
			pStmt.setString(3, player.getPlayerHometown());
			pStmt.setString(4, player.getPlayerThrowingHand());
			pStmt.setString(5, player.getPlayerHitHand());
			pStmt.setString(6, player.getPlayerSalary());
			pStmt.setString(7, player.getPlayerBirth());
			pStmt.setInt(8, player.getPlayerBackNo());
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
	
	public void deletePlayer(int BackNo) {
		String query = "delete from eagles where player_back_number=?";
		PreparedStatement pStmt = null;
		try {
			pStmt = conn.prepareStatement(query);
			pStmt.setInt(1, BackNo);

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
	
	public List<EaglesDTO> selectCondition(String query) {
		PreparedStatement pStmt = null;
		List<EaglesDTO> playerlist = new ArrayList<EaglesDTO>();

		try {
			pStmt = conn.prepareStatement(query);
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				EaglesDTO player = new EaglesDTO();
				player.setPlayerBackNo(rs.getInt(1));
				player.setPlayerName(rs.getString(2));
				player.setPlayerPosition(rs.getString(3));
				player.setPlayerHometown(rs.getString(4));
				player.setPlayerThrowingHand(rs.getString(5));
				player.setPlayerHitHand(rs.getString(6));
				player.setPlayerSalary(rs.getString(7));
				player.setPlayerBirth(rs.getString(8));
				playerlist.add(player);
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
		return playerlist;
	}
	
	public List<EaglesDTO> selectPlayersByPosition(String position) {
		String sql = "select * from Eagles where player_position like '" + position + "';";
		List<EaglesDTO> playerList = selectCondition(sql);
		return playerList;
	}
	
	public List<EaglesDTO> selectPlayersByBackNo(int BackNo) {
		String sql = "select * from Eagles where player_back_number>=" + BackNo + ";";
		List<EaglesDTO> playerList = selectCondition(sql);
		return playerList;
	}
	
	public List<EaglesDTO> selectPlayersAll() {
		String sql = "select * from eagles;";
		List<EaglesDTO> playerList = selectCondition(sql);
		return playerList;
	}
	
}
