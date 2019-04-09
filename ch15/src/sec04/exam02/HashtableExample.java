package sec04.exam02;

import java.util.*;

public class HashtableExample {
	public static void main(String[] args) {
		Map<String, String> map = new Hashtable<>();

		map.put("spring", "345");
		map.put("summer", "678");
		map.put("fall", "910");
		map.put("winter", "111212");

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("아이디와 비밀번호를 입력해주세요.");
			System.out.print("아이디> ");
			String id = sc.nextLine();

			System.out.print("비밀번호> ");
			String password = sc.nextLine();

			if (map.containsKey(id)) { // 아이디인 키가 존재하는지 확인
				if (map.get(id).equals(password)) { // 비밀번호 비교
					System.out.println("로그인 성공");
					break;
				} else
					System.out.println("비밀번호가 다릅니다.");
			} else
				System.out.println("아이디가 존재하지 않습니다.");
		}

		sc.close();
	}
}
