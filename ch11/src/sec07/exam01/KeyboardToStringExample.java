package sec07.exam01;

import java.io.IOException;

public class KeyboardToStringExample {
	public static void main(String[] args) throws IOException {
		byte[] bytes = new byte[100];

		System.out.print("입력> ");
		int readByteNo = System.in.read(bytes);
		for (int i = 0; i < readByteNo; i++)
			System.out.print(bytes[i] + " ");
		System.out.println();

		String str = new String(bytes, 0, readByteNo - 2);
		System.out.println(readByteNo + ", " + str);
	}
}
