package exercise.ex10;

import java.util.regex.Pattern;

public class PatternMatcherExample {
	public static void main(String[] args) {
		String id = "5Angel1004";
		// 첫번째 문자 알파벳으로 시작, 두번째부터 숫자 혹은 영어로 구성, 총 8~12문자
		String regExp = "\\[a-zA-Z]\\w{7,11}";
		boolean isMatch = Pattern.matches(regExp, id);
		if (isMatch)
			System.out.println("ID로 사용할 수 있습니다.");
		else
			System.out.println("ID로 사용할 수 없습니다.");

	}
}
