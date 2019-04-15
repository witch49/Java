package exercise;

public class Exercise07 {
	public static void main(String[] args) {
		int max = 0;
		int[] array = { 1, 5, 3, 8, 2 };

		for (int i = 0; i < array.length-1; i++) {
			if(array[i] > array[i+1]) {
				max = array[i];
				array[i] = array[i+1];
				array[i+1] = max;
			}
		}
		System.out.println("max : " + max);
	}
}
