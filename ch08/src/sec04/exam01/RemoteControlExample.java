package sec04.exam01;

import sec03.exam01.*;

public class RemoteControlExample {
	public static void main(String[] args) {
		RemoteControl rc = null; // interface 변수 선언

		rc = new Television(); // Television 객체를 interface 타입에 대입
		rc.turnOn(); // interface의 turnOn() 호출
		rc.turnOff();

		rc = new Audio();
		rc.turnOn();
		rc.turnOff();
	}
}
