package sec02.exam01;

import java.io.FileInputStream;
import java.io.InputStream;

public class ReadExample2 {
	public static void main(String[] args) {
		try {
			InputStream is = new FileInputStream("D:/workspace/eclipse/test.txt");
			int readByteNo;
			byte[] readBytes = new byte[4];	// 4자씩 읽어오기
			String data = "";
			while (true) {
				readByteNo = is.read(readBytes);
				System.out.println(readByteNo);
				if (readByteNo == -1)
					break;
				data += new String(readBytes, 0, readByteNo);
			}
			System.out.println(data);
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
