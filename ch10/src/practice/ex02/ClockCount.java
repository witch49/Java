package practice.ex02;

public class ClockCount {
	public static void main(String[] args) {
		/**
		 * 디지털 시계에 하루동안(00:00~23:59) 3이 표시되는 시간을 초로 환산하면 총 몇 초(second)인지 계산하는 문제
		 * 
		 * 시계는 hh:mm 으로 표기됨
		 * 
		 * 다음 3가지 경우에 대해 구하면 됨
		 * 시간 % 10 == 3
		 * 분 / 10 == 3
		 * 분 % 10 == 3
		 */

		int seconds = 0;

		for (int hour = 0; hour < 24; hour++) {
			for (int minute = 0; minute < 60; minute++) {
				if (hour % 10 == 3 || minute / 10 == 3 || minute % 10 == 3) 
					seconds += 60;
				// 혹은
//				String time = hour + ":" + minute;
//				if (time.indexOf("3") >= 0)
//					seconds += 60;
			}
		}

		System.out.println("하루동안 3이 표시되는 시간은 " + seconds + "초");

	}
}
