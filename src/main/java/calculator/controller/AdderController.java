package calculator.controller;

import calculator.view.InputView;

public class AdderController {
    public void run() {
        String input = getInputString();
    }

    private String getInputString() {
        return InputView.inputString();
    }
}
