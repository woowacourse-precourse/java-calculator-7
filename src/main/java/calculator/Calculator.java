package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

	private static final String DEFAULT_SEPARATOR = "[,:]";
	private static final Pattern CUSTOM_SEPARATOR_PATTERN = Pattern.compile("//(.+)\\\\n(.*)");

	private static final String SEPARATOR_ERROR_MSG = "사용자 설정 구분자 사용에 실패했습니다.";
	private static final String NEGATIVE_ERROR_MSG = "음수는 허용되지않습니다.";
	private static final String INVALID_ERROR_MSG = "잘못된 형식의 문자열입니다.";

	public int sum(String input) {
		if (input == null || input.isEmpty()) {
			return 0;
		}

		String numbers = input;
		String separator = DEFAULT_SEPARATOR;

		if (input.startsWith("//")) {
			Matcher matcher = CUSTOM_SEPARATOR_PATTERN.matcher(input);
			if (!matcher.find()) {
				throw new IllegalArgumentException(SEPARATOR_ERROR_MSG);
			}

			separator += "|" + Pattern.quote(matcher.group(1));
			numbers = matcher.group(2);
		}
		return calculateSum(numbers, separator);
	}

	private int calculateSum(String numbers, String separator) {
		return Arrays.stream(numbers.split(separator)).filter(s -> !s.isEmpty()).mapToInt(this::parseInt).sum();
	}

	private int parseInt(String input) {
		try {
			int number = Integer.parseInt(input.trim());
			if (number < 0) {
				throw new IllegalArgumentException(NEGATIVE_ERROR_MSG);
			}
			return number;
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(INVALID_ERROR_MSG);
		}
	}

}
