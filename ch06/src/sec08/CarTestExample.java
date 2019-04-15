package sec08;

public class CarTestExample {
	public static void main(String[] args) {
		CarTest myCar = new CarTest();
		myCar.keyTurnOn();
		myCar.run();
		int speed = myCar.getSpeed();
		System.out.println("현재 속도 : " + speed + "km/h");
	}
}
