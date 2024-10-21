package calculator.validation;

import static calculator.exception.ErrorMessage.*;

import java.util.List;
import java.util.regex.Pattern;

public class InputValidator {
	public void validateInvalidDelimiter(String input, List<String> delimiters) {
		String regex = "[\\d" + String.join("", delimiters.stream()
			.map(Pattern::quote) // 구분자를 정규식에 안전하게 포함
			.toArray(String[]::new)) + "]*";
		String filteredInput = input.replaceAll(regex, "");

		if (!input.matches(regex)) {
			throw new IllegalArgumentException(INVALID_DELIMITER.getMessage());
		}
	}

	public void validateDigit(String input) {
		if (!isDigit(input)) {
 			throw new IllegalArgumentException(NON_INTEGER_VALUE.getMessage());
		}
	}

	public void validateNonDigit(String input) {
		if (isDigit(input)) {
			throw new IllegalArgumentException(INVALID_CUSTOM_DELIMITER.getMessage());
		}
	}

	private boolean isDigit(String input) {
		return input.chars().allMatch(Character::isDigit);
	}

	public void validateNumberPositive(String input) {
		if (Integer.parseInt(input) <= 0) {
			throw new IllegalArgumentException(NON_POSITIVE_NUMBER.getMessage());
		}
	}

	public void validateEmpty(String input) {
		if (input.isEmpty()) {
			throw new IllegalArgumentException(EMPTY_CUSTOM_DELIMITER.getMessage());
		}
	}
}
