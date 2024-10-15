package calculator.model;

import java.util.Arrays;
import java.util.List;

public class InputValidator {
	List<String> delimiters = Arrays.asList(",", ":");

	public void validateHasNumber(String input) {
		if (!hasNumber(input)) {
			throw new IllegalArgumentException("입력값에 숫자가 포함되어 있지 않습니다.");
		}
	}

	private boolean hasNumber(String input) {
		return input.chars()
			.anyMatch(Character::isDigit);
	}

	public void validateHasDelimiter(String input) {
		if (!hasDelimiter(input)) {
			throw new IllegalArgumentException("입력값에 구분자가 포함되어 있지 않습니다.");
		}
	}

	private boolean hasDelimiter(String input) {
		return delimiters.stream()
			.anyMatch(input::contains);
	}
}
