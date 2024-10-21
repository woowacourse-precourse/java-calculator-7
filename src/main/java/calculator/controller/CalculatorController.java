package calculator.controller;

import calculator.service.CalculatorService;
import calculator.view.CalculatorView;

public class CalculatorController {

	private final CalculatorService calculatorService;
	private final CalculatorView calculatorView;

	public CalculatorController(CalculatorService calculatorService,
		CalculatorView calculatorView) {
		this.calculatorService = calculatorService;
		this.calculatorView = calculatorView;
	}

	public void run() {
		String userInput = calculatorView.getInput();
		long result = calculatorService.calculate(userInput);
		calculatorView.showResult(result);
	}

}
