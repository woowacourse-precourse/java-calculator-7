package calculator.global.api;

import calculator.domain.Number;

public class CalculatorAPI {
	private final Number number = Number.getInstance();

	public int answer() {
		int sum = 0;

		for(int i = 0; i < number.getSize(); i++) {
			sum += number.getNumber(i);
		}

		return sum;
    }

}
