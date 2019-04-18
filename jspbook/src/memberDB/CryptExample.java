package memberDB;

public class CryptExample {
	public static void main(String[] args) {

		// 패스워드 암호화 부분 (서버 말고 자바 쪽으로 실행)
		MemberDAO mDao = new MemberDAO();
		mDao.initPwd();
		mDao.close();

	}
}
