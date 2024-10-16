package calculator.model;

import java.util.List;

import calculator.constant.ErrorMessage;

public class Numbers {
	private final static int MIN = 1;

	private final List<Integer> numbers;

	private Numbers(List<Integer> numbers) {
		validatePositive(numbers);
		this.numbers = numbers;
	}

	public static Numbers from(List<Integer> numbers) {
		return new Numbers(numbers);
	}

	private void validatePositive(List<Integer> numbers) {
		numbers.stream()
			.filter(number -> number < MIN)
			.findAny()
			.ifPresent(number -> {
				throw new IllegalArgumentException(ErrorMessage.NUMBERS_POSITIVE.getMessage());
			});
	}
}
