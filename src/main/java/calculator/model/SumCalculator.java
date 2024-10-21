package calculator.model;

import java.util.List;

public class SumCalculator {

	private final List<Integer> numbers;

	public SumCalculator(List<Integer> numbers) {
		this.numbers = numbers;
	}

	public int calculate() {
		return this.numbers.stream().mapToInt(number -> number).sum();
	}
}
