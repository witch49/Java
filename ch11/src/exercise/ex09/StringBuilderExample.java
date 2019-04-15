package exercise.ex09;

public class StringBuilderExample {
	public static void main(String[] args) {
		String str = "";
		for (int i = 1; i <= 100; i++) {
			str += i;
		}
		System.out.println(str);

		System.out.println("[개선 코드] - StringBuilder 이용");
		StringBuilder s = new StringBuilder();
		for (int i = 1; i <= 100; i++)
			s.append(i);
		System.out.println(s);
	}
}
