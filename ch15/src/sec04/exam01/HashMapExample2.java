package sec04.exam01;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample2 {
	public static void main(String[] args) {
		Map<Student, Integer> map = new HashMap<>();
		
		map.put(new Student(201901234, "홍길동"), 90);
		//System.out.println("value=" + map.get(new Student(201901234, "홍길동")));
		map.put(new Student(201901234, "홍길동"), 95);
		
		System.out.println("총 Entry수: " + map.size() + ", value=" + map.get(new Student(201901234, "홍길동")));
		
	}
}
