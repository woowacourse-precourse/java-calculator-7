package calculator.controller;

import calculator.view.InputView;

public class CalculatorController {
    private final InputView inputView;

    public CalculatorController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        String rawInput = inputView.getCalculatorInput();
    }
}
