package sec05.exam06;

import sec05.exam04.Vehicle;
import sec05.exam05.Bus;

public class Driver {
	public void drive(Vehicle vehicle) {
		if (vehicle instanceof Bus) {
			Bus bus = (Bus) vehicle;
			bus.checkFare();
		}
		vehicle.run();
	}
}
