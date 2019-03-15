package sec04;

public class InputDataCheckNaNExample {
	public static void main(String[] args) {
		String userInput = "NaN";
		double val = Double.valueOf(userInput);	// val에 NaN 저장
		double currentBalance = 10000.0;
		
		if(Double.isNaN(val)) {
			System.out.println("NaN이 잆력되어 처리할 수 없음");
			val = 0.0;
		}
		currentBalance += val;	// val=0이어서 currentBalance값 원래대로 유지됨
		System.out.println(currentBalance);
	}
}
