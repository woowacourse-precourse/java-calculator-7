package calculator.controller;

import calculator.domain.Calculator;
import calculator.domain.NumberParser;
import calculator.view.View;

public class CalculatorController {
    private final NumberParser numberParser;
    private final Calculator calculator;

    public CalculatorController() {
        this.numberParser = new NumberParser();
        this.calculator = new Calculator();
    }

    public void run() {
        String input = View.requestString();
        String[] numbers = numberParser.parse(input);
        int result = calculator.sum(numbers);
        View.printResult(result);
    }
}
