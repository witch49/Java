package exercise.ex07;

import java.io.*;

public class AddLineNumberExample {
	public static void main(String[] args) throws Exception {
		String path = "D:/workspace/eclipse/ch18/src/exercise/ex07/AddLineNumberExample.java";

		int index = 1;
		String str = null;
		FileReader fr = new FileReader(path);
		BufferedReader bf = new BufferedReader(fr);

		while ((str = bf.readLine()) != null) {
			System.out.printf("%2d: %s\n", index, str);
			index++;
		}
		fr.close();
		bf.close();
	}
}
