package day190411.ex02;

import java.io.*;
import java.util.*;

public class HexaDump {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("[입력 예시] D:/workspace/eclipse/practice/bin/day190411/ex02/HexaDump.class");
		System.out.print("찾을 파일명(확장자명 .class): ");
		String path = sc.nextLine();

		int index = 0, count = 0, data = 0;
		int[] arr = new int[16];

		FileInputStream fis = new FileInputStream(path.trim());
		
		while ((data = fis.read()) != -1) {
			if ((index % 8) == 0)
				System.out.print(" ");
			if ((index % 16) == 0)
				System.out.printf("\n%08d:  ", index);

			String s = String.format("%02X", data);
			System.out.print(s + " ");

			// (index % 16) == 1
			arr[count] = data;
			if ((count == 15) && index != 0) {
				for (int i = 0; i < 16; i++) {
					if ((char) arr[i] >= 65 && (char) arr[i] <= 90)
						System.out.print((char) arr[i]);
					else if ((char) arr[i] >= 97 && (char) arr[i] <= 122)
						System.out.print((char) arr[i]);
					else
						System.out.print(".");
				}
				count = -1;
			}

			index++;
			count++;
		}

		fis.close();
		sc.close();
	}
}
