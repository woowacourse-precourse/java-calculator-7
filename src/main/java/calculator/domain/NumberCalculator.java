package calculator.domain;

import java.util.List;

public class NumberCalculator {
	public int sum(List<Integer> numbers) {
		return numbers.stream().mapToInt(Integer::intValue).sum();
	}
}
