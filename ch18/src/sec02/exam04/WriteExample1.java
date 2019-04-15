package sec02.exam04;

import java.io.FileWriter;
import java.io.Writer;

public class WriteExample1 {
	public static void main(String[] args) {
		try {
			Writer writer = new FileWriter("D:/workspace/eclipse/hello.txt");
			char[] data = "홍길동".toCharArray();
			for (int i = 0; i < data.length; i++)
				System.out.println(data[i]);
			writer.write(data);
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
