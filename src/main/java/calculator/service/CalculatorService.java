package calculator.service;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

import calculator.domain.Delimiters;
import calculator.validation.Validator;

public class CalculatorService {
	private final Delimiters delimiters;

	public CalculatorService(Delimiters delimiters) {
		this.delimiters = delimiters;
	}

	public int calculate(String input) {

		String numbersSection = input;

		if (Validator.isCustomDelimiter(input)) {
			int delimiterEndIndex = input.indexOf("\n");
			if (delimiterEndIndex != -1) {
				String customDelimiter = input.substring(2, delimiterEndIndex);
				delimiters.addDelimiter(customDelimiter);
				numbersSection = input.substring(delimiterEndIndex + 1);
			}
		}

		// if(!Validator.isDefaultDelimiters(numbersSection, delimiters.getDelimiters())){
		// 	throw new IllegalArgumentException();
		// }

		String[] tokens = numbersSection.split(getDelimitersRegex());
		int sum = 0;
		for (String token : tokens) {
			if (!token.isEmpty()) {
				sum += Integer.parseInt(token.trim());
			}
		}
		return sum;
	}

	private String getDelimitersRegex() {
		return delimiters.getDelimiters().stream()
			.map(Pattern::quote)
			.collect(Collectors.joining("|"));
	}



}
