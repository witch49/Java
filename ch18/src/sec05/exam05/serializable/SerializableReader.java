package sec05.exam05.serializable;

import java.io.*;

public class SerializableReader {
	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("D:/workspace/Object.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		ClassA v = (ClassA) ois.readObject();
		System.out.println("field1: " + v.field1);
		System.out.println("field2.field: " + v.field2.field);
		System.out.println("field3: " + v.field3);
		System.out.println("field4: " + v.field4);
	}
}
