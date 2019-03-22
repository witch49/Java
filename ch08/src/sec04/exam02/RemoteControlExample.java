package sec04.exam02;

import sec03.exam01.*;

public class RemoteControlExample {
	public static void main(String[] args) {
		RemoteControl rc = null;

		rc = new Television();
		rc.turnOn();
		rc.setMute(true);

		rc = new Audio();
		rc.turnOn();
		rc.setMute(false);

		// 정적 메소드 호출
		RemoteControl.changeBattery();
		// 디폴트 메소드는 아래와 같이 호출할 수 없음
		// RemoteControl.setMute(true);
	}
}
