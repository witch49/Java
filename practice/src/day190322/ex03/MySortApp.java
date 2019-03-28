package day190322.ex03;

import java.util.Arrays;

public class MySortApp {

	private static void printArray(String[] arr) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println("");
	}

	public static void main(String[] args) {
		String[] arr = { "안녕", "자바", "홍길동", "젤리", "구구단" };
		MySort mysort = new MySortImpl();
		System.out.print("기존 배열 >> ");
		printArray(arr); 
		
		System.out.print("배열 오름차순 정렬 >> ");
		printArray(mysort.sort(arr)); 
		//System.out.println(Arrays.toString(mysort.sort(arr)));
		
		System.out.print("배열 내림차순 정렬 >> ");
		printArray(mysort.sort(arr, true)); 
		
		System.out.print("배열 오름차순 정렬 >> ");
		printArray(mysort.sort(arr, false));
		
	}
}
