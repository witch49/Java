package recursion;

import java.math.BigInteger;
import java.util.*;

public class DoubleFactorial {
	public static void main(String[] args) throws Exception {
		// 다중 계승 중 이중 계승(double factorial)을 recursion을 이용해 구현하기
		// 입력값 범위는 1<=input<=100
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요(1~100 사이) : ");
		int input = sc.nextInt();
		if((input > 100) || (input < 1)) {
			//System.out.println("입력값이 범위를 벗어났습니다.");
			//exit(0);
			throw new Exception("입력값이 범위를 벗어났습니다."); 
		}
		
		System.out.println(input + "!! = " + doubleFactorial(input));
	}
	
	public static BigInteger doubleFactorial(int n) {
		if ((n%2) == 0) {	// 입력값이 짝수인 경우
			if (n < 1)
				return BigInteger.ONE;
			else 
				return doubleFactorial(n-2).multiply(BigInteger.valueOf(n));
		} else {	// 입력값이 홀수인 경우
			if (n == 1)
				return BigInteger.ONE;
			else 
				return doubleFactorial(n-2).multiply(BigInteger.valueOf(n));
		}
	}
}
