package calculator;

import calculator.controller.CalculatorController;
import calculator.service.CalculatorService;
import calculator.service.InputService;
import calculator.view.CalculatorView;

public class Application {

	public static void main(String[] args) {
		new CalculatorController(
			new CalculatorService(new InputService()),
			new CalculatorView(new InputService())
		).run();
	}
}
