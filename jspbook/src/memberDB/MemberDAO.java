package memberDB;

import java.io.FileWriter;
import java.sql.*;
import java.util.*;
import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MemberDAO {
	public static final int ID_PASSWORD_MATCH = 1;
	public static final int ID_DOES_NOT_EXIST = 2;
	public static final int PASSWORD_IS_WRONG = 3;
	public static final int DATABASE_ERROR = -1;
	private static final Logger LOG = LoggerFactory.getLogger(MemberDAO.class);
	
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
		LOG.trace("MemberDAO insertMember() start");
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
			LOG.trace("MemberDAO insertMember() success");
		} catch (Exception e) {
			LOG.trace("MemberDAO insertMember() Exception ERROR!");
			e.printStackTrace();
		}
	}

	/* 2 - 회원 조회(id 순서대로 명단 출력) */
	public List<MemberDTO> selectMembersAll() {
		LOG.trace("MemberDAO selectMembersAll() start");
		String sql = "select * from member order by id;";
		List<MemberDTO> memberlist = selectCondition(sql);
		LOG.trace("MemberDAO selectMembersAll() end");
		return memberlist;
	}

	/* 주어진 query에 해당하는 데이터 목록 출력 */
	public List<MemberDTO> selectCondition(String query) {
		LOG.trace("MemberDAO selectCondition() start");
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
		LOG.trace("MemberDAO selectCondition() success");
		return memberlist;
	}

	/* member 단일 선택 */
	public MemberDTO selectOne(int mId) {
		LOG.trace("MemberDAO selectOne() start");
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
			LOG.trace("MemberDAO selectOne() Exception ERROR!!");
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null && !pStmt.isClosed())
					pStmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		LOG.trace("MemberDAO selectOne() success");
		return member;
	}

	/* 3 - 회원 정보 변경(수정) */
	public void updateMember(MemberDTO member) {
		LOG.trace("MemberDAO updateMember() start");
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
			LOG.trace("MemberDAO updateMember() success");
		} catch (Exception e) {
			LOG.trace("MemberDAO updateMember() Exception ERROR!!");
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
		LOG.trace("MemberDAO deleteMember() start");
		String query = "delete from member where id=?";
		PreparedStatement pStmt = null;
		try {
			pStmt = conn.prepareStatement(query);
			pStmt.setInt(1, mId);

			pStmt.executeUpdate();
			LOG.trace("MemberDAO deleteMember() success");
		} catch (Exception e) {
			LOG.trace("MemberDAO deleteMember() Exception ERROR!!");
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
		LOG.trace("MemberDAO selectMemberByName() start");
		String sql = "select * from member where name like '" + mName + "';";
		List<MemberDTO> memberist = selectCondition(sql);
		LOG.trace("MemberDAO selectMemberByName() success");
		return memberist;
	}

	/* 6 - 회원 로그인 (id, password 검증) */
	public int verifyLogin(int mId, String mhashedPass) {
		LOG.trace("MemberDAO verifyLogin() start");
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
				if (BCrypt.checkpw(mhashedPass, hashedPwd)) {
					LOG.trace("MemberDAO verifyLogin() success");
					return ID_PASSWORD_MATCH; // 로그인 성공
				}
				else {
					LOG.trace("MemberDAO verifyLogin() success - password ERROR!!");
					return PASSWORD_IS_WRONG;
				}
			}
			LOG.trace("MemberDAO verifyLogin() success - ID ERROR!!");
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
		LOG.trace("MemberDAO verifyLogin() fail - DB ERROR!!");
		return DATABASE_ERROR;
	}
	
	/* 비밀번호 암호화 - BCrypt 사용 */
	public void initPwd() {
		LOG.trace("MemberDAO initPwd() start");
		List<MemberDTO> mList = selectMembersAll();
		for(MemberDTO member : mList) {
			int id = member.getMemberId();
			String plainPwd = member.getMemberPassword();
			String hashedPwd = BCrypt.hashpw(plainPwd, BCrypt.gensalt());
			updatePwd(id, hashedPwd);
		}
		LOG.trace("MemberDAO initPwd() success");
	}
	
	public void updatePwd(int id, String hashed) {
		LOG.trace("MemberDAO updatePwd() start");
		String query = "update member set hashed=? where id=?";
		PreparedStatement pStmt = null;
		try {
			pStmt = conn.prepareStatement(query);
			pStmt.setString(1, hashed);
			pStmt.setInt(2, id);
			pStmt.executeUpdate();
			LOG.trace("MemberDAO updatePwd() success");
		} catch (Exception e) {
			LOG.trace("MemberDAO updatePwd() Exception ERROR!!");
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
	
	/* 파일 다운로드하는 메소드 */
	public String prepareDownload() {
		LOG.trace("MemberDAO prepareDownload() start");
		StringBuffer sb = new StringBuffer();
		List<MemberDTO> mList = selectMembersAll();
		
		try {
			FileWriter fw = new FileWriter("c:/tmp/MemberList.csv");
			fw.write("\uFEFF"); // CHARSET = UTF-16 Big Endian
			String head = "아이디, 이름, 생년월일, 주소\r\n" + "===================================================\r\n";
			sb.append(head);
			fw.write(head);
			for(MemberDTO mDto : mList) {
				String line = mDto.getMemberId() + ", " + mDto.getMemberName() + ", " + mDto.getMemberBirth() + ", " + mDto.getMemberAddress() + "\r\n\r\n";
				sb.append(line);
				fw.write(line);
			}
			fw.flush();
			fw.close();	
		} catch (Exception e) {
			LOG.trace("MemberDAO prepareDownload() Exception ERROR!!");
			e.printStackTrace();
		} 		
		LOG.trace("MemberDAO prepareDownload() success");
		return sb.toString();
	}
	
}
