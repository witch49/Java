package sec02.exam02;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class WriteExample3 {
	public static void main(String[] args) {
		try {
			OutputStream os = new FileOutputStream("D:/workspace/eclipse/test.txt");
			byte[] data = "ABCDEFG".getBytes();
			os.write(data, 1, 2); // offset=1, length=2
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
