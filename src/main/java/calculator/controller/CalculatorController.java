package calculator.controller;

import calculator.model.Calculator;
import calculator.view.InputView;

public class CalculatorController {
    private final InputView inputView;
    private final Calculator calculator;

    public CalculatorController(InputView inputView, Calculator calculator) {
        this.inputView = inputView;
        this.calculator = calculator;
    }
}
