package day190410.ex02;

import java.util.StringTokenizer;
import java.util.TreeSet;

public class CompanyCollection {
	public static void main(String[] args) {
		String names = "이유덕,이재영,권종표,이재영,박민호,강상희,이재영,김지완,최승혁,이성연,박영서,박민호,전경헌,송정환,김재성,이유덕,이재영,전경헌";

		StringTokenizer st = new StringTokenizer(names, ",");
		String[] namesArray = new String[st.countTokens()];
		int index = 0;

		while (st.hasMoreTokens()) {
			String temp = st.nextToken();
			namesArray[index] = temp;
			index++;
		}

		method1(namesArray);
		method2(namesArray);
		method3(namesArray);
		method4(namesArray);
	}

	/* 1. 중복 포함 김씨와 이씨는 각각 몇 명? */
	public static void method1(String[] namesArray) {
		int count = 0;

		char[][] array = new char[3][namesArray.length];

		for (int i = 0; i < namesArray.length - 1; i++) {
			for (int k = 0; k < 3; k++) {
				array[k][i] = namesArray[i].charAt(k);
			}
		}

		for (int i = 0; i < namesArray.length - 1; i++) {
			if (array[0][i] == '김' || array[0][i] == '이')
				count++;
		}

		System.out.println("1) " + count);
	}

	/* 2. "이재영" 이름은 몇 번 중복? */
	public static void method2(String[] namesArray) {
		int count = 0;
		for (int i = 0; i < namesArray.length; i++)
			if (namesArray[i].equals("이재영"))
				count++;
		System.out.println("2) " + count);
	}

	/* 3. 중복 제거한 이름 출력 */
	public static void method3(String[] namesArray) {
		TreeSet<String> treeSet = new TreeSet<>();
		for (int i = 0; i < namesArray.length - 1; i++)
			treeSet.add(namesArray[i]);
		
		System.out.print("3) ");
		for (String s : treeSet)
			System.out.print(s + " ");
		System.out.println();
	}

	/* 4. 중복 제거한 이름을 오름차순으로 정렬하여 출력 */
	public static void method4(String[] namesArray) {
		TreeSet<String> treeSet = new TreeSet<>();
		for (int i = 0; i < namesArray.length - 1; i++)
			treeSet.add(namesArray[i]);
		
		System.out.print("4) ");
		for (String s : treeSet)
			System.out.print(s + " ");
	}

}
