package calculator;

import calculator.parser.Parser;
import java.util.List;

public class Calculator {
	private final Parser parser;

	Calculator(Parser parser) {
		this.parser = parser;
	}

	public int calculate(String expression) {
		List<Integer> numbers = parser.parse(expression);

		validateAllPositive(numbers);

		return numbers.stream()
				.reduce(0, Integer::sum);
	}

	private void validateAllPositive(List<Integer> numbers) {
		if (numbers.stream().anyMatch(number -> number <= 0)) {
			throw new IllegalArgumentException("양수만 입력할 수 있습니다.");
		}
	}
}
