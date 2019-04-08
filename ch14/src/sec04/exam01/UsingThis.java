package sec04.exam01;

public class UsingThis {
	public int outterField = 10;

	class Inner {
		int innerField = 20;

		void method() {
			// 람다식
			MyFunctionalInterface fi = () -> {
				System.out.println("OutterField: " + outterField);
				// 바깥 객체의 참조를 얻기 위해서는 클래스명.this 를 사용
				System.out.println("OutterField: " + UsingThis.this.outterField + "\n");

				System.out.println("InnerField: " + innerField);
				// 람다식 내부에서 this는 inner 객체를 참조
				System.out.println("InnerField: " + this.innerField + "\n");
			};
			fi.method();
		}
	}
}
