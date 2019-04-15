package sec03;

public class WhileKeyControlExample {
	public static void main(String[] args) throws Exception {
		boolean run = true;
		int speed = 0;
		int keyCode = 0;

		while (run) {
			// enter 입력 시 캐리지리턴(13)과 라인피드(10)가 입력되므로 이 값을 제외시킴
			if (keyCode != 13 && keyCode != 10) {
				System.out.println("-------------------------------------------------------");
				System.out.println("1. 증속 | 2. 감속 | 3. 급증속 | 4.급감속 | 5. 중지");
				System.out.println("-------------------------------------------------------");
				System.out.print("선택 : ");
			}

			keyCode = System.in.read(); // 키보드의 키 코드 읽기

			if (keyCode == 49)
				System.out.println("현재 속도 : " + ++speed);
			else if (keyCode == 50) {
				if (--speed < 0) {
					System.out.println("음수이므로 불가능합니다.");
					speed = 0;
				} else
					System.out.println("현재 속도 : " + speed);
			} else if (keyCode == 51)
				System.out.println("현재 속도 : " + (speed += 10));
			else if (keyCode == 52)
				if ((speed -= 10) < 0) {
					System.out.println("음수이므로 불가능합니다.");
					speed = 0;
				} else
					System.out.println("현재 속도 : " + speed);
			else if (keyCode == 53)
				run = false; // while문 종료
		}
		System.out.println("프로그램 종료");
	}
}
