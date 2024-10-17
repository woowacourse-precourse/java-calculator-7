package calculator;

import calculator.controller.CalculatorController;
import calculator.model.Calculator;
import calculator.model.CustomDelimiterProcessor;
import calculator.model.Delimiters;
import calculator.model.NumberExtractor;

public class CalculatorApplication {
    public static void run() {
        initializeDependencies().start();
    }

    private static CalculatorController initializeDependencies() {
        Calculator calculator = new Calculator();
        Delimiters delimiters = new Delimiters();
        CustomDelimiterProcessor customDelimiterProcessor = new CustomDelimiterProcessor(delimiters);
        NumberExtractor numberExtractor = new NumberExtractor(delimiters, calculator);
        return new CalculatorController(customDelimiterProcessor, numberExtractor);
    }
}
