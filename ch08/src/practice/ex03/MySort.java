package practice.ex03;

public interface MySort {
	public abstract String[] sort(String[] strArray); // 오름차순 정렬 메소드

	public abstract String[] sort(String[] strArray, boolean descOrder); // 내림차순 정렬 메소드
}
