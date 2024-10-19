package calculator.domain;

import java.util.List;

public class AdditionCalculator implements Calculator {

	public long calculate(List<Long> numbers) {
		return numbers.stream()
			.mapToLong(Long::longValue)
			.sum();
	}

}
