package sec02.exam01;

import java.io.FileInputStream;
import java.io.InputStream;

public class ReadExample3 {
	public static void main(String[] args) {
		try {
			InputStream is = new FileInputStream("D:/workspace/eclipse/test.txt");
			byte[] readBytes = new byte[8];
			is.read(readBytes, 2, 3);
			for (int i = 0; i < readBytes.length; i++)
				System.out.print(readBytes[i] + " ");
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
