package calculator.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Parser {
	private static final String CUSTOM_DELIMITER_PREFIX = "//";
	private static final String CUSTOM_DELIMITER_POSTFIX = "\\n";
	private static final int CUSTOM_DELIMITER_INDEX = 2;
	private static final int PURE_EXPRESSION_START_INDEX = 5;

	private final List<String> delimiters;

	public Parser() {
		this.delimiters = new ArrayList<>(Arrays.asList(",", ":"));
	}

	public List<Integer> parse(String expression) {
		String pureExpression = expression;

		if (existsCustomDelimiter(expression)) {
			validateCustomDelimiterFormat(expression);

			String delimiter = extractCustomDelimiter(expression);
			delimiters.add(delimiter);

			pureExpression = changeToPureExpression(expression);
		}

		validateStartAndEndWithDigit(pureExpression);

		return extractNumbers(pureExpression);
	}

	private boolean existsCustomDelimiter(String expression) {
		return expression.matches("^\\D.*");
	}

	private void validateCustomDelimiterFormat(String expression) {
		if (!expression.startsWith(CUSTOM_DELIMITER_PREFIX)) {
			throw new IllegalArgumentException("커스텀 구분자 지정은 //로 시작해야 합니다.");
		}

		if (CUSTOM_DELIMITER_INDEX + 1 != expression.indexOf(CUSTOM_DELIMITER_POSTFIX)) {
			throw new IllegalArgumentException("커스텀 구분자 지정은 //와 \\n 사이에 하나의 문자를 작성해주세요.");
		}

		if (Character.isDigit(expression.charAt(CUSTOM_DELIMITER_INDEX))) {
			throw new IllegalArgumentException("커스텀 구분자는 숫자는 불가능합니다.");
		}
	}

	private String extractCustomDelimiter(String expression) {
		return String.valueOf(expression.charAt(CUSTOM_DELIMITER_INDEX));
	}

	private String changeToPureExpression(String expression) {
		return expression.substring(PURE_EXPRESSION_START_INDEX);
	}

	private void validateStartAndEndWithDigit(String expression) {
		if (!Character.isDigit(expression.charAt(0))) {
			throw new IllegalArgumentException("수식은 숫자로 시작해야 합니다.");
		}

		if (!Character.isDigit(expression.charAt(expression.length() - 1))) {
			throw new IllegalArgumentException("수식은 숫자로 끝나야 합니다.");
		}
	}

	private List<Integer> extractNumbers(String expression) {
		String regex = toRegex(delimiters);

		String[] strNumbers = expression.split(regex);

		return Arrays.stream(strNumbers)
				.map((strNumber) -> {
					try {
						return Integer.parseInt(strNumber);
					} catch (NumberFormatException e) {
						throw new IllegalArgumentException("올바른 구분자를 입력해주세요.");
					}
				})
				.toList();
	}

	private String toRegex(List<String> delimiters) {
		return delimiters.stream()
				.map(Pattern::quote)
				.collect(Collectors.joining("|"));
	}
}
