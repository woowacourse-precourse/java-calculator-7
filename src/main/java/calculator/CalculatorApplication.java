package calculator;

import calculator.controller.Controller;
import calculator.model.Calculator;
import calculator.model.Delimiters;
import calculator.model.Numbers;
import calculator.service.CalculatorService;
import calculator.service.DelimiterService;
import calculator.service.NumberService;

public class CalculatorApplication {
    public static void run() {
        initializeDependencies().run();
    }

    private static Controller initializeDependencies() {
        Delimiters delimiters = new Delimiters();
        Calculator calculator = new Calculator();
        Numbers numbers = new Numbers();
        DelimiterService delimiterService = new DelimiterService(delimiters);
        NumberService numberService = new NumberService(numbers, delimiterService);
        CalculatorService calculatorService = new CalculatorService(calculator, numberService);
        return new Controller(delimiterService, numberService, calculatorService);
    }
}
