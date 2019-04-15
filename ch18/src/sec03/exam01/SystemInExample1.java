package sec03.exam01;

import java.io.InputStream;

public class SystemInExample1 {
	public static void main(String[] args) throws Exception {
		System.out.println("=== 메뉴 ===");
		System.out.println("1. 예금 조회\n2. 예금 출금\n3. 예금 입금\n4. 종료");
		System.out.print("메뉴를 선택하세요: ");

		InputStream is = System.in; // 키보드 입력 스트림 얻기
		char inputChar = (char) is.read();

		switch (inputChar) {
		case '1':
			System.out.println("예금 조회를 선택하셨습니다.");
			break;
		case '2':
			System.out.println("예금 출금를 선택하셨습니다.");
			break;
		case '3':
			System.out.println("예금 입금를 선택하셨습니다.");
			break;
		case '4':
			System.out.println("종료를 선택하셨습니다.");
			break;
		default:
			System.out.println("잘못된 값입니다.");
		}

	}
}
