package sec03.exam02;

public class MyFunctionalInterfaceExample {
	public static void main(String[] args) {
		MyFunctionalInterface fi;
		
		/* 매개 변수와 리턴값이 없는 람다식 */
		fi = () -> {
			String str = "method call1";
			System.out.println(str);
		};
		fi.method();

		fi = () -> {
			System.out.println("method call2");
		};
		fi.method();

		fi = () -> System.out.println("method call3");
		fi.method();

	}
}
