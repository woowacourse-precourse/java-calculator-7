package calculator;

public class CustomDelimiter {
	public static String findDelimiter(String input) {
		String defaultDelimiter = ",:";
		String delimiterPrefix = "//";
		String delimiterSuffix = "\n";

		int beginIndex = input.indexOf(delimiterPrefix);
		int endIndex = input.indexOf(delimiterSuffix);
		if (beginIndex == -1 || endIndex == -1) {
			return defaultDelimiter;
		}
		return input.substring(beginIndex + 2, endIndex);
	}
}
