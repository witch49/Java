package day190327.ex03;

import java.util.Scanner;

public class PerfectNumbers {
	public static void main(String[] args) throws Exception {
		/**
		 * 자기 자신을 제외한 모든 양의 약수들의 합이 자기 자신이 되는 자연수를 완전수라고 한다.
		 * 
		 * 예를 들면, 6과 28은 완전수이다.
		 * 
		 * 6=1+2+3 // 1,2,3은 각각 6의 약수
		 * 
		 * 28=1+2+4+7+14 // 1,2,4,7,14는 각각 28의 약수.
		 * 
		 * 입력으로 자연수 N을 받고, 출력으로 N 이하의 모든 완전수를 출력하는 코드를 작성하시오
		 */

		Scanner sc = new Scanner(System.in);
		System.out.print("자연수 n을 입력하세요: ");
		int input = Integer.parseInt(sc.nextLine());
		if (input <= 0) {
			sc.close();
			throw new Exception("자연수가 아닙니다. 프로그램을 종료합니다.");
		}

		System.out.println(input + " 이하의 모든 완전수는 다음과 같습니다.");
		for (int i = 1; i <= input; i++) {
			int sum = 0;
			// i가 완전수인지 확인하기
			for (int k = 1; k < i; k++) {
				if (i % k == 0) {
					sum += k;
				}
			}
			if (sum == i) {
				System.out.print(i + " ");
			}
		}
		sc.close();
	}

}
