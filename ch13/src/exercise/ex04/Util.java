package exercise.ex04;

public class Util {
	public static <K, V> Integer getValue(Pair<K, V> p1, String s) {

		if (!p1.getKey().equals(s))
			return null;

		return (Integer) p1.getValue();

	}
}
