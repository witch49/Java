package sec07.exam01;

public interface MyInterface {
	public abstract void method1();

	// 이후 추가한 메소드 - MyClassA에서 오류 발행하지 않음
	public default void method2() {
		System.out.println("MyInterface - method2() 실행");
	}
}
