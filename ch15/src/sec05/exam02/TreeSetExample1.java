package sec05.exam02;

import java.util.*;

public class TreeSetExample1 {
	public static void main(String[] args) {
		TreeSet<Integer> scores = new TreeSet<>();
		scores.add(new Integer(87));
		scores.add(new Integer(98));
		scores.add(new Integer(75));
		scores.add(new Integer(95));
		scores.add(new Integer(80));

		for (int score : scores)
			System.out.print(score + " ");
		System.out.println();

		/* 내림차순 정렬 */
		NavigableSet<Integer> descendingSet = scores.descendingSet();
		for (int score : descendingSet)
			System.out.print(score + " ");
		System.out.println();

		/* 다시 오름차순 정렬 */
		NavigableSet<Integer> ascendingSet = descendingSet.descendingSet();
		for (int score : ascendingSet)
			System.out.print(score + " ");

		System.out.println("\n\n가장 낮은 점수: " + scores.first());
		System.out.println("가장 높은 점수: " + scores.last());
		System.out.println("95점 아래 점수: " + scores.lower(new Integer(95)));
		System.out.println("95점 위의 점수: " + scores.higher(new Integer(95)));
		System.out.println("95점이거나 바로 아래 점수: " + scores.floor(new Integer(95)));
		System.out.println("85점이거나 바로 위의 점수: " + scores.ceiling(new Integer(85)) + "\n");
		while (!scores.isEmpty()) {
			System.out.println(scores.pollFirst() + ", 남은 객체 수: " + scores.size());
		}
	}

}
