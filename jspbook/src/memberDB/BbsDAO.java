package memberDB;

import java.sql.Connection;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.*;
import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BbsDAO {
	public static final int ID_PASSWORD_MATCH = 1;
	public static final int ID_DOES_NOT_EXIST = 2;
	public static final int PASSWORD_IS_WRONG = 3;
	public static final int DATABASE_ERROR = -1;
	
	private static final Logger LOG = LoggerFactory.getLogger(BbsDAO.class);

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
		LOG.trace("BbsDAO verifyLogin() start");
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
				if (BCrypt.checkpw(mhashedPass, hashedPwd)) {
					LOG.trace("BbsDAO verifyLogin() success");
					return ID_PASSWORD_MATCH; // 로그인 성공
				}
				else {
					LOG.trace("BbsDAO verifyLogin() success - PASSWORD ERROR!!");
					return PASSWORD_IS_WRONG;
				}
			}
			LOG.trace("BbsDAO verifyLogin() success - ID ERROR!!");
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
		LOG.trace("BbsDAO verifyLogin() DATABASE ERROR!!");
		return DATABASE_ERROR;

	}

	/* 1 - 쓰기 (현재 로그인한 아이디로 글 작성) */
	public void insertBbs(BbsDTO bbs, int mId) {
		LOG.trace("BbsDAO insertBbs() start");
		String query = "insert into bbs (memberId, title, content) values (?, ?, ?);";
		PreparedStatement pStmt = null;
		try {
			pStmt = conn.prepareStatement(query);
			pStmt.setInt(1, mId);
			pStmt.setString(2, bbs.getBbsTitle());
			pStmt.setString(3, bbs.getBbsContent());
			pStmt.executeUpdate();
			LOG.trace("BbsDAO insertBbs() success");
		} catch (Exception e) {
			LOG.trace("BbsDAO insertBbs() Exception ERROR!!");
			e.printStackTrace();
		}
	}

	/* 2 - 글 조회(글번호 순서대로 글 목록 출력) */
	public List<BbsDTO> selectPostsAll() {
		LOG.trace("BbsDAO selectPostsAll() start");
		String sql = "select * from bbs order by bbs_id desc;";
		List<BbsDTO> postlist = selectCondition(sql);
		return postlist;
	}

	/* 주어진 query에 해당하는 데이터 목록 출력 */
	public List<BbsDTO> selectCondition(String query) {
		LOG.trace("BbsDAO selectCondition() start");
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
				bbs.setBbsDate(rs.getString(4).substring(0, 16));
				bbs.setBbsContent(rs.getString(5));
				bbslist.add(bbs);
			}
		} catch (Exception e) {
			LOG.trace("BbsDAO selectCondition() Exception ERROR!!");
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null && !pStmt.isClosed())
					pStmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		LOG.trace("BbsDAO selectCondition() success");
		return bbslist;
	}

	/* bbs 단일 선택 */
	public BbsDTO selectOne(int bId) {
		LOG.trace("BbsDAO selectOne() start");
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
				bbs.setBbsDate(rs.getString(4).substring(0, 16));
				bbs.setBbsContent(rs.getString(5));
			}
			
		} catch (Exception e) {
			LOG.trace("BbsDAO selectOne() Exception ERROR!");
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null && !pStmt.isClosed())
					pStmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		LOG.trace("BbsDAO selectOne() success");
		return bbs;
	}

	/* 3 - 변경 (글 수정, 본인이 작성한 것만 가능) */
	public void updateBbs(BbsDTO bbs, int mId, int bId) {
		LOG.trace("BbsDAO updateBbs() start");
		String query = "UPDATE bbs SET title=?, date=date_format(now(), '%y-%m-%d %H:%i'), content=? WHERE memberId="
				+ mId + " AND bbs_id=" + bId + ";";

		PreparedStatement pStmt = null;
		try {
			pStmt = conn.prepareStatement(query);
			pStmt.setString(1, bbs.getBbsTitle());
			pStmt.setString(2, bbs.getBbsContent());
			pStmt.executeUpdate();
			LOG.trace("BbsDAO updateBbs() success");
		} catch (Exception e) {
			LOG.trace("BbsDAO updateBbs() Exception ERROR!");
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
		LOG.trace("BbsDAO deleteBbs() start");
		String query = "DELETE from bbs where bbs_id=? and memberId=?;";
		PreparedStatement pStmt = null;
		try {
			pStmt = conn.prepareStatement(query);
			pStmt.setInt(1, bId);
			pStmt.setInt(2, mId);
			pStmt.executeUpdate();
			LOG.trace("BbsDAO deleteBbs() success");
		} catch (Exception e) {
			LOG.trace("BbsDAO deleteBbs() Exception ERROR!!");
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

	/* join문 가져오기 */
	public String selectMemberName(int mId, int bId) {
		LOG.trace("BbsDAO selectMemberName() start");
		String query = "select member.name from member inner join bbs on bbs.memberId = member.id where bbs.memberId=? and bbs.bbs_id=?;";
		PreparedStatement pStmt = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, mId);
			pstmt.setInt(2, bId);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				LOG.trace("BbsDAO selectMemberName() success");
				return rs.getString(1);
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
		LOG.trace("BbsDAO - DB ERROR!!");
		return null; // DB 오류
	}
	
	
	///////////////////////////////////////////////////
	// 참고 사이트 : https://okky.kr/article/283315
	///////////////////////////////////////////////////

	/* 글 10개씩 조회 */
	public List<BbsDTO> getList(int pageNumber) {
		LOG.trace("BbsDAO getList(/10) start");
		String sql = "select * from bbs limit ?, 10;";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BbsDTO> list = new ArrayList<BbsDTO>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (pageNumber - 1) * 10);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BbsDTO bbs = new BbsDTO();
				bbs.setBbsId(rs.getInt(1));
				bbs.setBbsMemberId(rs.getInt(2));
				bbs.setBbsTitle(rs.getString(3));
				bbs.setBbsDate(rs.getString(4).substring(0, 16));
				bbs.setBbsContent(rs.getString(5));
				list.add(bbs);
			}
		} catch (Exception e) {
			LOG.trace("BbsDAO getList(/10) Exception ERROR!!");
			e.printStackTrace();
		}
		LOG.trace("BbsDAO getList(/10) success");
		return list;
	}

	// 전체 글의 개수 가져오기
	public int getListCount() {
		LOG.trace("BbsDAO getListCount() start");
		String sql = "select count(*) from bbs";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				LOG.trace("BbsDAO getListCount() success");
				return rs.getInt(1);
			}
			LOG.trace("BbsDAO getListCount() success - it's first post");
			return 1; // 첫 번째 게시물인 경우
		} catch (Exception e) {
			e.printStackTrace();
		}
		LOG.trace("BbsDAO - DB ERROR!");
		return -1; // 데이터베이스 오류
	}
	
	
	/* 파일 다운로드하는 메소드 */
	public String prepareDownload() {
		LOG.trace("BbsDAO prepareDownload() start");
		StringBuffer sb = new StringBuffer();
		List<BbsDTO> bList = selectPostsAll();
		
		try {
			FileWriter fw = new FileWriter("c:/tmp/BbsList.csv");
			fw.write("\uFEFF"); // CHARSET = UTF-16 Big Endian
			String head = "번호, 회원ID(작성자), 제목, 내용, 작성/수정일\r\n" + "===================================================\r\n";
			sb.append(head);
			fw.write(head);
			for (BbsDTO bDto : bList) {
				String line = bDto.getBbsId() + ", " + bDto.getBbsMemberId() + "("
						+ selectMemberName(bDto.getBbsMemberId(), bDto.getBbsId()) + "), " + bDto.getBbsTitle().replaceAll(",", " ") + ", "
						+ bDto.getBbsContent().replaceAll(",", " ").replaceAll("<br>", "").replaceAll("\r\n", " ")
						+ ", " + bDto.getBbsDate() + "\r\n\r\n";
				sb.append(line);
				fw.write(line);
			}
			fw.flush();
			fw.close();			
		} catch (Exception e) {
			LOG.trace("BbsDAO prepareDownload() Exception Error!!");
			e.printStackTrace();
		} 		
		LOG.trace("BbsDAO prepareDownload() success");
		return sb.toString();
	}

}
