package sec11.exam02;

import java.util.Arrays;

public class EqualsExample {
	public static void main(String[] args) {
		int[][] original = {{1,2}, {3,4}};
		
		/* 얕은 복사 후 비교 */
		System.out.println("[얕은 복제 후 비교]");
		int[][] cloned1 = Arrays.copyOf(original, original.length);
		System.out.println("배열 번지 비교 : " + original.equals(cloned1));
		System.out.println("1차 배열 항목값 비교 : " + Arrays.equals(original, cloned1));
		cloned1[0][0] = 20;
		System.out.println("ex) original[0][0] = " + original[0][0]);
		System.out.println("중첩 배열 항목값 비교 : " + Arrays.deepEquals(original, cloned1) + "\n");
		
		original[0][0] = 1;	// 원래 값으로 되돌리기
		/* 깊은 복사 수 비교 */
		System.out.println("[깊은 복제 후 비교]");
		int[][] cloned2 = Arrays.copyOf(original, original.length);
		cloned2[0] = Arrays.copyOf(original[0], original[0].length);
		cloned2[1] = Arrays.copyOf(original[1], original[1].length);
		System.out.println("배열 번지 비교 : " + original.equals(cloned2));
		System.out.println("1차 배열 항목값 비교 : " + Arrays.equals(original, cloned2));
		cloned2[0][0] = 20;
		System.out.println("ex) original[0][0] = " + original[0][0]);
		System.out.println("중첩 배열 항목값 비교 : " + Arrays.deepEquals(original, cloned2));
	}
}
