package sec04.exam01;

import java.util.*;
import java.util.Map.Entry;

public class HashMapExample1 {
	public static void main(String[] args) {
		// Map 컬렉션 생성
		Map<String, Integer> map = new HashMap<>();

		// 객체 저장
		map.put("신용권", 85);
		map.put("홍길동", 90);
		map.put("동장군", 80);
		map.put("홍길동", 95);
		System.out.println("총 Entry수: " + map.size());

		// 객체 찾기
		System.out.println("홍길동: " + map.get("홍길동") + "\n");

		// 객체를 하나씩 처리
		Set<String> keySet = map.keySet();
		for (String s : keySet) 
			System.out.println(s + ": " + map.get(s));
//		Iterator<String> keyIterator = keySet.iterator();
//		while (keyIterator.hasNext()) {
//			String key = keyIterator.next();
//			int value = map.get(key);
//			System.out.println(key + ": " + value);
//		}

		// 객체 삭제
		map.remove("홍길동");
		System.out.println("\n총 Entry 수: " + map.size());

		// 객체를 하나씩 처리
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		for(Entry<String, Integer> e : entrySet)
			System.out.println(e.getKey() + ": " + e.getValue());
//		Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();
//		while (entryIterator.hasNext()) {
//			Map.Entry<String, Integer> entry = entryIterator.next();
//			String key = entry.getKey();
//			int value = entry.getValue();
//			System.out.println(key + ": " + value);
//		}

		map.clear();
		System.out.println("\n총 Entry 수: " + map.size());

	}
}
