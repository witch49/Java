package sec02.exam03;

import java.io.FileReader;
import java.io.Reader;

public class ReadExample2 {
	public static void main(String[] args) {
		try {
			Reader reader = new FileReader("D:/workspace/eclipse/hello.txt");
			int readCharNo;
			char[] cbuf = new char[2];
			String data = "";
			while (true) {
				readCharNo = reader.read(cbuf);
				System.out.println(readCharNo);
				if (readCharNo == -1)
					break;
				data += new String(cbuf, 0, readCharNo);
			}
			System.out.println(data);
			reader.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
