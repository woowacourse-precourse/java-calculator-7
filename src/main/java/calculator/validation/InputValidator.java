package calculator.validation;

import static calculator.exception.ErrorMessage.*;

import java.util.regex.Pattern;

import calculator.model.Delimiter;

public class InputValidator {
	private InputValidator() {
	}

	public static void validateInvalidDelimiter(String input, Delimiter delimiter) {
		String regex = "[\\d" + String.join("", delimiter.getDelimiters().stream()
			.map(Pattern::quote) // 구분자를 정규식에 안전하게 포함
			.toArray(String[]::new)) + "]*";
		String filteredInput = input.replaceAll(regex, "");

		if (!input.matches(regex)) {
			throw new IllegalArgumentException(INVALID_DELIMITER.getMessage());
		}
	}

	public static void validateDigit(String input) {
		if (!isDigit(input)) {
 			throw new IllegalArgumentException(NON_INTEGER_VALUE.getMessage());
		}
	}

	public static void validateNonDigit(String input) {
		if (isDigit(input)) {
			throw new IllegalArgumentException(INVALID_CUSTOM_DELIMITER.getMessage());
		}
	}

	private static boolean isDigit(String input) {
		return input.chars().allMatch(Character::isDigit);
	}

	public static void validateNumberPositive(String input) {
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
			throw new IllegalArgumentException("구분자의 시작 패턴 및 종료 패턴 위치가 바뀌었습니다.");
		}
	}
}
