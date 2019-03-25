package practice.ex01;

import java.util.Scanner;

public class LoginExample {
	public static void main(String[] args) {
		String[] loginIds = { "abcde", "fghij", "klmno", "pqrst", "uvwxyz" };
		String[] passwords = { "abcde12", "fghij12", "klmno12", "pqrst12", "uvwxyz12" };
		int index = 0;

		Scanner sc = new Scanner(System.in);
		System.out.print("아이디를 입력하세요: ");
		String inputID = sc.nextLine();

		// 앞뒤 공백 제거
		inputID = inputID.trim();

		try {
			for (index = 0; index < loginIds.length; index++) {
				if (inputID.equals(loginIds[index]))
					break;
			}
			// 혹은 이런 방법
//			int index = -1;
//			for (int i = 0; i < loginIds.length; i++) {
//				if (inputID.equals(loginIds[index])) {
//					index = i;
//					break;
//				}
//			}
//			if(index < 0) { ... }
			if (index == loginIds.length)
				throw new InvalidLoginIdException("로그인 아이디가 없습니다.");
		} catch (InvalidLoginIdException e) {
			e.printStackTrace();
			System.exit(0);
		}

		System.out.print("패스워드를 입력하세요: ");
		String inputPwd = sc.nextLine();

		// 앞뒤 공백 제거
		inputPwd = inputPwd.trim();

		try {
			if (inputPwd.equals(passwords[index]))
				System.out.println("로그인 성공!");
			else
				throw new IncorrectPasswordException("패스워드를 잘못 입력하였습니다.");
		} catch (IncorrectPasswordException e) {
			e.printStackTrace();
		}
	}
}
