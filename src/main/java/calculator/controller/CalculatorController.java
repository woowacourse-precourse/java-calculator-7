package calculator.controller;

import calculator.model.Calculator;
import calculator.model.InputValidator;
import calculator.model.StringParser;
import calculator.view.CalculatorView;

import java.util.List;

public class CalculatorController {

    private final CalculatorView view;
    private final InputValidator validator;
    private final Calculator calculator;

    public CalculatorController(CalculatorView view) {
        this.view = view;
        this.validator = new InputValidator();
        this.calculator = new Calculator();
    }

    public void run() {
        String input = view.getInput();
        validator.validate(input);
        StringParser parser = new StringParser(input);
        List<String> tokens = parser.getTokens();
        int result = calculator.calculateSum(tokens);
        view.displayResult(result);
    }
}