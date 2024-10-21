package calculator.model;

import java.util.Set;

public class Calculator {
	public int sum(Set<Integer> numbers) {
		return numbers.stream()
			.mapToInt(Integer::intValue)
			.sum();
	}
}
