package day190410.ex03;

import java.time.LocalDate;

enum Type {
	// 부장, 차장, 과장, 대리, 사원
	GeneralManager, DeputyGeneralManager, Manager, AssistantManager, Staff
}

public class Employee {
	private int eno;
	private String name;
	private Type position;
	private LocalDate entryDate;

	public Employee(int eno, String name, Type position, LocalDate entryDate) {
		this.eno = eno;
		this.name = name;
		this.position = position;
		this.entryDate = entryDate;
	}

	public Employee() {

	}

	public int getEno() {
		return eno;
	}

	public String getName() {
		return name;
	}

	public Type getPosition() {
		return position;
	}

	public LocalDate getEntryDate() {
		return entryDate;
	}

}
