package calculator.domain;

import java.util.List;

public class Calculator {
	private final List<Long> calculationNumbers;
	private long sum;

	public Calculator(List<Long> calculationNumbers) {
		this.calculationNumbers = calculationNumbers;
		this.sum = 0L;
	}

	public long getSum() {
		return sum;
	}

	public void calculateSum() {
		calculationNumbers.forEach(number -> sum += number);
	}
}
