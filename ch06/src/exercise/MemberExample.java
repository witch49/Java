package exercise;

public class MemberExample {
	public static void main(String[] args) {
		Member user1 = new Member("홍길동", "hong");
		Member user2 = new Member("강자바", "java");
		System.out.println(user1.name + ", " + user1.id);
		System.out.println(user2.name + ", " + user2.id);
	}
}
