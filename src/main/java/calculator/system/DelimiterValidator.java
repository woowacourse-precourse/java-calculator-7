package calculator.system;

import calculator.exception.InvalidDelimiterException;
import calculator.exception.NegativeValueException;
import java.util.Set;

public class DelimiterValidator {

	public Long validateNegative(Long term) throws NegativeValueException {
		if (term < 0) {throw new NegativeValueException();}
		return term;
	}

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
