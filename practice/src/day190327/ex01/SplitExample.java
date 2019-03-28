package day190327.ex01;

import java.util.StringTokenizer;

public class SplitExample {

	public static void main(String[] args) {
		/**
		 * 10~1000까지 각 숫자를 분해하여 곱하기한 값의 전체 합을 구하시오.
		 * 
		 * 예로, 10~15까지의 각 숫자를 분해하여 곱하기한 값의 전체 합은 다음과 같다.
		 * 
		 * 10 = 1 * 0 = 0
		 * 
		 * 11 = 1 * 1 = 1
		 * 
		 * 12 = 1 * 2 = 2
		 * 
		 * 13 = 1 * 3 = 3
		 * 
		 * 14 = 1 * 4 = 4
		 * 
		 * 15 = 1 * 5 = 5
		 * 
		 * 이 경우의 답은 0+1+2+3+4+5 = 15
		 */

		int sum[] = new int[991];
		int result = 0;

		for (int i = 10; i <= 1000; i++) {
			int sumTemp = 1;
			String s = String.valueOf(i); // 숫자를 String으로 변환
			StringTokenizer st = new StringTokenizer(s, "");

			while (st.hasMoreTokens()) {
				String token = st.nextToken(); // 현재 숫자 i를 token에 저장
				String[] arr = token.split(""); // i를 숫자 1개씩 잘라 arr에 저장
				for (int k = 0; k < arr.length; k++) {
					int[] temp = new int[arr.length];
					int a = 0;
					temp[k] = Integer.parseInt(arr[k]);
					a = temp[k];
					sumTemp *= a;
				}
			}
			sum[i - 10] += sumTemp;
			result += sum[i - 10];
			//System.out.print(sum[i - 10] + " ");
		}
		System.out.println("합은 " + result);

	}

}
