package sec03.exam01;

import java.util.*;

public class HashSetExample1 {
	public static void main(String[] args) {
		Set<String> set = new HashSet<>();

		set.add("Java");
		set.add("JDBC");
		set.add("Servelet/JSP");
		set.add("Java");
		set.add("iBATIS");

		System.out.println("총 객체수: " + set.size());

		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next() + "\t");
		}

		set.remove("JDBC");
		set.remove("iBATIS");

		System.out.println("\n총 객체수: " + set.size());
		iterator = set.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next() + "\t");
		}

		set.clear();
		if (set.isEmpty())
			System.out.println("\n비어 있음");
	}
}
