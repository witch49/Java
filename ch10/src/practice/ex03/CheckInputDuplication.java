package practice.ex03;

import java.util.Scanner;

public class CheckInputDuplication {
	static boolean check;
	static String[] inputArray;
	static int count = 0;

	public static void main(String[] args) throws Exception {
		/**
		 * 0~9까지의 문자로 된 숫자를 입력 받았을 때,
		 * 
		 * 이 입력 값이 중복된 것이 있는지 확인하는 함수를 구하시오.
		 * 
		 * (최대 10회 입력을 받는다고 가정)
		 * 
		 * (Run Configurations > Arguments 로 한다면 checkDuplication() 함수에서
		 * 
		 * args.length 받아들이는 걸로 해서 받아오기 checkDuplication(String args[], int x)) 뭐 이런 식으로다가
		 */

		Scanner sc = new Scanner(System.in);
		System.out.println("0~9의 숫자로 이루어진 문자를 입력하세요. 최대 10개 입력 가능합니다. 공백으로 문자를 구분합니다.");
		System.out.println("[sample inputs : 0123456789 01234 0123456789 6789012345 012322456789\t]");
		System.out.println("[sample outputs: true true false true true\t\t\t\t]");
		System.out.print("inputs : ");
		String str = sc.nextLine();
		inputArray = str.split(" ");

		System.out.print("outputs : ");
		for (int i = 0; i < inputArray.length; i++) {
			System.out.print(checkDuplication(count) + " ");
			count++;
		}

		sc.close();
	}

	// 중복 검사하는 함수
	public static boolean checkDuplication(int x) {
		if (x == 0) {
			return true;
		} else {
			for (int a = x - 1; a >= 0; a--) {
				if (inputArray[x].equals(inputArray[a]))
					return false;
			}
			return true;
		}
	}

}
