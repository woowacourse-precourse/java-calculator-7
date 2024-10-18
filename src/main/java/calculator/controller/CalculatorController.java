package calculator.controller;

import calculator.view.InputView;

public class CalculatorController {
    InputView inputView = new InputView();

    public void run() {
        String input = inputView.readSentence();

    }
}
