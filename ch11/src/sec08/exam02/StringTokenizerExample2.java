package sec08.exam02;

import java.util.StringTokenizer;

public class StringTokenizerExample2 {
	public static void main(String[] args) {

		String path = System.getenv("PATH");

		StringTokenizer str = new StringTokenizer(path, ";");

		System.out.println("PATH =");
		while (str.hasMoreTokens()) {
			System.out.println(str.nextToken());
		}
	}
}
