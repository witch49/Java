package day190322.ex02;

public class MyMultiImpl implements MyMulti {
	@Override
	public int max(int[] a) {
		int temp = 0;
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] > a[i + 1]) {
				temp = a[i];
				a[i] = a[i + 1];
				a[i + 1] = temp;
			}
		}
		for (int i = a.length - 1; i > 0; i--) {
			if (a[i] > a[i - 1]) {
				temp = a[i];
				a[i] = a[i - 1];
				a[i - 1] = temp;
			}
		}

		return temp;
	}

	@Override
	public int min(int[] a) {
		int temp = 0;
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] < a[i + 1]) {
				temp = a[i];
				a[i] = a[i + 1];
				a[i + 1] = temp;
			}
		}
		for (int i = a.length - 1; i > 0; i--) {
			if (a[i] < a[i - 1]) {
				temp = a[i];
				a[i] = a[i - 1];
				a[i - 1] = temp;
			}
		}
		return temp;
	}

	@Override
	public int sum(int[] a) {
		int arraySum = 0;
		for (int i : a)
			arraySum += i;
		return arraySum;
	}

	@Override
	public double avg(int[] a) {
		return (double) sum(a) / a.length;
	}

}
