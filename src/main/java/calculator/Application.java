package calculator;

import calculator.controller.CalculatorController;
import calculator.domain.AdditionCalculator;
import calculator.domain.DelimiterMaker;
import calculator.domain.InputParser;
import calculator.domain.NumberExtractor;
import calculator.io.input.InputHandler;
import calculator.io.output.OutputHandler;
import calculator.service.CalculatorService;

public class Application {
	public static void main(String[] args) {

		OutputHandler outputHandler = new OutputHandler();
		InputHandler inputHandler = new InputHandler();
		CalculatorService calculatorService =
			new CalculatorService(new AdditionCalculator(), new DelimiterMaker(), new NumberExtractor(), new InputParser());

		CalculatorController calculatorController =
			new CalculatorController(outputHandler, inputHandler, calculatorService);
		calculatorController.run();
	}
}
