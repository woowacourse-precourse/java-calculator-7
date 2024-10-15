package calculator.controller;

import calculator.view.OutputView;

public class CalculatorController {
    private final OutputView outputView = new OutputView();

    public void run() {
        requestInput();
    }

    private void requestInput() {
        outputView.requestInput();
    }
}
