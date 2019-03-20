package challenge;

import java.util.Scanner;

public class Calculator {

	int a;
	int b;

	public double Add(int a, int b) {
		return a + b;
	}

	public double Sub(int a, int b) {
		return a - b;
	}

	public double Mul(int a, int b) {
		return a * b;
	}

	public double Div(int a, int b) {
		return (double) a / b;
	}

	public void setValue(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public double calculate(String operator) {
		if (operator == "+")
			return Add(a, b);
		else if (operator == "-")
			return Sub(a, b);
		else if (operator == "*")
			return Mul(a, b);
		else if (operator == "/")
			return Div(a, b);
		else
			return 0;
	}

	public static void main(String[] args) {
		Calculator cal = new Calculator();

		Scanner sc = new Scanner(System.in);

		System.out.println("두 수의 사칙연산을 계산하는 프로그램입니다.");
		System.out.print("정수를 입력하세요(1)> ");
		int x = Integer.parseInt(sc.nextLine());
		System.out.print("정수를 입력하세요(2)> ");
		int y = Integer.parseInt(sc.nextLine());
		System.out.print("계산하고 싶은 사칙연산자를 입력하세요.\n(+:덧셈, -:뺄셈, *:곱셈, /:나눗셈) > ");
		String operator = sc.nextLine();
		cal.setValue(x, y);
		if (operator.equals("+"))
			System.out.println(x + " + " + y + " = " + cal.calculate("+"));
		else if (operator.equals("-"))
			System.out.println(x + " - " + y + " = " + cal.calculate("-"));
		else if (operator.equals("*"))
			System.out.println(x + " * " + y + " = " + cal.calculate("*"));
		else if (operator.equals("/"))
			System.out.println(x + " / " + y + " = " + cal.calculate("/"));
		else
			System.out.println("잘못된 연산자입니다. 프로그램을 종료합니다.");

		sc.close();
	}

}
