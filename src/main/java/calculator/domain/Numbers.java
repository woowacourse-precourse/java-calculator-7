package calculator.domain;

import java.util.List;

public class Numbers {
	private final List<Integer> numbers;

	public Numbers(List<Integer> numbers) {
		validateIsPositiveNumber(numbers);
		this.numbers = numbers;
	}

	public void validateIsPositiveNumber(List<Integer> numbers){
		boolean hasNonPositive = numbers.stream()
			.anyMatch(number -> number <= 0);

		if (hasNonPositive) {
			throw new IllegalArgumentException("입력된 숫자 중에 음수 또는 0이 있습니다.");
		}
	}

	public int sumNumbers() {
		return numbers.stream()
			.mapToInt(Integer::intValue)
			.sum();
	}
}
