package compare;

import java.util.*;

public class ComparatorExample {
	public static void main(String[] args) {
		/**
		 * dBcAaEC 문자열을 aAbBcC 와 같은 알파벳 순서로 정렬하는 코드를 작성하세요.
		 */

		String str = "dBcAaECbeD";
		String[] strArray = str.split("");
		ArrayList<String> list = new ArrayList<String>();
		Collections.addAll(list, strArray);
		
		// Comparator 익명 클래스 사용
		Comparator<String> myComparator = new Comparator<String>() {
			@Override
			public int compare(String str1, String str2) {
				// CASE_INSENSITIVE_ORDER : 대소문자 구분 없이
				int res = String.CASE_INSENSITIVE_ORDER.compare(str1, str2);
				if (res == 0) {
					byte[] b1 = str1.getBytes();
					byte[] b2 = str2.getBytes();
					if (b1[0] > b2[0])
						return -1;
					res = str.compareTo(str2);
				}
				return res;
			}
		};
		
		Collections.sort(list, myComparator);
		
		System.out.println(list);
	}
}
