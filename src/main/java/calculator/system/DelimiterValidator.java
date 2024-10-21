package calculator.system;

import java.util.Set;

public class DelimiterValidator {
	public Long validateNegative(Long term) {
		if (term < 0) {
			throw new IllegalArgumentException(SystemMessages.NEGATIVE_NUMBER.getMessage());
		}
		return term;
	}

	public void assureDefaultDelimiter(String userDefinedDelimiter) {
		Delimiter.getDefaults().stream()
				.filter(d -> d.equals(userDefinedDelimiter))
				.findAny()
				.ifPresent(d -> {
					throw new IllegalArgumentException(SystemMessages.INVALID_DELIMITER.getMessage());
				});
	}

	public void addIfValid(Set<String> delimiters, String delimiter) {
		if (delimiter != null && !delimiter.isEmpty()) {
			delimiters.add(delimiter);
		}
	}
}
