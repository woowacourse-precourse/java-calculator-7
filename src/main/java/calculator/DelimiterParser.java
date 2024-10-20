package calculator;

import calculator.system.Delimiter;
import calculator.system.SystemMessages;
import java.util.List;
import java.util.Set;

public class DelimiterParser {

	public List<String> getDelimiters(String expression) {
		Set<String> delimiters = Delimiter.getDefaults();
		if (expression.startsWith("//")) {
			String userDefinedDelimiter = extractUserDefinedDelimiter(expression);
			addIfValid(delimiters, userDefinedDelimiter);
		}
		return delimiters.stream().toList();
	}

	private String extractUserDefinedDelimiter(String expression) {
		int i = expression.indexOf("\\n");
		String userDefinedDelimiter = expression.substring(2, i);
		assureDefaultDelimiter(userDefinedDelimiter);
		return userDefinedDelimiter;
	}

	private void assureDefaultDelimiter(String userDefinedDelimiter) {
		Delimiter.getDefaults().stream()
				.filter(d -> d.equals(userDefinedDelimiter))
				.findAny()
				.ifPresent(d -> {
					throw new IllegalArgumentException(SystemMessages.INVALID_DELIMITER.getMessage());
				});
	}

	private void addIfValid(Set<String> delimiters, String delimiter) {
		if (delimiter != null && !delimiter.isEmpty()) {
			delimiters.add(delimiter);
		}
	}
}
