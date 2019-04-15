package sec05.exam04;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamExample {
	public static void main(String[] args) throws Exception {
		FileOutputStream fos = new FileOutputStream("D:/workspace/file.txt");
		PrintStream ps = new PrintStream(fos);

		ps.println("[프린터 보조 스트림]");
		ps.print("마치 ");
		ps.println("프린트가 출력하는 것처럼 ");
		ps.println("데이터를 출력합니다.");

		ps.flush();
		ps.close();
		fos.close();

	}
}
