package calculator.controller;

import calculator.model.CalculatorModel;
import calculator.view.CalculatorView;

public final class CalculatorController {

    private CalculatorModel calculatorModel;
    private CalculatorView calculatorView;

    public CalculatorController(CalculatorModel calculatorModel, CalculatorView calculatorView) {
        this.calculatorModel = calculatorModel;
        this.calculatorView = calculatorView;
    }

    public void calculate() {
        String inputString = readUserInput();
        parseAndInitialize(inputString);
        showResult();
    }

    public String readUserInput() {
        String userInput;

        userInput = calculatorView.getUserInput().trim();

        return userInput;
    }

    private void parseAndInitialize(String inputString) {
        try {
            calculatorModel.processInput(inputString);
        } catch (IllegalArgumentException e) {
            calculatorView.displayException(e.getMessage());
        }
    }

    private void showResult() {
        calculatorView.displayResult(calculatorModel.calculateSum());
    }
}
