package calculator.controller;

import calculator.domain.Separator;
import calculator.view.InputView;

public class PlayerController {
    private final InputView inputView;

    public PlayerController() {
        this.inputView = new InputView();
    }

    public void process() {
        String numbers = inputView.inputNumbers();
        Separator separator = new Separator(numbers);
    }
}
