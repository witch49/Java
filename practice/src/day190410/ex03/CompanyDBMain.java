package day190410.ex03;

import java.time.LocalDate;
import java.util.TreeSet;

public class CompanyDBMain {
	public static void main(String[] args) {
		TreeSet<Employee> treeSet = new TreeSet<>(new SortedComparator());
		
		treeSet.add(new Employee(101, "홍길동", Type.GeneralManager, LocalDate.of(1994, 2, 5)));
		treeSet.add(new Employee(102, "이유덕", Type.GeneralManager, LocalDate.of(1990, 2, 14)));
		treeSet.add(new Employee(103, "이재영", Type.DeputyGeneralManager, LocalDate.of(2010, 7, 30)));
		treeSet.add(new Employee(104, "권종표", Type.DeputyGeneralManager, LocalDate.of(2010, 7, 30)));
		treeSet.add(new Employee(105, "박민호", Type.Manager, LocalDate.of(2014, 8, 17)));
		treeSet.add(new Employee(106, "강상희", Type.Manager, LocalDate.of(2014, 8, 17)));
		treeSet.add(new Employee(107, "김지완", Type.AssistantManager, LocalDate.of(2017, 9, 2)));
		treeSet.add(new Employee(108, "최승혁", Type.AssistantManager, LocalDate.of(2018, 7, 20)));
		treeSet.add(new Employee(109, "이성연", Type.Staff, LocalDate.of(2018, 3, 5)));
		treeSet.add(new Employee(110, "박영서", Type.Staff, LocalDate.of(2019, 3, 5)));
		treeSet.add(new Employee(111, "이성연", Type.Staff, LocalDate.of(2018, 3, 5)));

		System.out.printf("|%-5s|%-7s|%-23s|%-8s|\n", "사원번호", "이름", "직책", "입사일");
		for (Employee e : treeSet)
			System.out.printf("%-10s %-6s %-25s %s\n", e.getEno(), e.getName(), e.getPosition(), e.getEntryDate());

	}
}
