package calculator;

import calculator.service.CalculatorService;

public class Application {
	public static void main(String[] args) {
		CalculatorService calculator = new CalculatorService();
		calculator.run();
	}
}

