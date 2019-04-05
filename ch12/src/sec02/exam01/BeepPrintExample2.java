package sec02.exam01;

import java.awt.Toolkit;

public class BeepPrintExample2 {

	public static void main(String[] args) {
		/* 메인 스레드와 작업 스레드가 동시에 실행 */

		// 방법 1 - beepTask 객체 생성
/*		Runnable beepTask = new BeepTask();
		Thread thread = new Thread(beepTask);
		thread.start();*/

		// 방법 2 - Runnable 익명 객체 사용
/*		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				for (int i = 0; i < 5; i++) {
					toolkit.beep();
					try {
						Thread.sleep(500);
					} catch (Exception e) {
					}
				}
			}
		});
		thread.start();*/
		
		// 방법 3 - 람다식 이용
		Thread thread = new Thread(() -> {
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			for (int i = 0; i < 5; i++) {
				toolkit.beep();
				try {
					Thread.sleep(500);
				} catch (Exception e) {
				}
			}

		});
		thread.start();

		
		for (int i = 0; i < 5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500);
			} catch (Exception e) {

			}
		}

	}

}
