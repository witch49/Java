package day190410.ex01;

import java.util.StringTokenizer;

public class Company {
	public static void main(String[] args) {
		String names = "이유덕,이재영,권종표,이재영,박민호,강상희,이재영,김지완,최승혁,이성연,박영서,박민호,전경헌,송정환,김재성,이유덕,이재영,전경헌";

		StringTokenizer st = new StringTokenizer(names, ",");
		String[] namesArray = new String[st.countTokens()];
		int index = 0;

		while (st.hasMoreTokens()) {
			String temp = st.nextToken();
			namesArray[index] = temp;
			// System.out.println(namesArray[index]);
			index++;
		}

		method1(namesArray);
		method2(namesArray);
		method3(namesArray);
	}

	/* 1. 중복 포함 김씨와 이씨는 각각 몇 명? */
	public static void method1(String[] namesArray) {
		int countKim = 0, countLee = 0;
		for (int i = 0; i < namesArray.length - 1; i++) {
			if (namesArray[i].charAt(0) == '김')
				countKim++;
			if (namesArray[i].charAt(0) == '이')
				countLee++;
		}
		System.out.println("1) 김씨: " + countKim + "명, 이씨: " + countLee + "명");
	}

	/* 2. "이재영" 이름은 몇 번 중복? */
	public static void method2(String[] namesArray) {
		int count = 0;
		for (int i = 0; i < namesArray.length; i++)
			if (namesArray[i].equals("이재영"))
				count++;
		System.out.println("2) \"이재명\" 이름 횟수: " + count);

	}

	/* 3. 중복 제거한 이름 출력 */
	/* 4. 중복 제거한 이름을 오름차순으로 정렬하여 출력 */
	public static void method3(String[] namesArray) {
		int len = namesArray.length;
		int count = 0;
		for (int i = 1; i < namesArray.length - 1; i++) {
			for (int k = i + 1; k < namesArray.length; k++) {
				if (namesArray[i].equals(namesArray[k]) && !(namesArray[k].equals("x"))) {
					for (int n = k; n < namesArray.length - 1; n++) {
						namesArray[n] = namesArray[n + 1];
						namesArray[len - 1] = "x";
					}
				}
			}
		}

		for (String s : namesArray) {
			if (s.equals("x"))
				count++;
		}
		count++;

		/* 3. 중복 제거한 이름 출력 */
		System.out.print("3) ");
		for (int i = 0; i < namesArray.length - count; i++)
			System.out.print(namesArray[i] + " ");
		System.out.println();

		/* 4. 중복 제거한 이름을 오름차순으로 정렬하여 출력 */
		String[] ascendingArr = new String[namesArray.length - count + 1]; // 복사할 배열 생성
		for (int i = 0; i < namesArray.length - count; i++) { // 배열 복사
			ascendingArr[i] = namesArray[i];
		}
		for (int i = 0; i < ascendingArr.length - 1; i++) {
			for (int k = i; k < ascendingArr.length - 1; k++) {
				if (ascendingArr[i].compareTo(ascendingArr[k]) > 0) {
					String temp = ascendingArr[i];
					ascendingArr[i] = ascendingArr[k];
					ascendingArr[k] = temp;
				}
			}
		}

		System.out.print("4) ");
		for (int i = 0; i < ascendingArr.length - 1; i++) {
			System.out.print(ascendingArr[i] + " ");
		}

	}

}
