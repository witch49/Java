package exercise;

public class Exercise03 {
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 0; i <= 100; i++) {
			sum += i;
			i += 2;
		}
		System.out.println("3의 배수의 합 : " + sum);
	}
}
