package sec05;

public class BoundedTypeParameterExample {
	public static void main(String[] args) {
		int result1 = Util.compare(10, 20); // int > Integer 자동 Boxing
		System.out.println(result1);

		int result2 = Util.compare(4.5, 3); // double -> Double 자동 Boxing
		System.out.println(result2);

	}
}
