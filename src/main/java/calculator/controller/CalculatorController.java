package calculator.controller;

import calculator.domain.Delimiters;
import calculator.service.CalculatorService;
import calculator.view.View;
import camp.nextstep.edu.missionutils.Console;

public class CalculatorController {
	private final CalculatorService calculatorService;

	public CalculatorController() {
		this.calculatorService = new CalculatorService(new Delimiters());
	}

	public void run() {
		View.inputMessage();
		String input = Console.readLine();
		int result = calculatorService.calculate(input);
		View.outputMessage(result);
	}
}
