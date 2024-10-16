package calculator;

public class Application {
	public static void main(String[] args) {

		Calculator calculator = new Calculator();
		CalculatorUI calculatorUI = new CalculatorUI(calculator);

		calculatorUI.run();
	}
}
