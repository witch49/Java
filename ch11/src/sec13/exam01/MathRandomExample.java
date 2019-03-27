package sec13.exam01;

public class MathRandomExample {
	public static void main(String[] args) {
		int num = (int) Math.floor(Math.random() * 6) + 1;
		System.out.println("주사위 값:" + num);
	}
}
