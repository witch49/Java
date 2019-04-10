package day190410.ex03;

import java.util.*;
import java.time.LocalDate;

public class CompanyDBMain {
	public static void main(String[] args) {
		TreeSet<Employee> treeSet = new TreeSet<>(new SortedComparator());
		LocalDate d1 = LocalDate.of(1994, 2, 5);
		LocalDate d2 = LocalDate.of(1990, 2, 14);
		LocalDate d3 = LocalDate.of(2010, 7, 30);
		LocalDate d4 = LocalDate.of(2010, 7, 30);
		LocalDate d5 = LocalDate.of(2013, 3, 4);
		LocalDate d6 = LocalDate.of(2014, 8, 17);
		LocalDate d7 = LocalDate.of(2017, 9, 2);
		LocalDate d8 = LocalDate.of(2018, 7, 20);
		LocalDate d9 = LocalDate.of(2018, 3, 5);
		LocalDate d10 = LocalDate.of(2019, 3, 5);

		treeSet.add(new Employee(101, "홍길동", Type.GeneralManager, d1));
		treeSet.add(new Employee(102, "이유덕", Type.GeneralManager, d2));
		treeSet.add(new Employee(103, "이재영", Type.DeputyGeneralManager, d3));
		treeSet.add(new Employee(104, "권종표", Type.DeputyGeneralManager, d4));
		treeSet.add(new Employee(105, "박민호", Type.Manager, d5));
		treeSet.add(new Employee(106, "강상희", Type.Manager, d6));
		treeSet.add(new Employee(107, "김지완", Type.AssistantManager, d7));
		treeSet.add(new Employee(108, "최승혁", Type.AssistantManager, d8));
		treeSet.add(new Employee(109, "이성연", Type.Staff, d9));
		treeSet.add(new Employee(110, "박영서", Type.Staff, d10));

		System.out.printf("|%-5s|%-7s|%-23s|%-8s|\n", "사원번호", "이름", "직책", "입사일");
		for (Employee e : treeSet)
			System.out.printf("%-10s %-6s %-25s %-15s\n", e.getEno(), e.getName(), e.getPosition(), e.getEntryDate());

	}
}
