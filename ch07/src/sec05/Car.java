package sec05;

public class Car {
	// Field
	public int speed;

	// method
	public void speedUp() {
		speed += 1;
	}

	// final method
	public final void stop() {
		System.out.println("차를 멈춥니다.");
		speed = 0;
	}
}
