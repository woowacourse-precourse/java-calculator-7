package calculator.controller;

import calculator.view.InputView;

public class StringAdderController {
    private final InputView inputView;

    public StringAdderController() {
        this.inputView = new InputView();
    }

    public void run() {
        String additionInput = inputView.getAdditionInput();
    }
}
