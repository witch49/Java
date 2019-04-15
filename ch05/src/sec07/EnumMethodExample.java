package sec07;

public class EnumMethodExample {
	public static void main(String[] args) {
		// name() method
		Week today = Week.SUNDAY;
		String name = today.name();
		System.out.println(name);

		// ordinal() method
		int ordinal = today.ordinal(); // SUNDAY가 몇 번째 열거 객체인지 ordinal에 저장
		System.out.println(ordinal);

		// compareTo() method
		Week day1 = Week.MONDAY;
		Week day2 = Week.WEDNESDAY;
		int result1 = day1.compareTo(day2); // 0 < 2
		int result2 = day2.compareTo(day1); // 2 > 0
		System.out.println(result1); // -2
		System.out.println(result2); // 2

		// valueOf() method
		if (args.length == 1) {
			String strDay = args[0];
			Week weekDay = Week.valueOf(strDay);
			if (weekDay == Week.SATURDAY || weekDay == Week.SUNDAY)
				System.out.println("주말이네요.");
			else
				System.out.println("평일이네요.");
		}

		// values() method
		Week[] days = Week.values();
		for (Week day : days)
			System.out.println(day);

	}
}
