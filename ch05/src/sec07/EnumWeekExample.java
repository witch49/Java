package sec07;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class EnumWeekExample {
	public static void main(String[] args) {
		Week today = null; // 열거 타입 변수 선언

		Calendar cal = Calendar.getInstance();
		int week = cal.get(Calendar.DAY_OF_WEEK); // 일(1)~토(7)까지의 숫자 리턴

		switch (week) {
		case 1:
			today = Week.SUNDAY; // 열거 상수 대입
			break;
		case 2:
			today = Week.MONDAY;
			break;
		case 3:
			today = Week.TUESDAY;
			break;
		case 4:
			today = Week.WEDNESDAY;
			break;
		case 5:
			today = Week.THURSDAY;
			break;
		case 6:
			today = Week.FRIDAY;
			break;
		case 7:
			today = Week.SATURDAY;
			break;
		}
		System.out.println("오늘 요일 : " + today);

		if (today == Week.SUNDAY)
			System.out.println("일요일에는 축구를 합니다.");
		else
			System.out.println("열심히 자바 공부합니다.");
		
		// cf) 날짜 입력받는 다른 방법
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy년MM월dd일(E요일) HH시mm분ss초");
		String format_time1 = format1.format(cal.getTime());
		String format_time2 = format2.format(cal.getTime());;
		System.out.println(format_time1);
		System.out.println(format_time2);
		
	}
}
