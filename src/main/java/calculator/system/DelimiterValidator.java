package calculator.system;

import calculator.system.exception.InvalidDelimiterException;
import java.util.Set;

public class DelimiterValidator {

	public void assureDefaultDelimiter(String userDefinedDelimiter) throws InvalidDelimiterException {
		Delimiter.getDefaults().stream()
				.filter(d -> d.equals(userDefinedDelimiter))
				.findAny()
				.ifPresent(d -> {throw new InvalidDelimiterException();});
	}

	public void addIfValid(Set<String> delimiters, String delimiter) {
		if (delimiter != null && !delimiter.isEmpty()) {
			delimiters.add(delimiter);
		}
	}
}
