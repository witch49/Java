package day190408.ex02;

public class MemberTest {
	public static void main(String[] args) {
	
		Member m1 = new Member(25);
		Member m2 = new Member(28);
		int result = m1.compareTo(m2);
		
		System.out.println(result);

	}
}
