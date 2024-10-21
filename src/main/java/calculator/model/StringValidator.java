package calculator.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringValidator {

	private static final String COMMA_DELIMITER = ",";
	private static final String COLON_DELIMITER = ":";
	private static final String ERROR_MESSAGE = "잘못된 문자열 형식입니다.";
	private static final int DIGIT = 0;
	private static final int DELIMITER = 1;
	private static final int INPUT_START_INDEX = 0;
	private static final int DELIMITER_LENGTH = 1;

	private List<String> delimiters = new ArrayList<>(Arrays.asList(COMMA_DELIMITER, COLON_DELIMITER));

	public void addCustomDelimiter(String customDelimiter) {
		delimiters.add(customDelimiter);
	}

	public void validate(String input) {
		int index = INPUT_START_INDEX;
		while (index < input.length()) {
			index = checkInputStatus(input, index);
		}
	}

	private int checkInputStatus(String input, int index) {
		int currentStatus = checkStatus(input, index);
		return switch (currentStatus) {
			case DIGIT -> checkInputDigit(input, index);
			case DELIMITER -> checkInputDelimiter(input, index);
			default -> throw new IllegalArgumentException(ERROR_MESSAGE);
		};
	}

	private int checkStatus(String input, int index) {
		char start = input.charAt(index);
		if (Character.isDigit(start)) {
			return DIGIT;
		}
		return DELIMITER;
	}

	private int checkInputDigit(String input, int index) {
		if (!Character.isDigit(input.charAt(index))) {
			throw new IllegalArgumentException(ERROR_MESSAGE);
		}
		while (index < input.length() && Character.isDigit(input.charAt(index))) {
			index++;
		}
		return index;
	}

	private int checkInputDelimiter(String input, int index) {
		if (!delimiters.contains(input.substring(index, index + DELIMITER_LENGTH))) {
			throw new IllegalArgumentException(ERROR_MESSAGE);
		}
		return index + DELIMITER_LENGTH;
	}
}
