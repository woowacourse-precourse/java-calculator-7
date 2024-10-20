package calculator.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringValidator {

	private static final String COMMA_DELIMITER = ",";
	private static final String COLON_DELIMITER = ",";
	private static final int DIGIT = 0;
	private static final int DELIMITER = 1;
	private static final int INPUT_START_INDEX = 0;
	private static final int DELIMITER_LENGTH = 1;

	private List<String> delimiters = new ArrayList<>(Arrays.asList(COMMA_DELIMITER, COLON_DELIMITER));

	public void addCustomDelimiter(String customDelimiter) {
		delimiters.add(customDelimiter);
	}

	private int checkStartStatus(String input) {
		char start = input.charAt(INPUT_START_INDEX);
		if (Character.isDigit(start)) {
			return DIGIT;
		}
		return DELIMITER;
	}

	private int checkInputDigit(String input, int index) {
		if (!Character.isDigit(input.charAt(index))) {
			throw new IllegalArgumentException("잘못된 문자열 형식입니다.");
		}
		while (index < input.length() && Character.isDigit(input.charAt(index))) {
			index++;
		}
		return index;
	}

	private int checkInputDelimiter(String input, int index) {
		if (!delimiters.contains(input.substring(index, index + 1))) {
			throw new IllegalArgumentException("잘못된 문자열 형식입니다.");
		}
		return index + DELIMITER_LENGTH;
	}
}
