package sec13.exam03_field_method_access.package2;

import sec13.exam03_field_method_access.package1.*;

public class C {
	public C() {
		A a = new A();
		a.field1 = 1;
		// a.field2 = 1; // 컴파일 에러. default 필드 접근 불가.
		// a.field3 = 1; // 컴파일 에러. private 필드 접근 불가.

		a.method1();
		// a.method2(); // 컴파일 에러. default 메소드 접근 불가.
		// a.method3(); // 컴파일 에러. private 메소드 접근 불가.
	}
}
