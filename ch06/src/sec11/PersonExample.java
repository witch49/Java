package sec11;

public class PersonExample {
	public static void main(String[] args) {
		Person p1 = new Person("911111-1111111", "계백");
		
		System.out.println(p1.nation + "\n" + p1.ssn + "\n" + p1.name);
//		p1.name = "을지문덕";
	}
}
