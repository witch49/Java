package sec06;

public class Course<T> {
	private String name;
	private T[] students;

	public Course(String name, int capacity) {
		this.name = name;
		// 타입 파라미터로 배열 생성 시 new T[n] 형태로 배열 생성 불가능
		// (T[]) (new Object[n]) 형식으로 생성해야 함
		students = (T[]) (new Object[capacity]);
	}

	public String getName() {
		return name;
	}

	public T[] getStudents() {
		return students;
	}

	// 배열에 비어있는 부분을 찾아서 수강생을 추가하는 메소드
	public void add(T t) {
		for (int i = 0; i < students.length; i++) {
			if (students[i] == null) {
				students[i] = t;
				break;
			}
		}
	}

}
