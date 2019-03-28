package linkedList;

import java.io.*;

public class Test {
	/* 파일 입력 추가 메소드 */
	public static void main(String[] args) throws FileNotFoundException {
		
		RecursionLinkedList list = new RecursionLinkedList();
		FileReader fr;
		try {
			fr = new FileReader("D:\\workspace\\eclipse\\practice\\src\\linkedList\\hw01.txt");
			BufferedReader br = new BufferedReader(fr);
			String inputString = br.readLine();
			for (int i = 0; i < inputString.length(); i++)
				list.add(inputString.charAt(i));
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(list.toString());
		list.add(3, 'b');
		System.out.println(list.toString());
		//list.reverse();
		//System.out.println(list.toString());
		// 등등 구현한 기능 추가해서 사용
	}

}
