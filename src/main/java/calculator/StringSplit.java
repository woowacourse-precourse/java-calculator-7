package calculator;

public class StringSplit {
	public static String[] stringSplit(String input, String delimiter, int delmiiterEndIdx) {
		String numberpart = input.substring(delmiiterEndIdx);
		String[] d = numberpart.split(delimiter);
		return d;
	}
}
