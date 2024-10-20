package calculator.domain;

import java.util.List;

import calculator.constant.ErrorMessage;

public class AdditionCalculator implements Calculator {

	public long calculate(List<Long> numbers) {

		long sum = 0;
		for (Long number : numbers) {
			validateSum(sum, number);
			sum += number;
		}
		return sum;
	}

	private void validateSum(long sum, long nextNumber) {
		if (nextNumber > Long.MAX_VALUE - sum) {
			throw new IllegalArgumentException(ErrorMessage.OVER_FLOW_SUM.getMessage());
		}
	}

}
