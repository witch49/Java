package sec15.exam01;

import java.text.DecimalFormat;

public class DecimalFormatExample {
	public static void main(String[] args) {
		double num = 1234567.89;

		DecimalFormat df = new DecimalFormat("0");
		System.out.println("0\t\t\t\t"+df.format(num));

		df = new DecimalFormat("0.0");
		System.out.println("0.0\t\t\t\t" + df.format(num));

		df = new DecimalFormat("0000000000.00000");
		System.out.println("0000000000.00000\t\t" + df.format(num));

		df = new DecimalFormat("#");
		System.out.println("#\t\t\t\t" + df.format(num));

		df = new DecimalFormat("#.#");
		System.out.println("#.#\t\t\t\t" + df.format(num));

		df = new DecimalFormat("##########.#####");
		System.out.println("##########.#####\t\t" + df.format(num));

		df = new DecimalFormat("#.0");
		System.out.println("#.0\t\t\t\t" + df.format(num));

		df = new DecimalFormat("+#.0");
		System.out.println("+#.0\t\t\t\t" + df.format(num));

		df = new DecimalFormat("-#.0");
		System.out.println("-#.0\t\t\t\t" + df.format(num));

		df = new DecimalFormat("#,###.0");
		System.out.println("#,###.0\t\t\t\t" + df.format(num));

		df = new DecimalFormat("0.0E0");
		System.out.println("0.0E0\t\t\t\t" + df.format(num));

		df = new DecimalFormat("+#,### ; -#,###");
		System.out.println("+#,### ; -#,###\t\t\t" + df.format(num));

		df = new DecimalFormat("#.# %");
		System.out.println("#.# %\t\t\t\t" + df.format(num));

		df = new DecimalFormat("\u00A4 #,###");
		System.out.println("\\u00A4 #,###\t\t\t" + df.format(num));

	}
}
