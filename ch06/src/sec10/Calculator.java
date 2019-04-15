package sec10;

public class Calculator {
	String color;
	static double pi = 3.14159;

	void setColor(String color) {
		this.color = color;
	}
	
	static int plus(int x, int y) {
		return x + y;
	}

	static int minus(int x, int y) {
		return x - y;
	}
}
