package calculator.system;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DelimiterParser {
	
	private final DelimiterValidator delimiterValidator;

	public DelimiterParser() {
		delimiterValidator = new DelimiterValidator();
	}

	public List<Long> extractTerms(String expression) {
		String origin = getCustomDelimiterParsed(expression);
		String delimiterRegex = createDelimiterRegex(expression);
		return Arrays.stream(origin.split(delimiterRegex))
				.map(Long::parseLong)
				.map(delimiterValidator::validateNegative)
				.collect(Collectors.toList());
	}

	private String getCustomDelimiterParsed(String expression) {
		return expression.startsWith("//") ? expression.substring(expression.indexOf("\\n") + 2) : expression;
	}

	private String createDelimiterRegex(String expression) {
		List<String> delimiters = getDelimiters(expression);
		return delimiters.stream()
				.map(d -> d.equals(",") ? "\\," : d)
				.collect(Collectors.joining("|"));
	}

	private List<String> getDelimiters(String expression) {
		Set<String> delimiters = Delimiter.getDefaults();
		if (expression.startsWith("//")) {
			String userDefinedDelimiter = extractUserDefinedDelimiter(expression);
			delimiterValidator.addIfValid(delimiters, userDefinedDelimiter);
		}
		return delimiters.stream().toList();
	}

	private String extractUserDefinedDelimiter(String expression) {
		int i = expression.indexOf("\\n");
		String userDefinedDelimiter = expression.substring(2, i);
		delimiterValidator.assureDefaultDelimiter(userDefinedDelimiter);
		return userDefinedDelimiter;
	}
}
