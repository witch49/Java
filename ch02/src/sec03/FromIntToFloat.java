package sec03;

public class FromIntToFloat {
	public static void main(String[] args) {
		int num1 = 123456780;
		int num2 = 123456780;
		
		float num3 = num2;		// 123456780은 23비트로 표현할 수 없어 근사치로 변환됨
		num2 = (int) num3;
		
		int result = num1 - num2;
		System.out.println(result);
		System.out.println("num1 : " + num1 + ", num2 : " + num2);
	}
}
