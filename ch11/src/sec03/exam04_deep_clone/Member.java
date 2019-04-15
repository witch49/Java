package sec03.exam04_deep_clone;

import java.util.Arrays;

public class Member implements Cloneable {
	public String name;
	public int age;
	public int[] scores;
	public Car car;

	public Member(String name, int age, int[] scores, Car car) {
		this.name = name;
		this.age = age;
		this.scores = scores;
		this.car = car;
	}

	// clone() 메소드 ㅈ재정의
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// 먼저 얕은 복사를 해서 name, age를 복제
		Member cloned = (Member) super.clone();// Object의 clone() 호출
		
		// scores를 깊은 복제
		cloned.scores = Arrays.copyOf(this.scores, this.scores.length);
		
		// car를 깊은 복제
		cloned.car = new Car(this.car.model);
		
		// 깊은 복제된 Member 객체를 리턴
		return cloned;
	}

	public Member getMember() {
		Member cloned = null;
		try {
			// clone() 메소드의 리턴 타입은 Object이므로 Member 타입으로 캐스팅해야 함
			cloned = (Member) clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return cloned;
	}

}
