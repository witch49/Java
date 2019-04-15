package sec04.exam04;

import java.io.FileReader;

public class FileReaderExample {
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("D:\\workspace\\eclipse\\ch18\\src\\sec04\\exam04\\FileReaderExample.java");

			int readCharNo;
			char[] cbuf = new char[100];
			while ((readCharNo = fr.read(cbuf)) != -1) {
				String data = new String(cbuf, 0, readCharNo);
				System.out.println(data);
			}
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
