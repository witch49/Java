package basic05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BbsDAO {
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
	public int verifyLogin(int mId, String mPass) {
		String query = "select password from member where id=?";
		PreparedStatement pStmt = null;
		try {
			pStmt = conn.prepareStatement(query);
			pStmt.setInt(1, mId);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				if (rs.getString(1).equals(mPass))
					return 1; // 로그인 성공
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; // 로그인 실패
	}
	
	/* 1 - 쓰기 (현재 로그인한 아이디로 글 작성) */
	public void insertBbs(BbsDTO bbs, int bId) {
		String query = "insert into bbs (memberId, title, content) values (?, ?, ?);";
		PreparedStatement pStmt = null;
		try {
			pStmt = conn.prepareStatement(query);
			pStmt.setInt(1, bId);
			pStmt.setString(2, bbs.getBbsTitle());
			pStmt.setString(3, bbs.getBbsContent());
			pStmt.executeUpdate();
			System.out.println("글쓰기 완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/* 2 - 조회 (가장 최근에 작성한 순서대로 글 목록 출력) */
	public void showBbs() {
		String sql = "SELECT bbs.bbs_id, member.name, bbs.title, bbs.date, bbs.content "
				+ "FROM bbs INNER JOIN member on bbs.memberId = member.id ORDER BY date DESC;";
		PreparedStatement pStmt = null;
		BbsDTO bbs = new BbsDTO();
		try {
			pStmt = conn.prepareStatement(sql);
			pStmt.executeQuery(sql);
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				System.out.print("BbsDTO [글번호=" + rs.getString(1) + ", 글쓴이=" + rs.getString(2) + ", 제목=" + rs.getString(3)
						+ ", 작성일=" + rs.getString(4) + ", 내용=" + rs.getString(5) + "]\n");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
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
	public void updateBbs(BbsDTO bbs, int mId) {
		String query = "UPDATE bbs SET title=?, date=date_format(now(), '%y-%m-%d %H:%i'), content=? WHERE memberId=" + mId + " AND bbs_id=?;";

		PreparedStatement pStmt = null;
		try {
			pStmt = conn.prepareStatement(query);
			pStmt.setString(1, bbs.getBbsTitle());
			pStmt.setString(2, bbs.getBbsContent());
			pStmt.setInt(3, bbs.getBbsId());
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
	
	/* 5 - 상세 조회 (bbs.id를 입력받아 제목, 글쓴이, 최종수정일, 내용 표기) */
	public BbsDTO selectBbsById(int bId) {
		String sql = "SELECT bbs.bbs_id, member.name, bbs.title, bbs.date, bbs.content "
				+ "FROM bbs INNER JOIN member ON bbs.memberId = member.id " + "where bbs.bbs_id = " + bId + ";";
		PreparedStatement pStmt = null;
		BbsDTO bbs = new BbsDTO();
		try {
			pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				System.out.print("BbsDTO [글번호=" + rs.getString(1) + ", 글쓴이=" + rs.getString(2) + ", 제목=" + rs.getString(3)
						+ ", 작성일=" + rs.getString(4) + ", 내용=" + rs.getString(5) + "]\n");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return bbs;

	}

}
