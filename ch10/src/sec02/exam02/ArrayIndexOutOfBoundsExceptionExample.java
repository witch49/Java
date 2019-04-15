package sec02.exam02;

public class ArrayIndexOutOfBoundsExceptionExample {
	/*
	public static void main(String[] args) {
		// Run > Run Configurations > Arguments 입력하면 오류 발생 x 
		String data1 = args[0];
		String data2 = args[1];

		System.out.println("args[0] : " + data1);
		System.out.println("args[1] : " + data2);
	}
	*/
	
	public static void main(String[] args) {
		if (args.length == 2) {
			String data1 = args[0];
			String data2 = args[1];
			System.out.println("args[0] : " + data1);
			System.out.println("args[1] : " + data2);
		} else {
			System.out.println("[실행 방법]");
			System.out.print("Java ArrayIndexOutOfBoundsExceptionExample ");
			System.out.print("값1 값2");
		}
	}
}
