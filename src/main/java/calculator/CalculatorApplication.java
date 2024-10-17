package calculator;

import calculator.controller.Controller;
import calculator.model.Calculator;
import calculator.model.Delimiters;
import calculator.model.Numbers;
import calculator.service.CalculatorService;
import calculator.service.CustomDelimiterService;
import calculator.service.NumberExtractionService;
import calculator.view.InputView;

public class CalculatorApplication {
    public static void run() {
        InputView.printStartMessage();
        String inputString = InputView.getInput();
        initialize().run(inputString);
    }

    private static Controller initialize() {
        Delimiters delimiters = new Delimiters();
        Calculator calculator = new Calculator();
        Numbers numbers = new Numbers();

        CustomDelimiterService customDelimiterService = new CustomDelimiterService(delimiters);
        NumberExtractionService numberExtractionService = new NumberExtractionService(numbers, customDelimiterService);
        CalculatorService calculatorService = new CalculatorService(calculator, numberExtractionService);

        return new Controller(customDelimiterService, numberExtractionService, calculatorService);
    }
}
