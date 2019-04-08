package sec03.exam03;

public class MyFunctionalInterfaceExample {
	public static void main(String[] args) {
		MyFunctionalInterface fi;

		/* 매개 변수가 있는 람다식 */
		fi = (x) -> {
			int result = x * 5;
			System.out.println(result);
		};
		fi.method(2);

		fi = (x) -> {
			System.out.println(x * 5);
		};
		fi.method(2);

		fi = x -> System.out.println(x * 5);
		fi.method(2);
	}
}
