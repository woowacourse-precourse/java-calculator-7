package calculator;

import calculator.controller.Controller;
import calculator.model.Calculator;
import calculator.model.Delimiters;
import calculator.model.Numbers;
import calculator.service.CalculatorService;
import calculator.service.CustomDelimiterService;
import calculator.service.NumberExtractionService;

public class CalculatorApplication {
    public static void run() {
        initializeDependencies().run();
    }

    private static Controller initializeDependencies() {
        Delimiters delimiters = new Delimiters();
        Calculator calculator = new Calculator();
        Numbers numbers = new Numbers();

        CustomDelimiterService customDelimiterService = new CustomDelimiterService(delimiters);
        NumberExtractionService numberExtractionService = new NumberExtractionService(numbers, customDelimiterService);
        CalculatorService calculatorService = new CalculatorService(calculator, numberExtractionService);

        return new Controller(customDelimiterService, numberExtractionService, calculatorService);
    }
}
