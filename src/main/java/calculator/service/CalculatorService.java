package calculator.service;

import calculator.constants.ExceptionMessage;
import calculator.validation.InputValidator;

import java.util.regex.Pattern;

public class CalculatorService {
	private static final String DEFAULT_DELIMITERS = ",|:";

	private final InputValidator inputValidator;

	public CalculatorService() {
		this.inputValidator = new InputValidator();
	}

	public int add(String text) {
		inputValidator.validateInput(text);
		text = text.trim();
		text = text.replace("\\n", "\n");

		String delimiters = DEFAULT_DELIMITERS;

		if (text.startsWith("//")) {
			int delimiterEndIndex = text.indexOf("\n");
			if (delimiterEndIndex == -1) {
				throw new IllegalArgumentException(ExceptionMessage.INVALID_DELIMITER_FORMAT);
			}
			String customDelimiter = text.substring(2, delimiterEndIndex);
			inputValidator.validateCustomDelimiter(customDelimiter);
			delimiters += "|" + Pattern.quote(customDelimiter);
			text = text.substring(delimiterEndIndex + 1).trim();
		}

		inputValidator.validateInvalidDelimiter(text, delimiters);

		return calculateSum(split(text, delimiters));
	}

	private String[] split(String text, String delimiters) {
		return text.split(delimiters);
	}

	private int calculateSum(String[] numbers) {
		int sum = 0;
		for (String number : numbers) {
			if (!number.trim().isEmpty()) {
				sum += inputValidator.validatePositiveNumber(number.trim());
			}
		}
		return sum;
	}
}
