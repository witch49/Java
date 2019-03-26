package sec06.exam01;

import sec03.exam04_deep_clone.*;

public class ClassExample {
	public static void main(String[] args) {
		Car car = new Car("modelName");
		Class clazz1 = car.getClass();
		System.out.println(clazz1.getName());
		System.out.println(clazz1.getSimpleName());
		System.out.println(clazz1.getPackage().getName() + "\n");

		try {
			Class clazz2 = Class.forName("sec03.exam04_deep_clone.Car");
			System.out.println(clazz2.getName());
			System.out.println(clazz2.getSimpleName());
			System.out.println(clazz2.getPackage().getName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
