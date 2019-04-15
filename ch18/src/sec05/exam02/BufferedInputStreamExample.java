package sec05.exam02;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class BufferedInputStreamExample {
	public static void main(String[] args) throws Exception {
		long start = 0, end = 0;

		FileInputStream fis1 = new FileInputStream("D:\\workspace\\Penguins.jpg");
		start = System.currentTimeMillis();
		while (fis1.read() != -1) { // 1 byte씩 읽어서 굉장히 느림 (1000쯤으로 하면 빠름)
		}
		end = System.currentTimeMillis();
		System.out.println("사용하지 않았을 때: " + (end - start) + "ms");
		fis1.close();
		
		FileInputStream fis2 = new FileInputStream("D:\\workspace\\Penguins.jpg");
		BufferedInputStream bis = new BufferedInputStream(fis2);
		start = System.currentTimeMillis();
		while (bis.read() != -1) {
		}
		end = System.currentTimeMillis();
		System.out.println("사용했을 때: " + (end - start) + "ms");
		bis.close();
		fis2.close();
	}
}
