package sec02.exam05;

import java.io.*;

public class GeneralExceptionFileExample {
	public static void main(String[] args) {
		String path = "D:\\workspace\\eclipse\\ch10\\src\\sec02\\exam05\\test.txt";
		try {
			File file = new File(path);
			FileWriter fw = new FileWriter(file, true);
			fw.write("\nA quick brown fox ~");
			fw.flush();
			
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
