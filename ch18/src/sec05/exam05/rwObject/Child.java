package sec05.exam05.rwObject;

import java.io.*;

public class Child extends Parent implements Serializable {
	/* 직렬화되지 않은 부모 클래스의 필드 처리 */
	public String field2;
	
	private void writeObject(ObjectOutputStream out) throws IOException {
		out.writeUTF(field1);
		out.defaultWriteObject();
	}
	
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		field1 = in.readUTF();
		in.defaultReadObject();
	}

}
