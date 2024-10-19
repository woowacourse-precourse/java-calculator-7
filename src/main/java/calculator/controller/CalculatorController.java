package calculator.controller;

import calculator.model.CalculatorModel;
import calculator.view.CalculatorView;

public final class CalculatorController {

    private CalculatorView calculatorView;
    private CalculatorModel calculatorModel;

    public CalculatorController(CalculatorView calculatorView, CalculatorModel calculatorModel) {
        this.calculatorView = calculatorView;
        this.calculatorModel = calculatorModel;
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
