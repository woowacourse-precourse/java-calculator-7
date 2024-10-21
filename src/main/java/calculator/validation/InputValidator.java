package calculator.validation;

import static calculator.exception.ErrorMessage.*;

import calculator.model.delimiter.Delimiters;

public class InputValidator {
	private InputValidator() {
	}

	public static void validateInvalidDelimiter(String input, Delimiters delimiters) {
		String regex = "[\\d" + String.join("", delimiters.getRegex()) + "]*";

		if (!input.matches(regex)) {
			throw new IllegalArgumentException(INVALID_DELIMITER.getMessage());
		}
	}

	public static void validateNonDigit(String input) {
		if (isDigit(input)) {
			throw new IllegalArgumentException(INVALID_CUSTOM_DELIMITER.getMessage());
		}
	}

	public static void validateCalculatorNumber(String input) {
		validateDigit(input);
		validateNumberPositive(input);
	}

	private static void validateDigit(String input) {
		if (!isDigit(input)) {
			throw new IllegalArgumentException(NON_INTEGER_VALUE.getMessage());
		}
	}

	private static boolean isDigit(String input) {
		return input.chars().allMatch(Character::isDigit);
	}

	private static void validateNumberPositive(String input) {
		if (Integer.parseInt(input) <= 0) {
			throw new IllegalArgumentException(NON_POSITIVE_NUMBER.getMessage());
		}
	}

	public static void validateEmpty(String input) {
		if (input.isEmpty()) {
			throw new IllegalArgumentException(EMPTY_CUSTOM_DELIMITER.getMessage());
		}
	}

	public static void validateStartPattern(int startIndex) {
		if (startIndex == -1) {
			throw new IllegalArgumentException(INVALID_START_PATTERN.getMessage());
		}
	}

	public static void validateEndPattern(int endIndex) {
		if (endIndex == -1) {
			throw new IllegalArgumentException(INVALID_END_PATTERN.getMessage());
		}
	}

	public static void validatePatternPosition(int start, int end) {
		if (start >= end) {
			throw new IllegalArgumentException(INVALID_PATTERN_POSITION.getMessage());
		}
	}
}
