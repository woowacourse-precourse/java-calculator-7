package calculator.controller;

import calculator.service.CalculatorService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
	private final InputView inputView;
	private final OutputView outputView;
	private final CalculatorService calculatorService;

	public CalculatorController() {
		this.inputView = new InputView();
		this.outputView = new OutputView();
		this.calculatorService = new CalculatorService();
	}

	public void run() {
		outputView.printStartMessage();

		try {
			String input = inputView.getInput();
			int result = calculatorService.add(input);
			outputView.printResult(result);
		} catch (IllegalArgumentException e) {
			outputView.printErrorMessage(e.getMessage());
			throw e;
		}
	}
}
