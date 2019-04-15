package sec09;

public class Car {
	// Field
	String model;
	int speed;

	// 생성자
	Car(String model) {
		this.model = model;
	}

	// method
	void setSpeed(int speed) {
		this.speed = speed;
	}

	void run() {
		for (int i = 10; i <= 50; i += 10) {
			this.setSpeed(i);
			System.out.println(this.model + "가 달립니다. (시속 " + this.speed + "km/h)");
		}
	}

	@Override
	public String toString() {
		return "Car [model=" + model + ", speed=" + speed + "]";
	}
	
}
