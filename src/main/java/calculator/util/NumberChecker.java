package calculator.util;

import java.util.regex.Pattern;

public class NumberChecker {

	private static final Pattern SINGLE_NUMBER_PATTERN = Pattern.compile("\\d");
	private static final Pattern NUMBER_PATTERN = Pattern.compile("^-?\\d+$");
	private static final Pattern NEGATIVE_NUMBER_PATTERN = Pattern.compile("^-\\d+$");

	public static boolean isNumber(String value) {
		return NUMBER_PATTERN.matcher(value).matches();
	}

	public static boolean isNotNumber(String value) {
		return !isNumber(value);
	}

	public static boolean containsNumber(String value) {
		return SINGLE_NUMBER_PATTERN.matcher(value).find();
	}

	public static boolean isNegativeNumber(String value) {
		return NEGATIVE_NUMBER_PATTERN.matcher(value).matches();
	}

	public static boolean isNotNegativeNumber(String value) {
		return !isNegativeNumber(value);
	}

}
