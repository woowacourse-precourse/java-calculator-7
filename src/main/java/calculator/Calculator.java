package calculator;

import java.util.List;

public class Calculator {
	private static final String ERROR_MESSAGE_NEGATIVE_NUMBER = "음수는 계산할 수 없습니다.";
	private static final String ERROR_OVERFLOW_SUM = "계산 범위를 초과 하였습니다.";

	public int sumNumbers(List<Integer> numbers) {
		int sum = 0;
		for (int number : numbers) {
			validatePositiveNumber(number);
			validateNoOverflow(sum, number);
			sum += number;
		}
		return sum;
	}

	private void validatePositiveNumber(int number) {
		if (number < 0) {
			throw new IllegalArgumentException(ERROR_MESSAGE_NEGATIVE_NUMBER);
		}
	}

	private void validateNoOverflow(int sum, int number) {
		if (sum > Integer.MAX_VALUE - number) {
			throw new IllegalArgumentException(ERROR_OVERFLOW_SUM);
		}
	}
}
