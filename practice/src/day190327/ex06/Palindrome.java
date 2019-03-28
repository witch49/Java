package day190327.ex06;

public class Palindrome {
	public static void main(String[] args) {
		/**
		 * 앞에서부터 읽을 때나 뒤에서부터 읽을 때나 모양이 같은 수를 대칭수(palindrome)라고 부른다.
		 * 
		 * 두 자리 수를 곱해 만들 수 있는 대칭수 중 가장 큰 수는 9009 (= 91 × 99) 이다.
		 * 
		 * 세 자리 수를 곱해 만들 수 있는 가장 큰 대칭수는 얼마인가?
		 */

		int num = 0, a = 0, b = 0;
		int result = 0;

		for (int i = 100; i <= 999; i++) {
			for (int k = i; k <= 999; k++) {
				num = i * k;
				
				// 가장 큰 수를 구하는 것이므로 6자리 숫자를 구함
				if (num / 100000 == num % 10) { // 첫번째 수와 여섯번째 수
					if (num / 10000 % 10 == num / 10 % 10) { // 두번째 수와 다섯번째 수
						if (num / 1000 % 10 == num / 100 % 10) {// 세번째 수와 네번째 수
							if (result < num) {
								result = num;
								a = i;
								b = k;
							}
						}
					}
				}
				
				/*// result = a * b;
				String str = Integer.toString(a * b);
				String[] strArray = str.split("");
				// 곱셈 결과 숫자의 개수가 짝수인 경우
				if (strArray.length % 2 == 0) {
					String[] str1 = new String[strArray.length / 2]; // 앞
					System.arraycopy(strArray, 0, str1, 0, (strArray.length / 2));
					String[] str2 = new String[strArray.length / 2]; // 뒤
					System.arraycopy(strArray, (strArray.length / 2), str2, 0, (strArray.length / 2));
					// str2 뒤집기
					// ...

					for (int i = 0; i < (strArray.length / 2); i++) {
						// 하나라도 같지 않으면
						if (!str1[i].equals(str2[i])) {
							result = 1;
						}
					}
				} else {

				}*/
			}
		}

		System.out.println(a + " x " + b + " = " + result);

	}
}
