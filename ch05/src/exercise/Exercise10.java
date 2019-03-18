package exercise;

import java.util.Arrays;

public class Exercise10 {
	public static void main(String[] args) {
		// 2차 행렬 곱셈 구하기
		int[][] arr1 = { { 1, 2, 3 }, { 4, 5, 6 } };	// 2x3
		int[][] arr2 = { { 1, 2 }, { 3, 4 }, { 5, 6 } };	// 3x2
		int[][] result = new int[2][2];

		for (int i = 0; i < arr1.length; i++) {
			for (int k = 0; k < arr1[i].length; k++) {
				result[0][i] += arr1[0][k] * arr2[k][i];
				result[1][i] += arr1[1][k] * arr2[k][i];
			}	
		}
		for(int[] i : result)
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
 