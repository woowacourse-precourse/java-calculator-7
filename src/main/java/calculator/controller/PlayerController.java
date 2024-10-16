package calculator.controller;

import calculator.domain.Numbers;
import calculator.domain.Separator;
import calculator.view.InputView;

public class PlayerController {
    private Separator separator;
    private final InputView inputView;

    public PlayerController() {
        this.inputView = new InputView();
    }
    public void process() {
        input();
        calculate();
    }
    private void input() {
        String numbers = inputView.inputNumbers();
        separator = new Separator(numbers);
    }
    private void calculate() {
        Numbers numbers = new Numbers(separator);
    }
}
