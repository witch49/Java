package sec02;

public class CellPhone {
	// Field
	String model;
	String color;

	// 생성자

	// method
	void powerOn() {
		System.out.println("전원을 켭니다.");
	}

	void powerOff() {
		System.out.println("전원을 끕니다.");
	}

	void bell() {
		System.out.println("벨이 울립니다.");
	}

	void sendVoice(String message) {
		System.out.println("본인 : " + message);
	}

	void receiveVocie(String message) {
		System.out.println("상대방 : " + message);
	}

	void hangup() {
		System.out.println("전화를 끊습니다.");
	}
}
