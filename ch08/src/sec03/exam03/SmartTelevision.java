package sec03.exam03;

import sec03.exam01.RemoteControl;

public class SmartTelevision implements Searchable, RemoteControl {
	private int volume;

	@Override
	public void turnOn() {
		System.out.println("SmartTV를 켭니다");
	}

	@Override
	public void turnOff() {
		System.out.println("SmartTV를 끕니다.");
	}

	@Override
	public void setVolume(int volume) {
		if (volume > RemoteControl.MAX_VOLUME)
			this.volume = RemoteControl.MAX_VOLUME;
		else if (volume < RemoteControl.MIN_VOLUME)
			this.volume = RemoteControl.MIN_VOLUME;
		else
			this.volume = volume;
		System.out.println("현재 SmartTV 볼륨 : " + this.volume);
	}

	@Override
	public void search(String url) {
		System.out.println(url + "을/를 검색합니다.");
	}

}
