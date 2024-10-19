package calculator.service;

import calculator.enums.ExceptionMessage;

public class CalculatorService {
	private static final String DEFAULT_DELIMITERS = ",|:";

	public int add(String text) {
		return calculateSum(split(text, DEFAULT_DELIMITERS));
	}

	private String[] split(String text, String delimiters) {
		if (text.contains(",,") || text.contains("::") ) {
			throw new IllegalArgumentException(ExceptionMessage.INVALID_DELIMITER_FORMAT);
		}
		return text.split(delimiters);
	}

	private int calculateSum(String[] numbers) {
		int sum = 0;
		for (String number : numbers) {
			int num = parsePositiveNumber(number);
			sum += num;
		}
		return sum;
	}

	private int parsePositiveNumber(String number) {
		try {
			int num = Integer.parseInt(number);
			if (num < 0) {
				throw new IllegalArgumentException(ExceptionMessage.NEGATIVE_NUMBER);
			}
			return num;
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_FORMAT);
		}
	}
}