package sec02.exam01;

import java.io.FileInputStream;
import java.io.InputStream;

public class ReadExample1 {
	public static void main(String[] args) {
		try {
			InputStream is = new FileInputStream("D:/workspace/eclipse/test.txt");
			int readByteNo;
			while (true) {
				readByteNo = is.read();
				if (readByteNo == -1)
					break;
				System.out.println((char) readByteNo);
			}
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
