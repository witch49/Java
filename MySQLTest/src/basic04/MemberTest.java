package basic04;

import java.util.Scanner;

public class MemberTest {
	public static void main(String[] args) {
		MemberApplication memberapp = new MemberApplication();
		boolean state = true;
		/* sql문 - day0403_1.sql 파일 */
		while (state) {
			System.out.print("회원메뉴 | 1-가입 2-조회 3-변경 4-삭제 5-검색 6-로그인기능 7-종료> ");
			Scanner sc = new Scanner(System.in);
			int input = Integer.parseInt(sc.nextLine());
			switch (input) {
			case 1:
				memberapp.signUp();
				break;
			case 2:
				memberapp.lookUp();
				break;
			case 3:
				memberapp.modify();
				break;
			case 4:
				memberapp.delete();
				break;
			case 5:
				memberapp.search();
				break;
			case 6:
				memberapp.login();
				break;
			case 7:
				sc.close();
				state = false;
				break;
			default:
				System.out.println("잘못된 값입니다. 다시 입력해주세요.");
			}
		}
		System.out.println("프로그램 종료");
	}
}
