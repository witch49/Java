package sec05.exam04;

import java.util.*;

public class ComparableExample {
	public static void main(String[] args) {
		TreeSet<Person> treeSet = new TreeSet<>();
		//HashSet<Person> treeSet = new HashSet<>();

		Person p1 = new Person("강자바", 21);
		Person p2 = new Person("강자바", 21);

		if (p1.equals(p2))
			System.out.println("p1 equals p2");
		System.out.println("p1.hashCode(): " + p1.hashCode());
		System.out.println("p2.hashCode(): " + p2.hashCode());

		treeSet.add(new Person("홍길동", 45));
		treeSet.add(new Person("김자바", 25));
		treeSet.add(new Person("박지원", 31));
		treeSet.add(new Person("전우치", 25));

		for (Person person : treeSet)
			System.out.println(person.name + " " + person.age);

	}
}
