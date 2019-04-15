package sec02.exam01;

import java.util.*;

public class ArrayListExample {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();

		list.add("Java");
		list.add("JDBC");
		list.add("Servelet/JSP");
		list.add(2, "Database");
		list.add("iBATIS");

		System.out.println("총 객체 수: " + list.size() + "\n");
		System.out.println("2: " + list.get(2) + "\n");
		for (int i = 0; i < list.size(); i++)
			System.out.println(i + ": " + list.get(i));
		System.out.println();

		list.remove(2);
		list.remove(2);
		list.remove("Java");

		for (int i = 0; i < list.size(); i++)
			System.out.println(i + ": " + list.get(i));
//		for (String s : list)
//			System.out.println(s);
		
	}
}
