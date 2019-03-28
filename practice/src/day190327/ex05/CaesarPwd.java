package day190327.ex05;

import java.util.Scanner;

public class CaesarPwd {
	public static void main(String[] args) throws Exception {
		/**
		 * 시저 암호는, 고대 로마의 황제 줄리어스 시저가 만들어 낸 암호인데,
		 * 
		 * 예를 들어 알파벳 A를 입력했을 때, 그 알파벳의 n개 뒤에 오는 알파벳이 출력되는 것이다.
		 * 
		 * 예를 들어 바꾸려는 단어가 'CAT"고, n을 5로 지정하였을 때 "HFY"가 되는 것이다.
		 * 
		 * 어떠한 암호를 만들 문장과 n을 입력했을 때 암호를 만들어 출력하는 프로그램을 작성하시오.
		 * 
		 * - 입력 : 화면에서 문자열과 n값을 입력받는다. (예: ROSE 5)
		 * 
		 * - 출력 : 암호화된 문자열을 출력
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.print("바꾸려는 단어를 입력하세요: ");
		String input = sc.nextLine();
		
		System.out.print("암호화에 사용할 숫자를 입력하세요(0~25 사이): ");
		int key = Integer.parseInt(sc.nextLine());
		if (key < 0 || key > 25) {
			throw new Exception("범위를 벗어났습니다. 다시 입력해 주세요.");
		}
			
		input = input.toUpperCase(); // 대문자로 변경
		
		String[] str = input.split("");
		char[] ch = new char[input.length()];
		for (int i = 0; i < input.length(); i++) {
			ch[i] = str[i].charAt(0);
			ch[i] = (char) (ch[i] + key);
			System.out.print(ch[i]);
		}

	}
}
