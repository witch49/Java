package day190327.ex02;

import java.util.*;

public class DashInsertExample {
	public static void main(String[] args) {
		/**
		 * dashInsert() 메소드는 숫자로 구성된 문자열을 매개변수로 받은 뒤,
		 * 
		 * 문자열 내에서 홀수가 연속되면 두 수 사이에 - 를 추가하고,
		 * 
		 * 짝수가 연속되면 * 를 추가하여 문자열을 리턴하는 기능을 갖고 있다.
		 * 
		 * (예, 454 => 454, 4546793 => 454*67-9-3)
		 * 
		 * dashInsert 메소드를 작성하고 이를 이용한 프로그램을 작성하시오.
		 * 
		 * - 입력 : 화면에서 숫자로 된 문자열을 입력받는다. (예:4546793)
		 * 
		 * - 출력 : *, -가 적절히 추가된 문자열을 화면에 출력한다. (예: 454*67-9-3)
		 */

		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력하세요(예:4546793): ");
		String input = sc.nextLine();

		System.out.println(dashInsert(input));
		sc.close();

	}

	public static StringBuffer dashInsert(String strNum) {

		StringBuffer sb = new StringBuffer();
		int a = -1, b = -1;
		sb.append("" + strNum.charAt(0));

		for (int i = 1; i < strNum.length(); i++) {
			a = Integer.parseInt("" + strNum.charAt(i - 1));
			b = Integer.parseInt("" + strNum.charAt(i));

			// 앞뒤 수가 짝수인 경우
			if (a % 2 == 0 && b % 2 == 0) {
				sb.append("*" + b);
			} else if (a % 2 == 1 && b % 2 == 1)
				sb.append("-" + b);
			else
				sb.append("" + b);

		}
		return sb;
	}
	
}
