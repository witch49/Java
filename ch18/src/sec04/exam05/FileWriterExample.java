package sec04.exam05;

import java.io.File;
import java.io.FileWriter;

public class FileWriterExample {
	public static void main(String[] args) {
		try {
			File file = new File("D:\\workspace\\file.txt");
			FileWriter fw = new FileWriter(file, true);
			fw.write("FileWriter는 한글로 된 " + "\r\n");
			fw.write("문자열을 바로 출력할 수 있다." + "\r\n");
			fw.flush();
			fw.close();
			System.out.println("파일이 저장되었습니다.");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
