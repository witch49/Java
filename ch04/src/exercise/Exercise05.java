package exercise;

public class Exercise05 {
	public static void main(String[] args) {
		// 4x + 5y = 60 해 구하기 x<=10, y<=10 자연수
		for (int x = 1; x <= 10; x++)
			for (int y = 1; y <= 10; y++)
				if (4 * x + 5 * y == 60)
					System.out.println("(" + x + "," + y + ")");

	}
}
