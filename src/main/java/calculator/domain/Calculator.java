package calculator.domain;

import java.util.List;
import java.util.Set;

public class Calculator {
	private final List<Long> calculationNumbers;
	private final Set<String> delimiters;
	private double sum;

	public Calculator(List<Long> calculationNumbers, Set<String> delimiters) {
		this.calculationNumbers = calculationNumbers;
		this.delimiters = delimiters;
		this.sum = 0L;
	}

	public Set<String> getDelimiters() {
		return delimiters;
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
