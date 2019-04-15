package sec05.exam04;

public class Test {
	public static void main(String[] args) {
		String[] names = { "김", "이", "박", "한", "정" };
		// Arrays.sort(names);
		bubbleSort(names);
		for (String name : names)
			System.out.print(name + " ");

	}

	public static void bubbleSort(String[] names) {
		for (int i = 0; i < names.length - 1; i++) {
			for (int k = i + 1; k < names.length; k++) {
				if (names[i].compareTo(names[k]) > 0) {
					String temp = names[i];
					names[i] = names[k];
					names[k] = temp;
				}
			}
		}
	}

}
