package calculator.controller;

import calculator.view.CalculatorView;

public class CalculatorController {
    private CalculatorView calculatorView;

    public CalculatorController(CalculatorView view) {
        calculatorView = view;
    }

    public void start() {
        calculatorView = new CalculatorView();
        String input = calculatorView.getInput();
    }
}
