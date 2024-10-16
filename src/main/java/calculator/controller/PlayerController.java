package calculator.controller;

import calculator.domain.Numbers;
import calculator.domain.Separator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class PlayerController {
    private Separator separator;
    private final InputView inputView;
    private final OutputView outputView;

    public PlayerController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
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
        outputView.printResult(numbers.toString());
    }
}
