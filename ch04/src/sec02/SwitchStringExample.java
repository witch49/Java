package sec02;

import java.util.*;

public class SwitchStringExample {
	public static void main(String[] args) {
		// String position = "과장";
		Scanner sc = new Scanner(System.in);
		System.out.print("직급을 입력하세요(부장, 과장, ...) : ");
		String position = sc.nextLine();

		switch (position) {
		case "부장":
			System.out.println("700만원");
			break;
		case "과장":
			System.out.println("500만원");
			break;
		default:
			System.out.println("300만원");
		}
		sc.close();
	}
}
