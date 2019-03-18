package exercise;

import java.util.Scanner;

public class Exercise09 {
	public static void main(String[] args) {
		boolean run = true;
		int studentNum = 0;
		int[] scores = null;

		Scanner sc = new Scanner(System.in);
		while (run) {
			System.out.println("---------------------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("---------------------------------------------------------");
			System.out.print("선택 > ");

			int selectNo = Integer.parseInt(sc.nextLine());
			if (selectNo == 1) {
				System.out.print("학생수> ");
				try {
					studentNum = Integer.parseInt(sc.nextLine());
				} catch (NumberFormatException e) {
					System.out.println("올바른 값을 입력하세요.");
				}
			} else if (selectNo == 2) {
				scores = new int[studentNum];
				for (int i = 0; i < studentNum; i++) {
					System.out.print("scores[" + i + "]> ");
					scores[i] = Integer.parseInt(sc.nextLine());
				}
			} else if (selectNo == 3) {
				for (int i = 0; i < studentNum; i++) {
					System.out.println("scores[" + i + "]> " + scores[i]);
				}
			} else if (selectNo == 4) {
				int sum = 0;
				int max = 0, min = 0;
				// 앞에서부터 탐색
				for (int i = 0; i < scores.length - 1; i++) {
					if (scores[i] < scores[i + 1]) {
						min = scores[i];
						scores[i] = scores[i + 1];
						scores[i + 1] = min;
					}
				}
				for (int i = 0; i < scores.length - 1; i++) {
					if (scores[i] > scores[i + 1]) {
						max = scores[i];
						scores[i] = scores[i + 1];
						scores[i + 1] = max;
					}
				}
				// 역순으로 탐색
				for (int i = scores.length - 1; i > 0; i--) {
					if (scores[i] < scores[i - 1]) {
						min = scores[i];
						scores[i] = scores[i - 1];
						scores[i - 1] = min;
					}
				}
				for (int i = scores.length - 1; i > 0; i--) {
					if (scores[i] > scores[i - 1]) {
						max = scores[i];
						scores[i] = scores[i - 1];
						scores[i - 1] = max;
					}
				}
				for (int score : scores)
					sum += score;
				double avg = (double) sum / studentNum;
				double x = 0;
				for (int i = 0; i < studentNum; i++) {
					x += (avg - scores[i]) * (avg - scores[i]) / studentNum;
				}
				System.out.println("최고 점수: " + max);
				System.out.println("최저 점수: " + min);
				System.out.println("평균 점수: " + avg);
				System.out.println("분산: " + x);
			} else if (selectNo == 5) {
				run = false;
			} else {
				System.out.println("잘못된 숫자입니다. 다시 입력해 주세요.");
			}
		}
		System.out.println("프로그램 종료");
		sc.close();
	}
}
