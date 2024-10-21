package calculator.controller;

import static calculator.views.OutputView.printResult;

import calculator.domain.NumberParser;
import calculator.domain.Splitter;
import calculator.domain.StringAddCalculator;
import calculator.domain.Validator;
import calculator.views.InputView;

public class CalculatorController {
    private final StringAddCalculator calculator;

    public CalculatorController() {
        Validator validator = new Validator();
        Splitter splitter = new Splitter(validator);
        NumberParser parser = new NumberParser(validator);
        this.calculator = new StringAddCalculator(splitter, parser);
    }
    public void run() {
        String input = InputView.inputString();
        try {
            int result = calculator.calculate(input);
            printResult(result);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }

    }
}
