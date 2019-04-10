package day190410.ex03;

import java.util.Comparator;

public class SortedComparator implements Comparator<Employee> {
	// GeneralManager, DeputyGeneralManager, Manager, AssistantManager, Staff 순서

	@Override
	public int compare(Employee e1, Employee e2) {
		if (e1.getPosition().ordinal() < e2.getPosition().ordinal()) {
			return -1;
		} else if (e1.getPosition().ordinal() > e2.getPosition().ordinal()) {
			return 1;
		} else {
			if (e1.getEntryDate().isAfter(e2.getEntryDate()))
				return 1;
			else if (e2.getEntryDate().isAfter(e1.getEntryDate()))
				return -1;
			else
				return (e2.getEno() + e1.getName()).compareTo(e1.getEno() + e1.getName());
		}
	}

}
