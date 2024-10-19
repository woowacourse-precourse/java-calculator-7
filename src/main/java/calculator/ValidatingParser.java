package calculator;

import java.util.ArrayList;
import java.util.List;

public class ValidatingParser {
	private static final String START_CUSTOM_SEPARATOR = "//";
	private static final String END_CUSTOM_SEPARATOR = "\\n";
	private static final String DEFAULT_SEPARATORS = "[,:]";
	private static final String ERROR_MESSAGE_NOT_NUMBER = "입력값이 숫자가 아닙니다.";
	private static final String ERROR_MESSAGE_NEGATIVE_NUMBER = "입력값이 양수가 아닙니다.";

	private ValidatingParser() {
	}

	public static ValidatingParser create() {
		return new ValidatingParser();
	}

	public List<Integer> validatedNumbersFrom(String userInput) {
		if (isContainsCustomSeparator(userInput)) {
			String prefix = getPrefix(userInput);
			String customSeparator = extractCustomSeparatorFrom(prefix);
			String suffix = getSuffix(userInput, prefix);
			return extractNumbers(customSeparator, suffix);
		}
		return extractNumbers(DEFAULT_SEPARATORS, userInput);
	}

	private boolean isContainsCustomSeparator(String userInput) {
		return userInput.contains(START_CUSTOM_SEPARATOR) && userInput.contains(END_CUSTOM_SEPARATOR);
	}

	private String getPrefix(String userInput) {
		int startCustomSeparatorIndex = userInput.indexOf(START_CUSTOM_SEPARATOR);
		int endCustomSeparatorIndex = userInput.indexOf(END_CUSTOM_SEPARATOR);
		int endSeparatorSize = END_CUSTOM_SEPARATOR.length();
		return userInput.substring(startCustomSeparatorIndex, endCustomSeparatorIndex + endSeparatorSize);
	}

	private String extractCustomSeparatorFrom(String prefix) {
		int startCustomSeparatorIndex = prefix.indexOf(START_CUSTOM_SEPARATOR);
		int endCustomSeparatorIndex = prefix.indexOf(END_CUSTOM_SEPARATOR);
		int startSeparatorSize = START_CUSTOM_SEPARATOR.length();
		return prefix.substring(startCustomSeparatorIndex + startSeparatorSize,
			endCustomSeparatorIndex);
	}

	private String getSuffix(String userInput, String prefix) {
		int endOfPrefixIndex = prefix.length();
		return userInput.substring(endOfPrefixIndex);
	}

	private List<Integer> extractNumbers(String separator, String suffix) {
		List<Integer> numbers = new ArrayList<>();

		if (suffix.isEmpty()) {
			return handleEmptyInput();
		}

		String[] split = suffix.split(separator);
		for (String token : split) {
			numbers.add(parsePositiveNumber(token));
		}
		return numbers;
	}

	private int parsePositiveNumber(String token) {
		int number = parseNumber(token);
		validatePositiveNumber(number);
		return number;
	}

	private int parseNumber(String token) {
		try {
			return Integer.parseInt(token);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ERROR_MESSAGE_NOT_NUMBER);
		}
	}

	private void validatePositiveNumber(int number) {
		if (number < 0) {
			throw new IllegalArgumentException(ERROR_MESSAGE_NEGATIVE_NUMBER);
		}
	}

	private List<Integer> handleEmptyInput() {
		List<Integer> numbers = new ArrayList<>();
		numbers.add(0);
		return numbers;
	}
}
