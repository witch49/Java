package day190410.ex02;

import java.util.*;

public class CompanyCollection {
	public static void main(String[] args) {
		String names = "이유덕,이재영,권종표,이재영,박민호,강상희,이재영,김지완,최승혁,이성연,박영서,박민호,전경헌,송정환,김재성,이유덕,이재영,전경헌";

		StringTokenizer st = new StringTokenizer(names, ",");
		TreeSet<String> treeSet = new TreeSet<>();
		int countKim = 0, countLee = 0, countLJM = 0;

		while (st.hasMoreTokens()) {
			String temp = st.nextToken();
			if (temp.charAt(0) == '김')
				countKim++;
			if (temp.charAt(0) == '이')
				countLee++;
			if (temp.equals("이재명"))
				countLJM++;
			treeSet.add(temp);
		}
		
		/* 1. 중복 포함 김씨와 이씨는 각각 몇 명? */
		System.out.println("1) 김씨: " + countKim + "명, 이씨: " + countLee + "명");
		
		/* 2. "이재영" 이름은 몇 번 중복? */
		System.out.println("2) \"이재명\" 이름 횟수: " + countLJM);
		
		/* 3, 4. 중복 제거한 이름을 오름차순으로 정렬하여 출력 */
		System.out.print("3) ");
		for (String s : treeSet)
			System.out.print(s + " ");
	}

}
