package memberDB;

import java.sql.*;
import java.util.*;

public class MemberDAO {
	public static final int ID_PASSWORD_MATCH = 1;
	public static final int ID_DOES_NOT_EXIST = 2;
	public static final int PASSWORD_IS_WRONG = 3;
	public static final int DATABASE_ERROR = -1;
	
	private Connection conn;
	private static final String USERNAME = "javauser";
	private static final String PASSWORD = "javapass";
	private static final String URL = "jdbc:mysql://localhost:3306/world?verifyServerCertificate=false&useSSL=false";

	public MemberDAO() {
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

	/* 1 - 회원 가입 */
	public void insertMember(MemberDTO member) {
		String query = "insert into member (password, name, birth, address, hashed) values (?, ?, ?, ?, ?);";
		PreparedStatement pStmt = null;
		try {
			pStmt = conn.prepareStatement(query);
			
			String hashedPwd = BCrypt.hashpw(member.getMemberPassword(), BCrypt.gensalt()); // 암호화 코드 생성
			
			pStmt.setString(1, "*");
			pStmt.setString(2, member.getMemberName());
			pStmt.setInt(3, member.getMemberBirth());
			pStmt.setString(4, member.getMemberAddress());
			pStmt.setString(5, hashedPwd);
			
			pStmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* 2 - 회원 조회(id 순서대로 명단 출력) */
	public List<MemberDTO> selectMembersAll() {
		String sql = "select * from member order by id;";
		List<MemberDTO> memberlist = selectCondition(sql);
		return memberlist;
	}

	/* 주어진 query에 해당하는 데이터 목록 출력 */
	public List<MemberDTO> selectCondition(String query) {
		PreparedStatement pStmt = null;
		List<MemberDTO> memberlist = new ArrayList<MemberDTO>();

		try {
			pStmt = conn.prepareStatement(query);
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				MemberDTO member = new MemberDTO();
				member.setMemberId(rs.getInt(1));
				member.setMemberPassword(rs.getString(2));
				member.setMemberName(rs.getString(3));
				member.setMemberBirth(rs.getInt(4));
				member.setMemberAddress(rs.getString(5));
				memberlist.add(member);
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
		return memberlist;
	}

	/* member 단일 선택 */
	public MemberDTO selectOne(int mId) {
		String query = "select * from member where id=?;";
		PreparedStatement pStmt = null;
		MemberDTO member = new MemberDTO();
		try {
			pStmt = conn.prepareStatement(query);
			pStmt.setInt(1, mId);
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				member.setMemberId(rs.getInt(1));
				member.setMemberPassword(rs.getString(2));
				member.setMemberName(rs.getString(3));
				member.setMemberBirth(rs.getInt(4));
				member.setMemberAddress(rs.getString(5));
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
		return member;
	}

	/* 3 - 회원 정보 변경(수정) */
	public void updateMember(MemberDTO member) {
		String query = "update member set password=?, name=?, birth=?, address=? where id=?;";
		PreparedStatement pStmt = null;
		try {
			pStmt = conn.prepareStatement(query);
			pStmt.setString(1, member.getMemberPassword());
			pStmt.setString(2, member.getMemberName());
			pStmt.setInt(3, member.getMemberBirth());
			pStmt.setString(4, member.getMemberAddress());
			pStmt.setInt(5, member.getMemberId());
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

	/* 4 - 회원 삭제 */
	public void deleteMember(int mId) {
		String query = "delete from member where id=?";
		PreparedStatement pStmt = null;
		try {
			pStmt = conn.prepareStatement(query);
			pStmt.setInt(1, mId);

			pStmt.executeUpdate();

			System.out.println("=== id:" + mId + " 삭제 완료 ===");
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

	/* 5 - 회원 검색 (이름으로) */
	public List<MemberDTO> selectMemberByName(String mName) {
		String sql = "select * from member where name like '" + mName + "';";
		List<MemberDTO> memberist = selectCondition(sql);
		return memberist;
	}
	
//	public List<MemberDTO> selectMemberById(int mId) {
//		String sql = "select * from member where id=" + mId + ";";
//		List<MemberDTO> memberist = selectCondition(sql);
//		return memberist;
//	}

	/* 6 - 회원 로그인 (id, password 검증) */
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
				//String hashedPwd = BCrypt.hashpw(plainPwd, BCrypt.gensalt());
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
			} catch(SQLException se) {
				se.printStackTrace();
			}
		}
		return DATABASE_ERROR;
	}
	
	/* 비밀번호 암호화 - BCrypt 사용 */
	public void initPwd() {
		List<MemberDTO> mList = selectMembersAll();
		for(MemberDTO member : mList) {
			int id = member.getMemberId();
			String plainPwd = member.getMemberPassword();
			String hashedPwd = BCrypt.hashpw(plainPwd, BCrypt.gensalt());
			updatePwd(id, hashedPwd);
		}
	}
	
	public void updatePwd(int id, String hashed) {
		String query = "update member set hashed=? where id=?";
		PreparedStatement pStmt = null;
		try {
			pStmt = conn.prepareStatement(query);
			pStmt.setString(1, hashed);
			pStmt.setInt(2, id);
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
	
}
