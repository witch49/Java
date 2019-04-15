package sec07.exam01_2;

public class ChildExample {
	public static void main(String[] args) {
		Child child = new Child();
		Parent parent = child; // 자동 타입 변환
		// Parent parent = new Child(); // 위 2줄과 동일

		parent.method1();
		parent.method2(); // 재정의된 메소드 호출
		// parent.method3(); // 호출 불가능
	}

}
