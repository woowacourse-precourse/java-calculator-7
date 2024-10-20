package calculator.controller;

import calculator.model.StringCalculator;
import calculator.view.CalculatorView;

public class CalculatorController {

    private final StringCalculator stringCalculator;
    private final CalculatorView calculatorView;

    public CalculatorController(StringCalculator stringCalculator, CalculatorView calculatorView) {
        this.stringCalculator = stringCalculator;
        this.calculatorView = calculatorView;
    }

    public void run() {
        String input = calculatorView.getInput();

        int result = stringCalculator.add(input);
        calculatorView.displayResult(result);
    }
}
