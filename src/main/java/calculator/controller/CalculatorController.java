package calculator.controller;

import calculator.view.InputView;

public class CalculatorController {
    public void start() {
        play();
    }

    private void play() {
        InputView.expression();
    }
}
