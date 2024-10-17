package calculator;

import calculator.customSeparatorExtractor.CustomSeparatorExtractor;
import calculator.numberExtractor.NumberExtractor;
import java.util.List;

public class StringCalculator {

	private final StringParser stringParser;
	private final Calculator calculator;

	public StringCalculator(
			CustomSeparatorExtractor customSeparatorExtractor,
			NumberExtractor numberExtractor,
			Calculator calculator
	) {
		this.stringParser = new StringParser(customSeparatorExtractor, numberExtractor);
		this.calculator = calculator;
	}

	public int calculate(String customSeparatorPart, String numberPart) {
		List<Integer> numbers = stringParser.parse(customSeparatorPart, numberPart);

		return calculator.add(numbers);
	}
}
