package basic05;

import java.util.Scanner;

public class BbsTest {
	public static void main(String[] args) {
		BbsApplication bbsApp = new BbsApplication();
		boolean state1 = true;
		boolean state2 = true;
		/* sql문 - day0403_1.sql 파일 */
		while (state1) {
			System.out.print("1-로그인 2-종료> ");
			Scanner sc = new Scanner(System.in);
			int input1 = Integer.parseInt(sc.nextLine());
			switch (input1) {
			case 1:
				if (bbsApp.login() == null) {
					System.out.println("로그인 실패! 다시 입력해 주세요.");
					state2 = false;
					break;
				}
				System.out.println("로그인 성공!");
				state2 = true;
				break;
			case 2:
				state1 = false;
				state2 = false;
				break;
			default:
				System.out.println("잘못된 값입니다. 다시 입력해주세요.");
			}
			
			while (state2) {
				System.out.print("회원메뉴 | 1-쓰기 2-조회 3-변경 4-삭제 5-상세조회 6-종료(로그아웃)> ");
				int input2 = Integer.parseInt(sc.nextLine());
				switch (input2) {
				case 1:
					bbsApp.write();
					break;
				case 2:
					bbsApp.lookUp();
					break;
				case 3:
					bbsApp.modify();
					break;
				case 4:
					bbsApp.delete();
					break;
				case 5:
					bbsApp.lookUpDetail();
					break;
				case 6:
					state2 = false;			
					break;
				default:
					System.out.println("잘못된 값입니다. 다시 입력해주세요.");
				}
			}
		}
		System.out.println("프로그램 종료");
	}
}
