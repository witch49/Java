package day190322.ex03;

import java.util.Arrays;
import java.util.Collections;

public class MySortImpl implements MySort {

	// 오름차순 정렬 메소드
	@Override
	public String[] sort(String[] strArray) {
		String[] arrayCopy = new String[strArray.length];
		System.arraycopy(strArray, 0, arrayCopy, 0, strArray.length);
		Arrays.sort(arrayCopy);
		return arrayCopy;
	}

	// 내림차순 정렬 메소드
	@Override
	public String[] sort(String[] strArray, boolean descOrder) {
		String[] arrayCopy = new String[strArray.length];
		System.arraycopy(strArray, 0, arrayCopy, 0, strArray.length);

		if (descOrder == true) { // true면 내림차순으로 반환
			Arrays.sort(arrayCopy, Collections.reverseOrder());
			return arrayCopy;
		} else { // false면 오름차순으로 반환
			return sort(arrayCopy);
		}
	}

}
