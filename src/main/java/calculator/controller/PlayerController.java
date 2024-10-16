package calculator.controller;

import calculator.domain.Separator;
import calculator.view.InputView;

public class PlayerController {
    private final InputView inputView;

    public PlayerController() {
        this.inputView = new InputView();
    }
    public void process() {
        input();
    }
    private void input() {
        String numbers = inputView.inputNumbers();
    }
}
