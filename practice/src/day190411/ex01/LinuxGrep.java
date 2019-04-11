package day190411.ex01;

import java.util.*;
import java.io.*;

public class LinuxGrep {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("[입력 예시]\n찾을 문자열: public\n찾을 파일명: D:/workspace/eclipse/practice/src/day190411/ex01/LinuxGrep.java\n");
		System.out.print("찾을 문자열: ");
		String findStr = sc.nextLine();
		System.out.print("찾을 파일명: ");
		String findFile = sc.nextLine();
		System.out.println();
		
		int index = 1;
		String str = null;
		FileReader fr = new FileReader(findFile.trim());
		BufferedReader bf = new BufferedReader(fr);

		while ((str = bf.readLine()) != null) {
			if (str.matches(".*" + findStr.trim() + ".*") == true)
				System.out.printf("%2d: %s\n", index, str);
			index++;
		}
		sc.close();
		fr.close();
		bf.close();
	}
}
