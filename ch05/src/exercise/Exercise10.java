package exercise;

import java.util.Arrays;

public class Exercise10 {
	public static void main(String[] args) {
		// 2차 행렬 곱셈 구하기
		int[][] arr1 = { { 1, 2, 3 }, { 4, 5, 6 } };	// 2x3
		int[][] arr2 = { { 1, 2 }, { 3, 4 }, { 5, 6 } };	// 3x2
		
		System.out.println("arr1의 배열 >>");
		print(arr1);
		System.out.println("\narr2의 배열 >>");
		print(arr2);
		System.out.println("\n둘을 곱한 배열 >>");
        int[][] result = mathMultiple(arr1, arr2);
        print(result);
	}
	
	/* 두 행렬을 곱하는 메소드 */
	public static int[][] mathMultiple(int[][] x, int[][] y) {
		int[][] result = new int[x.length][y[0].length];
		
		for (int row = 0; row < x.length; row++) 
			for (int col = 0; col < y[row].length; col++) 
				for(int i = 0; i < y.length; i++) 
					result[row][col] += x[row][i] * y[i][col];
		
		return result;
	}
	
	/* 행렬 출력 메소드 */
	public static void print(int[][] arr) {
		for(int[] i : arr)
			System.out.println(Arrays.toString(i));
	}
}
/**
 * 1x1 부분
 * (1,1) x (1,1)
 * (1,2) x (2,1)
 * (1,3) x (3,1)
 * 
 * 1x2 부분
 * (1,1) x (1,2)
 * (1,2) x (2,2)
 * (1,3) x (3,2)
 * 
 * 2x1 부분
 * (2,1) x (1,1)
 * (2,2) x (2,1)
 * (2,3) x (3,1)
 * 
 * 2x2 부분
 * (2,1) x (1,2)
 * (2,2) x (2,2)
 * (2,3) x (3,2)
 * */
 