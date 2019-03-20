package sec10;

public class SingletonTest {
	public static void main(String[] args) {
		Singleton obj1 = Singleton.getInstance();
		Singleton obj2 = Singleton.getInstance();

		if (obj1 == obj2)
			System.out.println("같은 Singleton 객체입니다.");
		else
			System.out.println("다른 Singleton rorcpdlqslek.");
	}
}
