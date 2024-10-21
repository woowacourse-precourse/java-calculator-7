package calculator.global.api;

import calculator.domain.Number;
import calculator.global.config.BeanFactory;

public class CalculatorAPI {
	private static final CalculatorAPI INSTANCE = new CalculatorAPI();
	private final Number number = BeanFactory.number();

	private CalculatorAPI() {}

	public int answer() {
		int sum = 0;

		for(int i = 0; i < number.getSize(); i++) {
			sum += number.getNumber(i);
		}

		return sum;
    }

	public static CalculatorAPI getInstance() {
		return INSTANCE;
	}

}
