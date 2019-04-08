package day190408.ex03;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Timer {
	public static void main(String[] args) {
		/**
		 * 남은 퇴근 시간을 계산하는 프로그램
		 * 
		 * 입력: 현재 시간을 hh:mm:ss 형식으로 입력
		 * 
		 * 출력: 퇴근 시간을 18:30:00 으로 가정하고 퇴근 시간까지 남은 시간을 출력
		 * 
		 */

		Scanner sc = new Scanner(System.in);
		System.out.print("현재 시간을 입력하세요(형식: hh:mm:ss)> ");
		String time = sc.nextLine();

		StringTokenizer st = new StringTokenizer(time, ":");
		int[] timeEval = { 0, 0, 0 };

		while (st.hasMoreTokens()) {
			String temp = st.nextToken();
			int count = st.countTokens();
			timeEval[count] = Integer.parseInt(temp);
		}

		// timeEval[0] = 초, [1] = 분, [2] = 시

		timeCounter(timeEval[0], timeEval[1], timeEval[2]);

		sc.close();
	}

	public static void timeCounter(int s, int m, int h) {
		if (h > 18)
			System.out.println("퇴근 시간을 초과하였습니다.");
		else if (h == 18 && m > 30)
			System.out.println("퇴근 시간을 초과하였습니다.");
		else {
			if (s > 0 && m < 30)
				System.out.println("남은 퇴근 시간은 " + (18 - h) + ":" + (30 - 1 - m) + ":" + (60 - s));
			else if (s > 0 && m >= 30)
				System.out.println("남은 퇴근 시간은 " + (18 - 1 - h) + ":" + (30 + 60 - 1 - m) + ":" + (60 - s));
		}
	}

}
