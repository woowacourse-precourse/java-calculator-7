package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

	private static final String DEFAULT_SEPARATOR = "[,:]";
	private static final Pattern CUSTOM_SEPARATOR_PATTERN = Pattern.compile("//(.*)\n(.*)");

	private static final String EMPTY_ERROR_MSG = "값을 입력해주세요.";
	private static final String NEGATIVE_ERROR_MSG = "음수는 허용되지않습니다.";

	public int sum(String input) {
		if (input == null || input.isEmpty()) {
			throw new IllegalArgumentException(EMPTY_ERROR_MSG);
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
		return Arrays.stream(numbers.split(separator)).mapToInt(this::parseInt).sum();
	}

	private int parseInt(String input){
		int number = Integer.parseInt(input.trim());
		if (number < 0){
			throw new IllegalArgumentException(NEGATIVE_ERROR_MSG);
		}
		return number;
	}

}
