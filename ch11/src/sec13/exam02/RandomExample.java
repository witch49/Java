package sec13.exam02;

import java.util.Arrays;
import java.util.Random;

public class RandomExample {
	public static void main(String[] args) {

		// 선택 번호
		int[] selectNumber = new int[6];
		Random random = new Random(); // 선택 번호를 얻기 위한 Random 객체 생성
		System.out.print("선택 번호: ");
		for (int i = 0; i < 6; i++) {
			selectNumber[i] = random.nextInt(45) + 1;
			System.out.print(selectNumber[i] + " ");
		}
		System.out.println();

		// 당첨 번호
		int[] winningNumber = new int[6];
		Random random2 = new Random();
		System.out.print("당첨 번호: ");
		for (int i = 0; i < 6; i++) {
			winningNumber[i] = random2.nextInt(45) + 1;
			System.out.print(winningNumber[i] + " ");
		}
		System.out.println();

/*		int count = 0;
		while (true) {
 			int[] selectNum = new int[6];
			Random ran = new Random();
			for (int i = 0; i < 6; i++)
				selectNum[i] = ran.nextInt(45) + 1;
			if (Arrays.equals(selectNum, winningNumber)) {
				System.out.print("뽑은 로또 번호: ");
				for (int i = 0; i < 6; i++)
					System.out.print(winningNumber[i] + " ");
				System.out.println("축하해요! 당첨되셨습니다.");
				System.out.println("계산 횟수: " + count);
				System.exit(0);
			}
			count++;
		}*/

		// 당첨 여부
		Arrays.sort(selectNumber);
		Arrays.sort(winningNumber);
		boolean result = Arrays.equals(selectNumber, winningNumber);
		System.out.print("당첨 여부: ");
		if (result)
			System.out.println("1등에 당첨되셨습니다.");
		else
			System.out.println("당첨되지 않았습니다.");

	}
}
