package calculator;

import calculator.config.ApplicationConfig;
import calculator.controller.CalculatorController;

public class Application {

	public static void main(String[] args) {
		ApplicationConfig applicationConfig = new ApplicationConfig();
		CalculatorController calculatorController = applicationConfig.initializeController();

		calculatorController.run();
	}
}
