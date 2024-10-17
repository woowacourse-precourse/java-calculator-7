package calculator;

import calculator.controller.CalculatorController;
import calculator.model.Calculator;
import calculator.model.Delimiters;
import calculator.service.DelimiterService;
import calculator.service.NumberExtractorService;

public class CalculatorApplication {
    public static void run() {
        initializeDependencies().start();
    }

    private static CalculatorController initializeDependencies() {
        Calculator calculator = new Calculator();
        Delimiters delimiters = new Delimiters();
        DelimiterService delimiterService = new DelimiterService(delimiters);
        NumberExtractorService numberExtractorService = new NumberExtractorService(delimiters, calculator);
        return new CalculatorController(delimiterService, numberExtractorService);
    }
}
