package calculator.model;

import java.util.List;

public class InputValidator {
	List<String> delimiters;

	public void validateHasNumber(String input) {
		if (!hasNumber(input)) {
			throw new IllegalArgumentException("숫자가 없습니다.");
		}
	}

	private boolean hasNumber(String input) {
		return input.chars()
			.anyMatch(Character::isDigit);
	}
}
