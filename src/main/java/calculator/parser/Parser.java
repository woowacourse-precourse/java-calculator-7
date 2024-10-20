package calculator.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Parser {
	private static final String CUSTOM_DELIMITER_PREFIX = "//";
	private static final String CUSTOM_DELIMITER_POSTFIX = "\\n";
	private static final int CUSTOM_DELIMITER_INDEX = 2;

	private final List<String> delimiters;

	public Parser() {
		this.delimiters = new ArrayList<>(Arrays.asList(",", ":"));
	}

	public List<Integer> parse(String expression) {
		// TODO: 커스텀 구분자 추출
		if (existsCustomDelimiter(expression)) {
			validateCustomDelimiterFormat(expression);

			String delimiter = extractCustomDelimiter(expression);
			delimiters.add(delimiter);
		}

		// TODO: 커스텀 구분자 문자열 없앤 순수 식 만들기


		// TODO: 순수 식에서 구분자로 숫자 파싱
		return Collections.emptyList();
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
}
