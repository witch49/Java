package sec03;

public class ForInExample {
	public static void main(String[] args) {
		String[] names = { "홍길동", "김철수", "김영희", "전우치", "박씨부인" };
		for (String name : names)
			System.out.println(name);
		/*
		for (int i = 0; i < names.length; i++)
			System.out.println(names[i]);
		 */
	}
}
