package exercise.ex08;

import java.util.StringTokenizer;

public class SplitExample {
	public static void main(String[] args) {
		String str = "아이디,이름,패스워드";

		// 방법 1 - split() 이용
		String[] strArray = str.split(",");
		for (int i = 0; i < strArray.length; i++)
			System.out.println(strArray[i]);
		System.out.println();
		
		// 방법 2 - StringTokenizer 이용
		StringTokenizer s2 = new StringTokenizer(str, ",");
		while (s2.hasMoreTokens())
			System.out.println(s2.nextToken());
		

	}
}
