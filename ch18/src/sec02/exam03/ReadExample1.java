package sec02.exam03;

import java.io.FileReader;
import java.io.Reader;

public class ReadExample1 {
	public static void main(String[] args) {
		try {
			Reader reader = new FileReader("D:/workspace/eclipse/hello.txt");
			int readData;
			while (true) {
				readData = reader.read();
				if (readData == -1)
					break;
				System.out.println((char) readData);
			}
			reader.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
