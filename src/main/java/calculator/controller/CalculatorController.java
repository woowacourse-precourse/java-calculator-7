package calculator.controller;

import calculator.view.CalculatorView;

public final class CalculatorController {

    private CalculatorView calculatorView;

    public CalculatorController(CalculatorView calculatorView) {
        this.calculatorView = calculatorView;
    }

    public String readUserInput() {
        String userInput;

        userInput = calculatorView.getUserInput();

        return userInput;
    }
}
