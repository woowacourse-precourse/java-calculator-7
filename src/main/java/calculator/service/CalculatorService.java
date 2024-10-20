package calculator.service;

import calculator.enums.ExceptionMessage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorService {
	private static final String DEFAULT_DELIMITERS = ",|:";
	private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.*)\n(.*)");

	public int add(String text) {
		Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(text);
		String delimiters = DEFAULT_DELIMITERS;
		if (matcher.matches()) {
			delimiters += "|" + Pattern.quote(matcher.group(1));
			text = matcher.group(2);
		}
		return calculateSum(split(text, delimiters));
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
			if (!number.isEmpty()) {
				int num = parsePositiveNumber(number);
				sum += num;
			}
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