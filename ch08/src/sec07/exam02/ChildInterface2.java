package sec07.exam02;

public interface ChildInterface2 extends ParentInterface {
	@Override
	public default void method2() {
		System.out.println("ChildInterface2 - method2() 실행");
	}
	
	public abstract void method3();

}
