package calculator.controller;

import calculator.domain.StringAddCalculator;
import calculator.views.InputView;

public class CalculatorController {
    private final StringAddCalculator calculator;

    public CalculatorController() {
        this.calculator = new StringAddCalculator();
    }
    public void run() {
        String input = InputView.inputString();

    }
}
