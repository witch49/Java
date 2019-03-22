package practice.ex01;

import java.util.Scanner;

public class MyCalcApp {
	public static void main(String[] args) {
		Calculator calc = new MyCalc();

		Scanner sc = new Scanner(System.in);
		System.out.println("계산기 프로그램입니다. 두 정수를 입력받아 연산 결과를 알려줍니다.");
		System.out.print("첫 번째 정수를 입력하세요: ");
		int a = Integer.parseInt(sc.nextLine());
		System.out.print("두 번째 정수를 입력하세요: ");
		int b = Integer.parseInt(sc.nextLine());
		System.out.print("연산자를 입력하세요.(덧셈:+, 뺄셈:-, 곱셈:*)");
		String operator = sc.nextLine();

		switch (operator) {
		case "+":
			System.out.println(a + " + " + b + " = " + calc.add(a, b));
			break;
		case "-":
			System.out.println(a + " - " + b + " = " + calc.subtract(a, b));
			break;
		case "*":
			System.out.println(a + " * " + b + " = " + calc.multiply(a, b));
			break;
		default:
			System.out.println("잘못된 연산자입니다. 프로그램을 종료합니다.");
		}

		sc.close();
	}
}
