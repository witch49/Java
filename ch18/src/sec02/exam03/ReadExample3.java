package sec02.exam03;

import java.io.FileReader;
import java.io.Reader;

public class ReadExample3 {
	public static void main(String[] args) {
		try {
			Reader reader = new FileReader("D:/workspace/eclipse/hello.txt");
			char[] cbuf = new char[4];
			int readCharNo = reader.read(cbuf, 1, 2);
			System.out.println(readCharNo + "\n-----------");
			for (int i = 0; i < cbuf.length; i++)
				System.out.println(i + "\t" + cbuf[i]);
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
