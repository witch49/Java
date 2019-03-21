package sec05;

public class SportsCar extends Car {
	@Override
	public void speedUp() {
		speed += 10;
	}
/* 오버라이딩 불가
	@Override
	public void stop() {
		System.out.println("스포츠카를 멈춥니다.");
		speed = 0;
	}
*/
}
