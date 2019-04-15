package sec02.exam01;

import java.awt.Toolkit;

public class BeepPrintExample1 {
	public static void main(String[] args) {
		/* 메인 스레드만 이용한 경우 - 비프음 모두 발생 후 '띵' 출력 */

		Toolkit toolkit = Toolkit.getDefaultToolkit(); // toolkit 객체 얻기
		for (int i = 0; i < 5; i++) {
			toolkit.beep(); // 비프음 발생
			try {
				Thread.sleep(500); // 0.5초간 일시정지
			} catch (Exception e) {

			}
		}

		for (int i = 0; i < 5; i++) {
			System.out.println("띵!");
			try {
				Thread.sleep(500);
			} catch (Exception e) {

			}
		}

	}
}
