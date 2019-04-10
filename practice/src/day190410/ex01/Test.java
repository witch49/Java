package day190410.ex01;

public class Test {
	public static void main(String[] args) {
		String[] arr = { "가가", "나나", "다다", "라라라" };

		for (int i = 1; i < arr.length - 1; i++) {
			arr[i] = arr[i + 1];
		}

		for (String a : arr)
			System.out.println(a);
	}
}
