package sec03;

public class CheckValueBeforeCasting {
	public static void main(String[] args) {
		int i = 128;
		
		if ((i < Byte.MIN_VALUE) || (i > Byte.MAX_VALUE)) {
			System.out.println("byte 타입으로 변환할 수 없습니다.\n값을 다시 확인해 주세요.");
		} else {
			byte b = (byte) i;
			System.out.println(i);
		}
		
		System.out.println(Short.MAX_VALUE);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Long.MAX_VALUE);
		System.out.println(Float.MAX_VALUE);
		System.out.println(Double.MAX_VALUE);

	}
}
