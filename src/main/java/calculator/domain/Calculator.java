package calculator.domain;

import java.util.List;

public class Calculator {
	private final List<Long> calculationNumbers;
	private double sum;

	public Calculator(List<Long> calculationNumbers) {
		this.calculationNumbers = calculationNumbers;
		this.sum = 0L;
	}

	public List<Long> getCalculationNumbers() {
		return calculationNumbers;
	}

	public double getSum() {
		return sum;
	}

	private void addNumber(Long addNum){
		sum += addNum;
	}
}
