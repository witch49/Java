package practice.ex02;

public class ClockCount {
	public static void main(String[] args) {
		/**
		 * 디지털 시계에 하루동안(00:00~23:59) 3이 표시되는 시간을 초로 환산하면 총 몇 초(second)인지 계산하는 문제
		 * 
		 * 시계는 hh:mm 으로 표기됨
		 */

		// 시계 표시 > h1h2 : m1m2
		int h1 = 0, h2 = 0;
		int m1 = 0, m2 = 0;
		int count = 0;

		for (h1 = 0; h1 <= 2; h1++) {
			for (h2 = 0; h2 <= 9; h2++) {
				if (h2 == 3) { // x3:xx 인 경우 1시간을 초로 환산해서 count에 값 저장
					count += (60 * 60);
				} else {
					for (m1 = 0; m1 <= 6; m1++) {
						if (m1 == 3) {
							count += (10 * 60); // xx:3x인 경우 10분을 초로 환산해서 count에 값 저장
						} else {
							for (m2 = 0; m2 <= 6; m2++) {
								if (m2 == 3) { // xx:x3인 경우 1분을 초로 환산해서 count에 값 저장
									count += 60;
								}
							}
						}
					}
				}
			}
		}
		System.out.println("하루동안 3이 표시되는 시간은 " + count + "초");

	}
}
