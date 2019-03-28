package recursion;

import java.util.*;

public class FaerySequence {
	public static void main(String[] args) throws Exception {
		// 페리 수열을 recursion을 사용해 나타내기

		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요(1~100 사이) : ");
		int input = sc.nextInt();
		if ((input > 100) || (input < 1)) {
			sc.close();
			throw new Exception("입력값이 범위를 벗어났습니다.");
		}
		System.out.print(faeryArray(input));
		sc.close();
	}

	/* 분자 */
	public static String faeryH(int h, int k) {
		if (h == k)
			return "";
		else {
			if (gcdCheck(h, k) == 1) // 기약진분수인 경우
				return h + "/" + k + ", " + faeryH(h + 1, k);
			else
				return faeryH(h + 1, k);
		}
	}

	/* 분모 */
	public static String faeryK(int h, int k) {
		return "";
	}
	
	public static String faeryHK(int h, int k) {
		String[] str = faeryH(h,k).split(", ");
		double dol = Double.parseDouble(str[0]);
		return "";
	}

	/* 최대공약수가 1인지 체크 */
	public static int gcdCheck(int h, int k) {
		if (k == 0)
			return h; // h=최대공약수 //if (gcdCheck(h,k) != 1) {...}
		else
			return gcdCheck(k, h % k);
	}

	/* 해당 인덱스의 페리 수열 출력 */
	public static String faeryElement(int input) {
		if (input == 1)
			return "";
		else
			return faeryH(1, input) + faeryElement(input - 1);
	}

	/* ', ' 구분자로 원소 자르기 */
	public static String splitElement(int input) {
		String[] str = faeryH(1,input).split(", ");
		return "";
		//String str0 = faeryH(1,input).split(", ")[0];
		//String str1 = faeryH(1,input).split(", ")[1];
		//return str[0];
	}

	/* 정렬 메소드 */
	public static String sortElement(int input) {
		splitElement(input);
		return "";
	}

	/* 페리 수열 출력 메소드 */
	// 역순 출력 방지를 위해 꼬리 재귀 사용
	public static String faeryArray(int input) {
		if (input == 1)
			return "f1:{0/1, 1/1}";
		else
			return "f" + input + ":{0/1, " + faeryElement(input) + "1/1}\n" + faeryArray(input - 1);
	}

	/* 오름차순 정렬 메소드 */
	public void sortFaery(int h, int k) {
		faeryH(h, k);
		// g/h 값이 가장 작은 순서로 정렬
	}

	/* 역순으로 된 걸 정방향으로 출력 */
	// public void reverseFaery(int a[], int begin, int end) {
	// if (begin < end) {
	// swap(a, begin, end);
	// reverseFaery(a, begin + 1, end - 1);
	// }
	// }
	//
	// void swap(int arr[], int a, int b) {
	// int temp = arr[a];
	// arr[a] = arr[b];
	// arr[b] = temp;
	// }
}
