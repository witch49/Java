package sec04;

public class LogicalOperatorExample {
	public static void main(String[] args) {
		int charCode = 'A';

		if ((charCode >= 65) & (charCode <= 90)) {
			System.out.println("대문자네요");
		}

		if ((charCode >= 97) && (charCode <= 122)) {
			System.out.println("소문자네요");
		}

		if (!(charCode < 48) && !(charCode > 57)) {
			System.out.println("0~9 숫자네요");
		}

		int value = 6;

		if ((value % 2 == 0) | (value % 3 == 0)) {
			System.out.println(value + "는 2 또는 3의 배수네요");
		}

		if ((value % 2 == 0) || (value % 3 == 0)) {
			System.out.println(value + "는 2 또는 3의 배수네요");
		}

	}
}
