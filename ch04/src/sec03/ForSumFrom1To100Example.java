package sec03;

public class ForSumFrom1To100Example {
	public static void main(String[] args) {
		int sum = 0;

//		for (int i = 1; i <= 100; i++)
//			sum += i;
//
//		System.out.println("1~100 합 : "+sum);
		
		int i = 0;	// 카운터 변수
		for (i = 1; i <= 100; i++)
			sum += i;

		System.out.println("1~" + (i-1) + " 합 : " + sum);
		
		
	}
}
