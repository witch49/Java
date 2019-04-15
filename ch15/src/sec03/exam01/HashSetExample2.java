package sec03.exam01;

import java.util.*;

public class HashSetExample2 {
	public static void main(String[] args) {
		Set<Member> set = new HashSet<>();

		set.add(new Member("홍길동", 30, "010-1234-5678"));
		set.add(new Member("홍길동", 30, "010-1234-5678"));

		// equals()와 hashCode() 재정의 안할 시 size=2
		System.out.println("총 객체수: " + set.size());
	}
}
