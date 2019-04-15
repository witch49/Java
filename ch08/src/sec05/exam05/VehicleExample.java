package sec05.exam05;

import sec05.exam04.Vehicle;

public class VehicleExample {
	public static void main(String[] args) {
		Vehicle vehicle = new Bus();

		vehicle.run();
		// vehicle.checkFare(); //(x)

		Bus bus = (Bus) vehicle; // 강제 타입 변환

		bus.run();
		bus.checkFare(); // Bus class에 checkFare()가 있음
	}
}
