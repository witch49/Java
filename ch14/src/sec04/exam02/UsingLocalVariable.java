package sec04.exam02;

public class UsingLocalVariable {
	void method(int arg) {
		int localVar = 40;	// arg와 localVar은 final 특성
		
		// arg = 30; localVar = 50; // final 특성 때문에 수정 불가

		// 람다식
		MyFunctionalInterface fi = () -> {
			// 로컬 변수 읽기
			System.out.println("arg: " + arg);
			System.out.println("localVar: " + localVar);
		};
		fi.method();
	}

}
