package practice.ex04;

public class MySortApp {

	private static void printArray(String[] arr) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(" " + arr[i] + " ");
		System.out.println("");
	}

	public static void main(String[] args) {
		String[] arr = { "안녕", "자바", "홍길동", "젤리", "구구단" };
		MySort mysort = new MySortImpl();
		System.out.println("---- 기존 배열 ------------------------");
		printArray(arr);
		System.out.println();

		System.out.println("---- 배열 오름차순 정렬 ---------------");
		printArray(mysort.sort(arr));
		System.out.println();

		System.out.println("---- 배열 내림차순 정렬 ---------------");
		printArray(mysort.sort(arr, true));
		System.out.println();

		System.out.println("---- 배열 오름차순 정렬 ---------------");
		printArray(mysort.sort(arr, false));
		System.out.println();
		
		System.out.println("---- 기존 배열 ------------------------");
		printArray(arr);

	}
}
