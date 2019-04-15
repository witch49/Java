package exercise;

public class MemberService {
	String id;
	String password;

	public boolean login(String id, String password) {
		if (id == "hong" && password == "12345")
			return true;
		else
			return false;
	}

	public void logout(String id) {
		System.out.println("로그아웃되었습니다.");
	}
}
