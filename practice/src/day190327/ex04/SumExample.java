package day190327.ex04;

import java.util.Scanner;

public class SumExample {
	public static void main(String[] args) throws Exception {
		/**
		 * 1부터 10까지 자연수를 각각 제곱해 더하면 다음과 같다 (제곱의 합).
		 * 
		 * 1^2 + 2^2 + ... + 10^2 = 385
		 * 
		 * 1부터 10을 먼저 더한 다음에 그 결과를 제곱하면 다음과 같습니다 (합의 제곱).
		 * 
		 * (1 + 2 + ... + 10)^2 = 55^2 = 3025
		 * 
		 * 따라서 1부터 10까지 자연수에 대해 "합의 제곱"과 "제곱의 합" 의 차이는 3025 - 385 = 2640 이 된다.
		 * 
		 * 입력으로 자연수 N을 받아, 1부터 N까지 자연수에 대해 "합의 제곱"과 "제곱의 합"의 차이는 얼마인가?
		 */

		Scanner sc = new Scanner(System.in);
		System.out.println("1부터 입력받은 자연수에 대해 '합의 제곱'과 '제곱의 합'의 차이를 구합니다.");
		System.out.print("자연수를 입력하세요: ");
		int input = Integer.parseInt(sc.nextLine());
		if (input <= 0) {
			sc.close();
			throw new Exception("자연수가 아닙니다. 프로그램을 종료합니다.");
		}

		int sum1 = 0, sum2 = 0;

		// 제곱의 합 구하기
		for (int i = 1; i <= input; i++) {
			sum1 += (i * i);
		}

		// 합의 제곱 구하기
		for (int i = 1; i <= input; i++) {
			sum2 += i;
		}
		sum2 *= sum2;

		System.out.println("차이 : " + (sum2 - sum1));
		sc.close();

	}

}
