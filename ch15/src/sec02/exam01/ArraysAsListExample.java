package sec02.exam01;

import java.util.*;

public class ArraysAsListExample {
	public static void main(String[] args) {
		// asList : 고정 객체들로 구성
		List<String> list1 = Arrays.asList("홍길동", "신용권", "감자바");
		for (String name : list1)
			System.out.println(name);

		List<Integer> list2 = Arrays.asList(1, 2, 3);
		//list2.add(4);	// Error!
		//list2.remove(0);	// Error!
		for (int value : list2)
			System.out.println(value);

	}
}
