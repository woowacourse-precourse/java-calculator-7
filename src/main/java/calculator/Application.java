package calculator;

import calculator.io.InputHandler;
import calculator.io.OutputHandler;
import calculator.service.Calculator;
import calculator.service.ValidatingParser;

public class Application {
	public static void main(String[] args) {
		CalculatorController calculatorController = CalculatorController.of(Calculator.create(),
			InputHandler.from(ValidatingParser.create()), OutputHandler.create());

		calculatorController.run();
	}
}
