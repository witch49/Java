package sec02.exam03;

import java.util.*;

public class LinkedListExample {
	public static void main(String[] args) {
		// 빈번한 객체 삭제 및 삽입 시 LinkList 가 더 성능 좋음
		List<String> list1 = new ArrayList<>();
		List<String> list2 = new LinkedList<>();

		long startTime, endTime;

		startTime = System.nanoTime();
		for (int i = 0; i < 10000; i++)
			list1.add(0, String.valueOf(i));
		endTime = System.nanoTime();
		System.out.println("ArrayList 걸린 시간: " + (endTime - startTime) + " ns");

		startTime = System.nanoTime();
		for (int i = 0; i < 10000; i++)
			list2.add(0, String.valueOf(i));
		endTime = System.nanoTime();
		System.out.println("LinkedList 걸린 시간: " + (endTime - startTime) + " ns");

	}
}
