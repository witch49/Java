package sec05.exam03;

public class SystemTimeExample {
	public static void main(String[] args) {
		long time1 = System.nanoTime(); // 시작 시간 읽기
		//long time1 = System.currentTimeMillis();
		int sum = 0;
		for (int i = 0; i < 1000000; i++)
			sum += i;

		long time2 = System.nanoTime(); // 종료 시간 읽기
		//long time2 = System.currentTimeMillis();
		System.out.println("1 ~ 1000000 까지의 합 : " + sum);
		System.out.println("걸린 시간 : " + (time2 - time1) + " nano seconds");
	}
}
