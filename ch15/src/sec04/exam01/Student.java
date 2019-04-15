package sec04.exam01;

public class Student {
	public int sno;
	public String name;

	public Student(int sno, String name) {
		this.sno = sno;
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			Student student = (Student) obj;
			return name.equals(student.name);
		}
		else
			return false;
	}
	
	@Override
	public int hashCode() {
		return sno;
	}

}
