package basic05;

import java.util.Scanner;

public class BbsTest {
	public static void main(String[] args) {
		BbsApplication bbsApp = new BbsApplication();
		boolean state1 = true;
		boolean state2 = true;

		while (state1) {
			System.out.print("1-로그인 2-회원가입 3-종료> ");
			Scanner sc = new Scanner(System.in);
			int input1 = Integer.parseInt(sc.nextLine());
			switch (input1) {
			case 1:
				
				break;
			case 2:
				
				break;
			case 3:
				state1 = false;
				break;
			default:
				System.out.println("잘못된 값입니다. 다시 입력해주세요.");
			}
			
			while (state2) {
				System.out.print("회원메뉴 | 1-쓰기 2-조회 3-변경 4-삭제 5-상세조회 6-종료> ");
				//Scanner sc = new Scanner(System.in);
				int input2 = Integer.parseInt(sc.nextLine());
				switch (input2) {
				case 1:

					break;
				case 2:

					break;
				case 3:

					break;
				case 4:

					break;
				case 5:

					break;
				case 6:
					sc.close();
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
