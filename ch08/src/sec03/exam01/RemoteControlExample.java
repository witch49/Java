package sec03.exam01;

public class RemoteControlExample {
	public static void main(String[] args) {
		RemoteControl rc;
		rc = new Television();
		rc.turnOff();
		rc = new Audio();
		rc.turnOn();
		rc.setVolume(13);
		rc.setVolume(5);
		rc.setVolume(-1);

		// 익명 개체 구현
		RemoteControl rc2 = new RemoteControl() {
			@Override
			public void turnOn() {
				System.out.println("추상 메소드 turnOn() 구현");
			}
			@Override
			public void turnOff() {
				System.out.println("추상 메소드 turnOff() 구현");
			}
			@Override
			public void setVolume(int volume) {
				System.out.println("추상 메소드 setVolume() 구현 - volume" + volume);
			}
		};

		rc2.turnOn();
		rc2.turnOff();
		rc2.setVolume(2);
		rc2.setMute(true);
	}
}
