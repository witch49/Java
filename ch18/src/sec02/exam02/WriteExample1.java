package sec02.exam02;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class WriteExample1 {
	public static void main(String[] args) {
		try {
			OutputStream os = new FileOutputStream("D:/workspace/eclipse/test.txt");
			byte[] data = "ABC".getBytes();
			for (int i = 0; i < data.length; i++)
				os.write(data[i]);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
