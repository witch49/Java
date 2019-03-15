package exercise;

import java.util.*;

public class Exercise07 {
	public static void main(String[] args) {
		boolean run = true;
		int balance = 0;
		Scanner sc = new Scanner(System.in);
		while (run) {
			System.out.println("-------------------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("-------------------------------------");
			System.out.print("선택> ");
			int input = Integer.parseInt(sc.nextLine());

			if (input == 1) { // 예금하기
				System.out.print("예금액> ");			
				balance += Integer.parseInt(sc.nextLine());
			} else if (input == 2) {	// 출금하기
				System.out.print("출금액> ");
				int x = Integer.parseInt(sc.nextLine());
				balance -= x;
				if (balance < 0) {
					System.out.println("통장은 마이너스 값이 될 수 없습니다.");
					balance += x;
				}			
			} else if (input == 3) {	// 잔고 확인하기
				System.out.print("잔고> " + balance + "\n");			
			} else if (input == 4) {
				break;
			} else {
				System.out.println("잘못된 값을 입력하였습니다. 다시 입력해 주세요.");
			}

		}
		sc.close();
	}
}
