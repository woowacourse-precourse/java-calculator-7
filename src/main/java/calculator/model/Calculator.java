package calculator.model;

import java.util.List;

public class Calculator {
	private List<Integer> numbers;

	public Calculator(List<Integer> numbers) {
		this.numbers = numbers;
	}

	public int sum() {
		int sum = 0;
		for (int number : numbers) {
			sum += number;
		}

		return sum;
	}
}
