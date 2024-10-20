package calculator.model;

import java.util.List;

public class StringValidator {

	private static final String COMMA_DELIMITER = ",";
	private static final String COLON_DELIMITER = ",";

	private List<String> delimiters = List.of(COMMA_DELIMITER, COLON_DELIMITER);

	public void addCustomDelimiter(String customDelimiter) {
		delimiters.add(customDelimiter);
	}
}
