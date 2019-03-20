package sec10;

public class CalculatorExample {
	public static void main(String[] args) {
		double result1 = 10 * 10 * Calculator.pi;
		int result2 = Calculator.plus(0, 5);
		int result3 = Calculator.minus(10, 5);
		Calculator myCalc = new Calculator();
		myCalc.setColor("Navy");
		
		System.out.println("result1 : " + result1);
		System.out.println("result2 : " + result2);
		System.out.println("result3 : " + result3);
		System.out.println("color : " + myCalc.color);
	}
}
