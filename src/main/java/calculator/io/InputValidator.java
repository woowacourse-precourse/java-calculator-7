package calculator.io;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {
	private static final Pattern VALID_PATTERN = Pattern.compile("^(//.+\\\\n)?\\d+(.\\d+)*");
	
	public void validate(String input) {
		Matcher matcher = VALID_PATTERN.matcher(input);
		if (!matcher.matches()) {
			throw new IllegalArgumentException("유효하지 않은 입력입니다.");
		}
	}
}