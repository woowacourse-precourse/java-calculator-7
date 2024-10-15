package calculator.controller;

import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public void run() {
        requestInput();
        String input = receiveInput();
    }

    private void requestInput() {
        outputView.requestInput();
    }

    private String receiveInput() {
        return inputView.receiveInput();
    }
}
