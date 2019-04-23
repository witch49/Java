package memberDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BbsDAO {
	public static final int ID_PASSWORD_MATCH = 1;
	public static final int ID_DOES_NOT_EXIST = 2;
	public static final int PASSWORD_IS_WRONG = 3;
	public static final int DATABASE_ERROR = -1;

	private Connection conn;
	private static final String USERNAME = "javauser";
	private static final String PASSWORD = "javapass";
	private static final String URL = "jdbc:mysql://localhost:3306/world?verifyServerCertificate=false&useSSL=false";

	public BbsDAO() {
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

	/* 회원 로그인 (id, password 검증) */
	public int verifyLogin(int mId, String mhashedPass) {
		String query = "select hashed from member where id=?";
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		String hashedPwd = "";
		try {
			pStmt = conn.prepareStatement(query);
			pStmt.setInt(1, mId);
			rs = pStmt.executeQuery();
			while (rs.next()) {
				hashedPwd = rs.getString(1);
				// String hashedPwd = BCrypt.hashpw(plainPwd, BCrypt.gensalt());
				if (BCrypt.checkpw(mhashedPass, hashedPwd))
					return ID_PASSWORD_MATCH; // 로그인 성공
				else
					return PASSWORD_IS_WRONG;
			}
			return ID_DOES_NOT_EXIST;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				if (pStmt != null && !pStmt.isClosed())
					pStmt.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return DATABASE_ERROR;

	}

	/* 1 - 쓰기 (현재 로그인한 아이디로 글 작성) */
	public void insertBbs(BbsDTO bbs, int mId) {
		String query = "insert into bbs (memberId, title, content) values (?, ?, ?);";
		PreparedStatement pStmt = null;
		try {
			pStmt = conn.prepareStatement(query);
			pStmt.setInt(1, mId);
			pStmt.setString(2, bbs.getBbsTitle());
			pStmt.setString(3, bbs.getBbsContent());
			pStmt.executeUpdate();
			System.out.println("글쓰기 완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/* 2 - 글 조회(최신 작성한 순서대로 글 목록 출력) */
	public List<BbsDTO> selectPostsAll() {
		String sql = "select * from bbs order by date desc;";
		List<BbsDTO> postlist = selectCondition(sql);
		return postlist;
	}
	
	/* 주어진 query에 해당하는 데이터 목록 출력 */
	public List<BbsDTO> selectCondition(String query) {
		PreparedStatement pStmt = null;
		List<BbsDTO> bbslist = new ArrayList<BbsDTO>();

		try {
			pStmt = conn.prepareStatement(query);
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				BbsDTO bbs = new BbsDTO();
				bbs.setBbsId(rs.getInt(1));
				bbs.setBbsMemberId(rs.getInt(2));
				bbs.setBbsTitle(rs.getString(3));
				bbs.setBbsDate(rs.getString(4));
				bbs.setBbsContent(rs.getString(5));
				bbslist.add(bbs);
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
		return bbslist;
	}
	
	/* bbs 단일 선택 */
	public BbsDTO selectOne(int bId) {
		String query = "select * from bbs where bbs_id=?;";
		PreparedStatement pStmt = null;
		BbsDTO bbs = new BbsDTO();
		try {
			pStmt = conn.prepareStatement(query);
			pStmt.setInt(1, bId);
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				bbs.setBbsId(rs.getInt(1));
				bbs.setBbsMemberId(rs.getInt(2));
				bbs.setBbsTitle(rs.getString(3));
				bbs.setBbsDate(rs.getString(4));
				bbs.setBbsContent(rs.getString(5));	
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
		return bbs;
	}
	
	/* 3 - 변경 (글 수정, 본인이 작성한 것만 가능) */
	public void updateBbs(BbsDTO bbs, int mId, int bId) {
		String query = "UPDATE bbs SET title=?, date=date_format(now(), '%y-%m-%d %H:%i'), content=? WHERE memberId=" + mId + " AND bbs_id=" + bId + ";";

		PreparedStatement pStmt = null;
		try {
			pStmt = conn.prepareStatement(query);
			pStmt.setString(1, bbs.getBbsTitle());
			pStmt.setString(2, bbs.getBbsContent());
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
	
	/* 4 - 삭제 (id를 입력받아 본인이 작성한 글이라면 삭제) */
	public void deleteBbs(int bId, int mId) {
		String query = "DELETE from bbs where bbs_id=? and memberId=?";
		PreparedStatement pStmt = null;
		try {
			pStmt = conn.prepareStatement(query);
			pStmt.setInt(1, bId);
			pStmt.setInt(2, mId);
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
//	
//	/* 10개씩 잘라서 화면에 뿌려주기 */
//	public ArrayList<BbsDTO> getList(int pageNumber){ 
//		String SQL = "SELECT * FROM BBS ORDER BY bbs_id DESC LIMIT 10";
//		ArrayList<BbsDTO> list = new ArrayList<BbsDTO>();
//		try {
//			PreparedStatement pstmt = conn.prepareStatement(SQL);
//			pstmt.setInt(1, getNext() - (pageNumber -1) * 10);
//			rs = pstmt.executeQuery();
//			while (rs.next()) {
//				Bbs bbs = new Bbs();
//				bbs.setBbsId(rs.getInt(1));
//				bbs.setBbsMemberId(rs.getString(2));
//				bbs.setBbsTitle(rs.getString(3));
//				bbs.setBbsDate(rs.getString(4));
//				bbs.setBbsContent(rs.getString(5));
//				list.add(bbs);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return list; 
//
//	}
//
//	// 10 단위 페이징 처리를 위한 함수
//	public boolean nextPage(int pageNumber) {
//		String SQL = "SELECT * FROM BBS WHERE bbsID < ? bbsAvailable = 1 ORDER BY bbsID DESC LIMIT 10";
//		ArrayList<BbsDTO> list = new ArrayList<BbsDTO>();
//		try {
//			PreparedStatement pstmt = conn.prepareStatement(SQL);
//			pstmt.setInt(1, getNext() - (pageNumber - 1) * 10);
//			rs = pstmt.executeQuery();
//			if (rs.next()) {
//				return true;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return false;
//	}
	//https://rongscodinghistory.tistory.com/7
	//https://tbbrother.tistory.com/71
	
}
