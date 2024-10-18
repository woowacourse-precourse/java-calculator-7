package calculator.model;

public class Calculator {
	private final Numbers numbers;

	private Calculator(String input) {
		numbers = NumberSeparator.from(input).separate();
	}

	public static Calculator from(String input) {
		return new Calculator(input);
	}

	Long sum() {
		return numbers.sum();
	}
}
