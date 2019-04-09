package exercise.ex08;

import java.util.*;

public class HashSetExample {
	public static void main(String[] args) {
		Set<Student> set = new HashSet<>();

		set.add(new Student(201901234, "홍길동"));
		set.add(new Student(201801234, "신용권"));
		set.add(new Student(201901234, "조민우")); // 학번이 같으므로 저장되지 않음

		Iterator<Student> iterator = set.iterator();
		while (iterator.hasNext()) {
			Student student = iterator.next();
			System.out.println(student.studentNum + ": " + student.name);
		}

	}
}
