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

        userInput = calculatorView.getUserInput();

        return userInput;
    }

    private void parseAndInitialize(String inputString) {
        calculatorModel.processInput(inputString);
    }

    private void showResult() {
        calculatorView.displayResult(calculatorModel.calculateSum());
    }
}
