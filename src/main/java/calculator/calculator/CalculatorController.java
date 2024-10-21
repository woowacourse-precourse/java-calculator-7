package calculator.calculator;

import java.util.List;

import calculator.domain.Numbers;
import calculator.view.Input;
import calculator.view.Output;

public class CalculatorController {
	private CalculatorService calculatorService;

	public CalculatorController(CalculatorService calculatorService) {
		this.calculatorService = calculatorService;
	}

	public CalculatorController() {
	}

	public void run() {
		Output.printInputPrompt();
		String input = Input.readInput();
		if(input.isBlank()){
			Output.printDefaultResult();
			return;
		}

		List<Integer> extractNumbers = Input.extractNumbers(input);
		Numbers numbers = new Numbers(extractNumbers);
		int result = calculatorService.sum(numbers);
		Output.printResult(result);
	}
}
