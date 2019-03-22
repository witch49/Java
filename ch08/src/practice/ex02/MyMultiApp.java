package practice.ex02;

public class MyMultiApp {
	public static void main(String[] args) {
		int[] a = { 43, 24, 4, 19, 71 };

		MyMulti mm = new MyMultiImpl();

		System.out.println("배열 원소의 최댓값 : " + mm.max(a));
		System.out.println("배열 원소의 최솟값 : " + mm.min(a));
		System.out.println("배열 원소의 합 : " + mm.sum(a));
		System.out.println("배열 원소의 평균 : " + mm.avg(a));
	}
}
