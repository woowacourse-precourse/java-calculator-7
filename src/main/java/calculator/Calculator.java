package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

	private static final String DEFAULT_SEPARATOR = "[,:]";
	private static final Pattern CUSTOM_SEPARATOR_PATTERN = Pattern.compile("//(.*)\n(.*)");

	public int sum(String input) {
		if (input == null || input.isEmpty()) {
			return 0;
		}

		Matcher matcher = CUSTOM_SEPARATOR_PATTERN.matcher(input);
		if (matcher.find()) {
			String customSeparator = Pattern.quote(matcher.group(1));
			String numbers = matcher.group(2);
			return calculateSum(numbers, customSeparator + "|" + DEFAULT_SEPARATOR);
		}

		return calculateSum(input, DEFAULT_SEPARATOR);
	}

	private int calculateSum(String numbers, String separator) {
		return Arrays.stream(numbers.split(separator)).mapToInt(Integer::parseInt).sum();
	}
}
