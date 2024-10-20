package calculator.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringValidator {

	private static final String COMMA_DELIMITER = ",";
	private static final String COLON_DELIMITER = ",";

	private List<String> delimiters = new ArrayList<>(Arrays.asList(COMMA_DELIMITER, COLON_DELIMITER));

	public void addCustomDelimiter(String customDelimiter) {
		delimiters.add(customDelimiter);
	}
}
