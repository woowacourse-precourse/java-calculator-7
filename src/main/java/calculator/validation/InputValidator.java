package calculator.validation;

import java.util.List;
import java.util.regex.Pattern;

public class InputValidator {
	public void validateInvalidDelimiter(String input, List<String> delimiters) {
		String regex = "[\\d" + String.join("", delimiters.stream()
			.map(Pattern::quote) // 구분자를 정규식에 안전하게 포함
			.toArray(String[]::new)) + "]*";
		String filteredInput = input.replaceAll(regex, "");

		if (!input.matches(regex)) {
			throw new IllegalArgumentException("허용되지 않은 구분자가 포함되어 있습니다: " + filteredInput);
		}
	}

	public void validateDigit(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("구분자 사이에 정수가 아닌 값이 포함되어 있습니다.");
		}
	}

	public void validateNumberPositive(String input) {
		if (Integer.parseInt(input) <= 0) {
			throw new IllegalArgumentException("0 또는 음수가 포함되어 있습니다.");
		}
	}

	public void validateEmpty(String input) {
		if (input.isEmpty()) {
			throw new IllegalArgumentException("커스텀 구분자에는 빈 문자열이 올 수 없습니다.");
		}
	}
}
