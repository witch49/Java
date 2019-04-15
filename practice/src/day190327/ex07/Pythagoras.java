package day190327.ex07;

public class Pythagoras {
	public static void main(String[] args) {
		/**
		 * 세 자연수 a, b, c 가 피타고라스 정리 a^2 + b^2 = c^2 를 만족하면 피타고라스 수라고 부른다.
		 * 
		 * (여기서 a < b < c 이고 a + b > c)
		 * 
		 * 예를 들면, 3^2 + 4^2 = 9 + 16 = 25 = 5^2 이므로 3, 4, 5는 피타고라스 수입니다.
		 * 
		 * a + b + c = 1000 인 피타고라스 수를 구하시오. (답은 한가지 뿐이다.)
		 */

		for (int a = 1; a < 998; a++) {
			for (int b = a + 1; b < 999; b++) {
				for (int c = b + 1; c < 1000; c++) {
					if ((a + b > c) && (a * a + b * b == c * c) && (a + b + c == 1000)) {
						System.out.println(a + "^2 + " + b + "^2 = " + c + "^2");
						System.exit(0);
					}
				}
			}
		}

	}
}
