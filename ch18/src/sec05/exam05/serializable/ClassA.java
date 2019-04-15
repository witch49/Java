package sec05.exam05.serializable;

import java.io.Serializable;

public class ClassA implements Serializable {
	int field1;
	ClassB field2 = new ClassB();
	static int field3; // 직렬화에서 제외
	transient int field4; // 직렬화에서 제외
}
