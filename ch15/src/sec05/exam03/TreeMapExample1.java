package sec05.exam03;

import java.util.*;

public class TreeMapExample1 {
	public static void main(String[] args) {
		TreeMap<Integer, String> scores = new TreeMap<>();
		scores.put(new Integer(87), "홍길동");
		scores.put(new Integer(98), "이동수");
		scores.put(new Integer(75), "박길순");
		scores.put(new Integer(95), "신용권");
		scores.put(new Integer(80), "김자바");
		
		// 내림차순 정렬
		NavigableMap<Integer, String> descendingMap = scores.descendingMap();
		Set<Map.Entry<Integer, String>> decendingEntrySet = descendingMap.entrySet();
		for (Map.Entry<Integer, String> entry : decendingEntrySet)
			System.out.print(entry.getKey() + ", " + entry.getValue() + " / ");
		System.out.println();
		
		// 다시 오름차순 정렬
		NavigableMap<Integer, String> ascendingMap = descendingMap.descendingMap();
		Set<Map.Entry<Integer, String>> ascendingEntrySet = ascendingMap.entrySet();
		for (Map.Entry<Integer, String> entry : ascendingEntrySet)
			System.out.print(entry.getKey() + ", " + entry.getValue() + " / ");

		
		Map.Entry<Integer, String> entry = null;

		entry = scores.firstEntry();
		System.out.println("\n\n가장 낮은 점수: " + entry.getKey() + ", " + entry.getValue());

		entry = scores.lastEntry();
		System.out.println("가장 높은 점수: " + entry.getKey() + ", " + entry.getValue());

		entry = scores.lowerEntry(new Integer(95));
		System.out.println("95점 아래 점수: " + entry.getKey() + ", " + entry.getValue());

		entry = scores.higherEntry(new Integer(95));
		System.out.println("95점 위의 점수: " + entry.getKey() + ", " + entry.getValue());

		entry = scores.floorEntry(new Integer(95));
		System.out.println("95점이거나 바로 아래 점수: " + entry.getKey() + ", " + entry.getValue());

		entry = scores.ceilingEntry(new Integer(85));
		System.out.println("85점이거나 바로 위의 점수: " + entry.getKey() + ", " + entry.getValue() + "\n");

		while (!scores.isEmpty()) {
			entry = scores.pollFirstEntry();
			System.out.println(entry.getKey() + ", " + entry.getValue() + " / 남은 객체 수: " + scores.size());
		}

	}
}
