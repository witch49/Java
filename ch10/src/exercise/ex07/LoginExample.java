package exercise.ex07;

public class LoginExample {
	public static void main(String[] args) {
		try {
			login("white", "12345");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			login("blue", "54321");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void login(String id, String password) throws Exception {
		// 작성
		// id != blue 일 경우 NotExistIDException 발생
		if (id != "blue") {
			//System.out.println("id가 존재하지 않습니다.");
			throw new NotExistIDException("id가 존재하지 않습니다.");
		}

		// password != 12345 일 경우 WrongPasswordException 발생
		if (password != "12345") {
			//System.out.println("password가 틀립니다.");
			throw new WrongPasswordException("password가 틀립니다.");
		}

	}

}
