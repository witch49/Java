package sec14.exam02;

import java.util.*;

public class PrintTimeZoneID {
	public static void main(String[] args) {
/*		String[] availableIDs = TimeZone.getAvailableIDs();
		for (String id : availableIDs)
			System.out.println(id);*/

		TimeZone tz = TimeZone.getTimeZone("US/Hawaii");
		System.out.println("US/Hawaii");
		Calendar nowHW = Calendar.getInstance(tz);
		System.out.print(nowHW.get(Calendar.MONTH) + 1 + "월 ");
		System.out.print(nowHW.get(Calendar.DAY_OF_MONTH) + "일 ");
		System.out.print(nowHW.get(Calendar.HOUR) + "시 ");
		System.out.println(nowHW.get(Calendar.MINUTE) + "분");

	}
}
