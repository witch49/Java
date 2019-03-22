package practice.ex04;

import java.util.Arrays;

public class MySortImpl implements MySort {

	// 오름차순 정렬 메소드
	@Override
	public String[] sort(String[] strArray) {
		String[] arrayCopy = new String[strArray.length];
		System.arraycopy(strArray, 0, arrayCopy, 0, strArray.length);
		//String[] a = Arrays.copyOf(strArray, strArray.length);

		// bubble sort 정렬
		for (int i = arrayCopy.length - 1; i > 0; i--) {
			for (int k = 0; k < i; k++) {
				if (arrayCopy[k].compareTo(arrayCopy[k + 1]) > 0) {
					String temp = arrayCopy[k];
					arrayCopy[k] = arrayCopy[k + 1];
					arrayCopy[k + 1] = temp;
				}
			}
		}
		return arrayCopy;
	}

	// 내림차순 정렬 메소드
	@Override
	public String[] sort(String[] strArray, boolean descOrder) {
		String[] arrayCopy = new String[strArray.length];
		System.arraycopy(strArray, 0, arrayCopy, 0, strArray.length);

		if (descOrder == true) {// true면 내림차순으로 반환
			// bubble sort 정렬
			for (int i = arrayCopy.length - 1; i > 0; i--) {
				for (int k = 0; k < i; k++) {
					if (arrayCopy[k].compareTo(arrayCopy[k + 1]) < 0) {
						String temp = arrayCopy[k];
						arrayCopy[k] = arrayCopy[k + 1];
						arrayCopy[k + 1] = temp;
					}
				}
			}
			return arrayCopy;

		} else {// false면 오름차순으로 반환
			return sort(arrayCopy);
		}
	}

}
