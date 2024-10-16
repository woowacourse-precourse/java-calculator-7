package controller;

import model.Calculator;
import view.InputView;

public class CalculatorController {
    private final InputView inputView;
    private final Calculator calculator;

    public CalculatorController() {
        this.inputView = new InputView();
        this.calculator = new Calculator();
    }

    public void run() {
        inputView.readInputString();
        inputView.validatorAllInput();
    }

}
