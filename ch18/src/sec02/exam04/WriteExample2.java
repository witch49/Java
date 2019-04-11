package sec02.exam04;

import java.io.FileWriter;
import java.io.Writer;

public class WriteExample2 {
	public static void main(String[] args) {
		try {
			Writer writer = new FileWriter("D:/workspace/eclipse/hello.txt");
			char[] data = "홍길동".toCharArray();
			writer.write(data, 1, 2);
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
