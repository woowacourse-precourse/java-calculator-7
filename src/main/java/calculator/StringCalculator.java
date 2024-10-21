package calculator;

import java.util.Arrays;
import java.util.regex.Pattern;

public class StringCalculator {
	private static final String CUSTOM_DELIMITER_PREFIX = "//";
	private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";
	private static final String DEFAULT_DELIMITERS = ",|:";

	public int add(String input) {
		if (input == null || input.isEmpty()) {
			return 0;
		}

		String[] numbers = splitNumbers(input);
		return sum(numbers);
	}

	private String[] splitNumbers(String input) {
		if (hasCustomDelimiter(input)) {
			return splitWithCustomDelimiter(input);
		}
		return input.split(DEFAULT_DELIMITERS);
	}

	private boolean hasCustomDelimiter(String input) {
		return input.startsWith(CUSTOM_DELIMITER_PREFIX);
	}

	private String[] splitWithCustomDelimiter(String input) {
		String delimiter = extractCustomDelimiter(input);
		String numbersString = extractNumbersString(input);
		return numbersString.split(Pattern.quote(delimiter));
	}

	private String extractCustomDelimiter(String input) {
		int delimiterStart = CUSTOM_DELIMITER_PREFIX.length();
		int delimiterEnd = input.indexOf(CUSTOM_DELIMITER_SUFFIX);

		if (delimiterEnd == -1) {
			throw new IllegalArgumentException("커스텀 구분자 형식이 올바르지 않습니다.");
		}

		return input.substring(delimiterStart, delimiterEnd);
	}

	private String extractNumbersString(String input) {
		int numbersStart = input.indexOf(CUSTOM_DELIMITER_SUFFIX);

		if (numbersStart == -1) {
			throw new IllegalArgumentException("커스텀 구분자 형식이 올바르지 않습니다.");
		}

		return input.substring(numbersStart + CUSTOM_DELIMITER_SUFFIX.length());
	}

	private int sum(String[] numbers) {
		return Arrays.stream(numbers)
			.filter(str -> !str.isEmpty())
			.mapToInt(this::parseNumber)
			.sum();
	}

	private int parseNumber(String number) {
		try {
			int parsed = Integer.parseInt(number.trim());
			if (parsed < 0) {
				throw new IllegalArgumentException("음수는 입력할 수 없습니다: " + parsed);
			}
			return parsed;
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("숫자로 변환할 수 없는 값이 포함되어 있습니다: " + number);
		}
	}
}