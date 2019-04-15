package sec03.exam04_deep_clone;

public class MemberExample {
	public static void main(String[] args) {
		// 원본 객체 생성
		Member original = new Member("홍길동", 25, new int[] { 90, 90 }, new Car("소나타"));

		// 복제 객체를 얻은 후에 참조 객체의 값을 변경
		Member cloned = original.getMember();
		cloned.scores[0] = 100;
		cloned.car.model = "그랜저";

		System.out.println("[복제 객체의 필드값]");
		System.out.print("name=" + cloned.name + ", age=" + cloned.age + ", scores={");
		for (int i = 0; i < cloned.scores.length; i++) {
			System.out.print(cloned.scores[i]);
			System.out.print((i == (cloned.scores.length - 1)) ? "" : ",");
		}
		System.out.print("}, car=" + cloned.car.model + "\n\n");
		
		System.out.println("[원본 객체의 필드값]");
		System.out.print("name=" + original.name + ", age=" + original.age + ", scores={");
		for (int i = 0; i < original.scores.length; i++) {
			System.out.print(original.scores[i]);
			System.out.print((i == (original.scores.length - 1)) ? "" : ",");
		}
		System.out.print("}, car=" + original.car.model);
	}
}
