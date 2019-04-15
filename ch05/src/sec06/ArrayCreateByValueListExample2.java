package sec06;

public class ArrayCreateByValueListExample2 {
	public static void main(String[] args) {
		int[] scores;
		scores = new int[] { 83, 90, 87 };
		int sum1 = 0;
		// for (int i = 0; i < 3; i++)
		// sum1 += scores[i];
		for (int score : scores)
			sum1 += score;
		System.out.println("총합 : " + sum1);

		//int sum2 = add(new int[] { 83, 90, 87 }); // 리턴된 총합을 sum2에 저장
		int sum2 = add(scores); // 리턴된 총합을 sum2에 저장
		System.out.println("총합 : " + sum2);
		add2(scores);
	}

	public static int add(int[] scores) {
		int sum = 0;
//		for (int i = 0; i < 3; i++)
//			sum += scores[i];
		for (int score : scores)
			sum += score;
		return sum;
	}
	public static void add2(int[] scores) {
		int sum = 0;
		for (int score : scores)
			sum += score;
		System.out.println("총합은 " + sum);
	}
}
