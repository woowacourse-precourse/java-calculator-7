package calculator.controller;

import calculator.util.StringAddCalculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculateController {

    private final InputView inputView;
    private final OutputView outputView;

    public CalculateController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        getResult(inputView.inputStrings());
    }

    private int calculateSum(String input) {
        return StringAddCalculator.splitAndSum(input);
    }

    private void getResult(String input) {
        outputView.printResult(calculateSum(input));
    }
}
