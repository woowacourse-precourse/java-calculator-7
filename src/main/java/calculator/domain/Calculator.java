package calculator.domain;

import java.util.List;

public class Calculator {
	List<Integer> numbers;

	public Calculator(List<Integer> numbers) {
		validate(numbers);
		this.numbers = numbers;
	}

	private void validate(List<Integer> numbers) {
		for (int number : numbers) {
			if (number <= 0)
				throw new IllegalArgumentException("입력값이 양수가 아닙니다.");
		}
	}
}
