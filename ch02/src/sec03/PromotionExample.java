package sec03;

public class PromotionExample {
	public static void main(String[] args) {
		byte byteValue = 10;
		int intValue = byteValue;		// int <- byte 자동 타입 변환
		System.out.println(intValue);
		
		char charValue = '가';
		intValue = charValue;			// int <- char
		System.out.println("가 의 유니코드 : " + intValue);
		
		intValue = 500;
		long longValue = intValue;		// long <- int
		System.out.println(longValue);
		
		intValue = 200;
		double doubleValue = intValue;	// double <- int
		System.out.println(doubleValue);
		
		longValue = 12345678900L;
		float floatValue = longValue;	// float <- long
		System.out.println(floatValue);
		doubleValue = longValue;		// double <- long
		System.out.println(doubleValue);
	}
}
