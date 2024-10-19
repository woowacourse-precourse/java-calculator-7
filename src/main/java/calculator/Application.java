package calculator;

public class Application {
	public static void main(String[] args) {
		CalculatorController calculatorController = CalculatorController.of(Calculator.create(),
			InputHandler.from(ValidatingParser.create()), OutputHandler.create());

		calculatorController.run();
	}
}
