package sec04;

public class AccuraryExample2 {
	public static void main(String[] args) {
		int apple = 1;
		
		int totalPieces = apple * 10;
		int number = 7;
		int temp = totalPieces - number;
		
		double result = temp / 10.0;
		System.out.println("사과 한 개에서 0.7 조각을 빼면");
		System.out.println(result + "조각이 남든다.");
	}
}
