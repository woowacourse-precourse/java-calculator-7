package calculator.controller;

import calculator.domain.Calculator;
import calculator.domain.Numbers;
import calculator.view.InputView;
import calculator.view.OutputView;

public class PlayerController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Calculator calculator;

    public PlayerController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.calculator = new Calculator();
    }
    public void process() {
        input();
    }
    private void input() {
        String numbers = inputView.inputNumbers();
        Numbers result = calculator.calculate(numbers);
        outputView.printResult(result.toString());
    }
}
