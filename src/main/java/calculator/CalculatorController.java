package calculator;

import java.util.List;

public class CalculatorController {
	private Calculator calculator;

	public CalculatorController(Calculator calculator) {
		this.calculator = calculator;
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
		int result = calculator.sum(numbers);
		Output.printResult(result);
	}
}
