package calculator.model;

import java.util.List;

import calculator.constant.ErrorMessage;

public class Numbers {
	private final static long MIN = 1;

	private final List<Long> numbers;

	private Numbers(List<Long> numbers) {
		validatePositive(numbers);
		this.numbers = numbers;
	}

	public static Numbers from(List<Long> numbers) {
		return new Numbers(numbers);
	}

	private void validatePositive(List<Long> numbers) {
		numbers.stream()
			.filter(number -> number < MIN)
			.findAny()
			.ifPresent(number -> {
				throw new IllegalArgumentException(ErrorMessage.NUMBERS_POSITIVE.getMessage());
			});
	}
}
