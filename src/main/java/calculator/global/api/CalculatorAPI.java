package calculator.global.api;

import calculator.domain.Number;

public class CalculatorAPI {
    public int calculate(int[] extracted) {
	    Number number = Number.getInstance();
		int sum = 0;

		for(int i = 0; i < number.getSize(); i++) {
			sum += number.getNumber(i);
		}

		return sum;
    }

}
