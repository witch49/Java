package sec02;

public class LongExample {
	public static void main(String[] args) {
		long var1 = 10;		// 에러 안나더라도 뒤에 L 붙이는 게 좋음
		long var2 = 20L;
		// long var3 = 10000000000;	// 컴파일 에러
		long var4 = 10000000000L;

		System.out.println(var1);
		System.out.println(var2);
		System.out.println(var4);
	}
}
