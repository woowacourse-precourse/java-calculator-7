package calculator.controller;

import calculator.io.input.InputHandler;
import calculator.io.output.OutputHandler;
import calculator.service.CalculatorService;

public class CalculatorController {

	private final OutputHandler outputHandler;
	private final InputHandler inputHandler;
	private final CalculatorService calculatorService;

	public CalculatorController(OutputHandler outputHandler, InputHandler inputHandler,
		CalculatorService calculatorService) {
		this.outputHandler = outputHandler;
		this.inputHandler = inputHandler;
		this.calculatorService = calculatorService;
	}

	public void run() {
		outputHandler.askAddNumbers();
		String userInput = inputHandler.getUserInput();
		long result = calculatorService.calculate(userInput);
		outputHandler.showResult(result);
	}
}
