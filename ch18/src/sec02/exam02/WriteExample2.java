package sec02.exam02;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class WriteExample2 {
	public static void main(String[] args) {
		try {
			OutputStream os = new FileOutputStream("D:/workspace/eclipse/test.txt");
			byte[] data = "ABCDE".getBytes();
			os.write(data);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
