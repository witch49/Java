package sec02.exam04;

import java.io.FileWriter;
import java.io.Writer;

public class WriteExample3 {
	public static void main(String[] args) {
		try {
			Writer writer = new FileWriter("D:/workspace/eclipse/hello.txt");
			String data = "안녕 자바 프로그램";
			writer.write(data);
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
