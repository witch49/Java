package sec05.exam04;

import java.util.TreeSet;

public class ComparatorExample {
	public static void main(String[] args) {
//		TreeSet<Fruit> treeSet = new TreeSet<>();
//		// Fruit이 Comparable을 구현하지 않았기 때문에 예외 발생
//		treeSet.add(new Fruit("포도", 3000));
//		treeSet.add(new Fruit("수박", 10000));
//		treeSet.add(new Fruit("딸기", 6000));
		
		TreeSet<Fruit> treeSet = new TreeSet<>(new DescendingComparator()); // 내림차순 정렬자 제공
		treeSet.add(new Fruit("포도", 3000));
		treeSet.add(new Fruit("수박", 10000));
		treeSet.add(new Fruit("딸기", 6000));
		
		for(Fruit fruit : treeSet)
			System.out.println(fruit.name + ": " + fruit.price);

	}
}
