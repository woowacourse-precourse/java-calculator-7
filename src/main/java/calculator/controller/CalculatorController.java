package calculator.controller;

import calculator.model.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final InputView inputView;
    private final OutputView outputView;

    public CalculatorController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        String input = inputView.printInputMessage();
        outputView.printCalculateResult(new Calculator().calculate(input));
    }
}
