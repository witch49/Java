package sec06;

import java.util.Arrays;

public class ArrayCopyExample {
	public static void main(String[] args) {
		String[] oldStrArray = { "Java", "array", "copy" };
		String[] newStrArray = new String[5];
		
		System.arraycopy(oldStrArray, 0, newStrArray, 0, oldStrArray.length);
		System.out.println(Arrays.toString(newStrArray));
		
		String[] utilStrArray = Arrays.copyOf(oldStrArray, 5);
		System.out.println(Arrays.toString(utilStrArray));
	}
}
