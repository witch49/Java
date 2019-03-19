package sec08;

public class CarTest {
	// field
	int speed;

	// Generator

	// method
	int getSpeed() {
		return speed;
	}

	void keyTurnOn() {
		System.out.println("키를 돌립니다.");
	}

	void run() {
		for (int i = 10; i <= 50; i+=10) {
			speed = i;
			System.out.println("달립니다.(시속 " + speed + "km/h)");
		}
	}
}
