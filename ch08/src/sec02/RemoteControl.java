package sec02;

public interface RemoteControl {

	/**
	 * 상수 필드
	 * 
	 * public static final 안붙이더라도 자동적으로 붙음
	 */
	public int MAX_VOLUME = 10;
	public static final int MIN_VOLUME = 0;

	/**
	 * 추상 메소드(abstract method)
	 * 
	 * public abstract 안붙이더라도 자동적으로 붙음
	 */
	void turnOn();

	void turnOff();

	public abstract void setVolume(int volume);

	/**
	 * 디폴트 메소드(default method)
	 * 
	 * default 는 생략 불가능(반드시 붙여야 함)
	 * 
	 * public 안붙이더라도 자동적으로 붙음
	 */
	default void setMute(boolean mute) {
		if (mute)
			System.out.println("무음 처리합니다.");
		else
			System.out.println("무음 해제합니다.");
	}

	/**
	 * 정적 메소드(static method)
	 * 
	 * public 안붙이더라도 자동적으로 붙음
	 */
	public static void changeBattery() {
		System.out.println("건전지를 교환합니다.");
	}
}
