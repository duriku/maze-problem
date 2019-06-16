package jksoftware.utils;

public class ArrayUtils {

	public static <T> T[][] deepCopy(T[][] matrix) {
		return java.util.Arrays.stream(matrix).map(el -> el.clone()).toArray(e -> matrix.clone());
	}
}
