package calculator.service;

import calculator.constants.ExceptionMessage;

import java.util.regex.Pattern;

public class CalculatorService {
	private static final String DEFAULT_DELIMITERS = ",:";

	public int add(String text) {
		validateInput(text);
		text = text.trim();
		text = text.replace("\\n", "\n");

		String delimiters = DEFAULT_DELIMITERS;

		if (text.startsWith("//")) {
			int delimiterEndIndex = text.indexOf("\n");

			if (delimiterEndIndex == -1) {
				throw new IllegalArgumentException(ExceptionMessage.INVALID_DELIMITER_FORMAT);
			}
			String customDelimiter = text.substring(2, delimiterEndIndex);
			validateCustomDelimiter(customDelimiter);
			delimiters += "|" + Pattern.quote(customDelimiter);
			text = text.substring(delimiterEndIndex + 1).trim();
		}

		return calculateSum(split(text, delimiters));
	}

	private void validateInput(String text) {
		if (text == null || text.trim().isEmpty()) {
			throw new IllegalArgumentException(ExceptionMessage.INPUT_EMPTY);
		}
	}

	private void validateCustomDelimiter(String customDelimiter) {
		if (customDelimiter.matches("[0-9]+")) {
			throw new IllegalArgumentException(ExceptionMessage.INVALID_CUSTOM_DELIMITER_NUMBER);
		}

		if (customDelimiter.length() > 1) {
			throw new IllegalArgumentException(ExceptionMessage.MULTIPLE_CUSTOM_DELIMITERS);
		}
	}

	private String[] split(String text, String delimiters) {
		if (text.contains(",,") || text.contains("::")) {
			throw new IllegalArgumentException(ExceptionMessage.INVALID_DELIMITER_FORMAT);
		}

		return text.split(delimiters);
	}

	private int calculateSum(String[] numbers) {
		int sum = 0;
		for (String number : numbers) {
			if (!number.trim().isEmpty()) {
				int num = parsePositiveNumber(number.trim());
				sum += num;
			}
		}
		return sum;
	}

	private int parsePositiveNumber(String number) {
		try {
			int num = Integer.parseInt(number);
			if (num <= 0) {
				throw new IllegalArgumentException(ExceptionMessage.NEGATIVE_NUMBER);
			}
			return num;
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_FORMAT);
		}
	}
}
