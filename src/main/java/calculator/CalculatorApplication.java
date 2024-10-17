package calculator;

import calculator.controller.CalculatorController;
import calculator.model.Calculator;
import calculator.model.Delimiters;
import calculator.model.Numbers;
import calculator.service.DelimiterService;
import calculator.service.NumberExtractorService;

public class CalculatorApplication {
    public static void run() {
        initializeDependencies().start();
    }

    private static CalculatorController initializeDependencies() {
        Delimiters delimiters = new Delimiters();
        Calculator calculator = new Calculator();
        Numbers numbers = new Numbers();
        DelimiterService delimiterService = new DelimiterService(delimiters);
        NumberExtractorService numberExtractorService = new NumberExtractorService(numbers, delimiterService);
        return new CalculatorController(delimiterService, numberExtractorService);
    }
}
