package sec07.exam02;

public class Tire {
	// field
	public int maxRotation; // 최대 회전 수 (타이어 수명)
	public int accumulatedRotation; // 누적 회전 수
	public String location; // 타이어의 위치

	// 생성자
	public Tire(String location, int maxRotation) {
		this.location = location;
		this.maxRotation = maxRotation;
	}

	// method
	public boolean roll() {
		++accumulatedRotation;
		if (accumulatedRotation < maxRotation) { // 정상 회전(누적<최대)
			System.out.println(location + " Tire 수명: " + (maxRotation - accumulatedRotation) + "회");
			return true;
		} else {
			System.out.println("*** " + location + " Tire 펑크 ***");
			return false;
		}
	}
}
