package sec05.exam03;

import sec05.exam02.*;

public class CarExample {
	public static void main(String[] args) {
		Car myCar = new Car();
		myCar.run();
		System.out.println("---------------------------");
		
		myCar.tires[0] = new KumhoTire();
		myCar.tires[1] = new KumhoTire();
		myCar.run();
	}
}
