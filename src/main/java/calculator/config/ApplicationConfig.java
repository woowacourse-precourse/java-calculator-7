package calculator.config;

import calculator.controller.CalculatorController;
import calculator.model.Calculator;
import calculator.model.InputFilter;
import calculator.model.delimiter.CustomDelimiterProcessor;
import calculator.model.delimiter.Delimiters;
import calculator.view.InputView;
import calculator.view.OutputView;

public class ApplicationConfig {
	public CalculatorController initializeController() {
		return new CalculatorController(
			new InputView(),
			new OutputView(),
			new Delimiters(),
			new CustomDelimiterProcessor(),
			new InputFilter(),
			new Calculator()
		);
	}
}
