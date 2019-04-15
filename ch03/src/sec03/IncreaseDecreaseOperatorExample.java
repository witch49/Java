package sec03;

public class IncreaseDecreaseOperatorExample {
	public static void main(String[] args) {
		int x = 10;
		int y = 10;
		int z;
		
		System.out.println("x : " + x + "\ny : " + y);
		System.out.println("-------- x++ ++x 수행  --------");
		x++;
		++x;
		System.out.println("x : " + x);
		System.out.println("-------- y-- --y 수행  --------");
		y--;
		--y;
		System.out.println("y : " + y);
		System.out.println("-------- z = x++ 수행  --------");
		z = x++;
		System.out.println("z : " + z + "\nx : " + x);
		System.out.println("-------- z = ++x 수행  --------");
		z = ++x;
		System.out.println("z : " + z + "\nx : " + x);
		System.out.println("-------- z = ++x + y++ 수행  --------");
		z = ++x + y++;
		System.out.println("z : " + z + "\nx : " + x + "\ny : " + y);

	}
}
