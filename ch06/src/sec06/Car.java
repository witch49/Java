package sec06;

public class Car {
	// field
	// default : 같은 package 안에서 사용 가능(그 외 public, protected, private)
	String company = "현대자동차";
	String model = "그랜져";
	String color = "검정";
	int maxSpeed = 350;
	private int speed;
	
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
}
