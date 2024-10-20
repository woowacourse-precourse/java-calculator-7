package calculator.validation;

import java.util.List;

public class InputValidator {
	public void validateInvalidDelimiter(String input, List<String> delimiters) {
		String regex = "[\\d" + String.join("", delimiters) + "]*";
		String filteredInput = input.replaceAll(regex, "");

		if (!input.matches(regex)) {
			throw new IllegalArgumentException("허용되지 않은 구분자가 포함되어 있습니다: " + filteredInput);
		}
	}

	public void validateDigit(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("구분자 사이에 정수가 아닌 값이 포함되어 있습니다.");
		}
	}

	public void validateNumberPositive(String s) {
		if (Integer.parseInt(s) <= 0) {
			throw new IllegalArgumentException("0 또는 음수가 포함되어 있습니다.");
		}
	}
}
