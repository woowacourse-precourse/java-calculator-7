package calculator;

import calculator.system.Delimiter;
import calculator.system.SystemMessages;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DelimiterParser {

	public List<String> getDelimiters(String expression) {
		Set<String> delimiters = Delimiter.getDefaults();
		if (expression.startsWith("//")) {
			String userDefinedDelimiter = extractUserDefinedDelimiter(expression);
			addIfValid(delimiters, userDefinedDelimiter);
		}
		return delimiters.stream().toList();
	}

	public List<Long> extractTerms(String expression) {
		String origin = expression.startsWith("//") ? expression.substring(expression.indexOf("\\n") + 2) : expression;
		List<String> delimiters = getDelimiters(expression);
		String delimiterRegex = createDelimiterRegex(delimiters);
		return Arrays.stream(origin.split(delimiterRegex))
				.map(Long::parseLong)
				.map(this::validateNegative)
				.collect(Collectors.toList());
	}

	private Long validateNegative(Long term) {
		if (term < 0) {
			throw new IllegalArgumentException(SystemMessages.NEGATIVE_NUMBER.getMessage());
		}
		return term;
	}

	private String createDelimiterRegex(List<String> delimiters) {
		return delimiters.stream()
				.map(d -> d.equals(",") ? "\\," : d)
				.collect(Collectors.joining("|"));
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
