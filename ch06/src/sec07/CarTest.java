package sec07;

public class CarTest {

	// field
	String company = "현대자동차";
	String model;
	String color;
	int maxSpeed;

	/**
	 * 생성자 생성하기
	 *  우클릭 > Source > Generate Constructor using fields 
	 *  */
	
	// 생성자
	CarTest() {

	}

	CarTest(String model) {
		this.model = model;
	}

//	CarTest(String model, String color) {
//		this.model = model;
//		this.color = color;
//	}
	CarTest(String model, String color) {
		this(model, color, 0);
	}

	CarTest(String model, String color, int maxSpeed) {
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}

	@Override
	public String toString() {
		return "CarTest [company=" + company + ", model=" + model + ", color=" + color + ", maxSpeed=" + maxSpeed + "]";
	}

	public String print(int number) {
		return "CarTest" + number + " [company=" + company + ", model=" + model + ", color=" + color + ", maxSpeed="
				+ maxSpeed + "]";
	}

}
