package calculator.domain;

import java.util.List;

public class Calculator {
	private final List<Long> calculationNumbers;
	private Long sum;

	public Calculator(List<Long> calculationNumbers) {
		this.calculationNumbers = calculationNumbers;
		this.sum = 0L;
	}

	public List<Long> getCalculationNumbers() {
		return calculationNumbers;
	}

	public Long getSum() {
		return sum;
	}

	public void calculateSum(){
		calculationNumbers.forEach(number -> sum += number);
	}
}
