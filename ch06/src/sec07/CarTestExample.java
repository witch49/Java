package sec07;

public class CarTestExample {
	public static void main(String[] args) {
		CarTest car1 = new CarTest();
		System.out.println(car1.toString());
		//System.out.println("car1.company : " + car1.company + "\n");
		
		CarTest car2 = new CarTest("자가용");
		System.out.println(car2.toString());
		//System.out.println("car2.company : " + car2.company);
		//System.out.println("car2.model : " + car2.model + "\n");
		
		CarTest car3 = new CarTest("자가용", "빨강");
		System.out.println(car3.toString());
		//System.out.println("car3.company : " + car3.company);
		//System.out.println("car3.model : " + car3.model);
		//System.out.println("car3.color : " + car3.color + "\n");
		
		CarTest car4 = new CarTest("택시", "검정", 200);
		System.out.println(car4.toString());
		System.out.println(car4.print(4));
		//System.out.println("car4.company : " + car4.company);
		//System.out.println("car4.model : " + car4.model);
		//System.out.println("car4.color : " + car4.color);
		//System.out.println("car4.maxSpeed : " + car4.maxSpeed);
	}
}
