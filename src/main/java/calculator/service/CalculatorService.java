package calculator.service;

import java.util.List;

import calculator.domain.Calculator;
import calculator.domain.DelimiterMaker;
import calculator.domain.InputParser;
import calculator.domain.NumberExtractor;

public class CalculatorService {

	private final Calculator calculator;
	private final DelimiterMaker delimiterMaker;
	private final NumberExtractor numberExtractor;
	private final InputParser inputParser;

	public CalculatorService(Calculator calculator, DelimiterMaker delimiterMaker,
		NumberExtractor numberExtractor, InputParser inputParser) {
		this.calculator = calculator;
		this.delimiterMaker = delimiterMaker;
		this.numberExtractor = numberExtractor;
		this.inputParser = inputParser;
	}

	public long calculate(String input) {
		List<String> delimiters = getDelimiters(input);
		List<Long> numbers = getNumbers(input, delimiters);
		return calculator.calculate(numbers);
	}

	private List<String> getDelimiters(String useInput) {
		if (delimiterMaker.hasCustomSeparator(useInput)) {
			String delimiterEndSign = delimiterMaker.getDelimiterEndSign();
			String delimiterSection = inputParser.getDelimiterSectionFrom(useInput, delimiterEndSign);
			return delimiterMaker.getDelimitersFrom(delimiterSection);
		}

		return delimiterMaker.getDefaultDelimiters();
	}

	private List<Long> getNumbers(String input, List<String> delimiters) {
		String numberSection = getNumberSection(input);
		return numberExtractor.getNumbers(numberSection, delimiters);
	}

	private String getNumberSection(String userInput) {
		if (delimiterMaker.hasCustomSeparator(userInput)) {
			String delimiterEndSign = delimiterMaker.getDelimiterEndSign();
			return inputParser.getNumberSectionFrom(userInput, delimiterEndSign);
		}

		return userInput;
	}

}
