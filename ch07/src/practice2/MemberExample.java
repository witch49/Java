package practice2;

public class MemberExample {
	public static void main(String[] args) {
		Member member1 = new Member("홍길동", "010-1234-1234", "서울시 강남", "004028", 560);
		member1.show();
		member1.temp = Member.PERSON_CUSTOMER;
		member1.show();
	}
}
