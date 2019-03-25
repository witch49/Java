package practice.ex04;

public class CountNumber {
	public static void main(String[] args) {
		/**
		 * 1~1000에서 각 숫자의 개수를 구하시오.
		 * 
		 * 예로 10 ~ 15 까지의 각 숫자의 개수를 구해보자.
		 * 
		 * 10 = 1, 0 
		 * 11 = 1, 1 
		 * 12 = 1, 2 
		 * 13 = 1, 3 
		 * 14 = 1, 4 
		 * 15 = 1, 5 
		 * 
		 * 그러므로 이 경우의 답은
		 * 0: 1개, 1: 7개, 2: 1개, 3: 1개, 4: 1개, 5: 1개
		 * 
		 */

		// 각 숫자 count 값 저장할 변수 (해당 index에 그 index에 해당하는 숫자의 개수를 저장)
		int count[] = new int[10];

		// 100~999
		for (int i = 0; i <= 9; i++) {
			count[0] -= 1; // 앞에 0 붙어서 나오는 거 제거
			// 10~99
			for (int k = 0; k <= 9; k++) {
				count[0] -= 1; // 앞에 0 붙어서 나오는 거 제거
				// 1~9
				for (int n = 0; n <= 9; n++) {
					count[i] += 1;
					count[k] += 1;
					count[n] += 1;
				}
			}
		}
		//01~10 에서 앞에 0 한 번 삭제 못한 거 지우기
		count[0] -= 1;
		
		// 1000 추가 안 한 거 추가하기 
		count[0] += 3;
		count[1] += 1;
		
		System.out.println("1~1000에서 각 숫자의 개수 구하기");
		for (int i = 0; i < 10; i++) {
			System.out.println(i + "의 개수 : " + count[i]);
		}
	}
}
