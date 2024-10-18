package calculator.controller;

import calculator.model.InputValidator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
	private final InputView inputView;
	private final InputValidator inputValidator;
	private final OutputView outputView;

	public CalculatorController() {
		this.inputView = new InputView();
		this.outputView = new OutputView();
		this.inputValidator = new InputValidator();
	}
}
