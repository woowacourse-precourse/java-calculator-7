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
        long result = calculateSum(inputView.inputStrings());
        displayResult(result);
    }

    private long calculateSum(String input) {
        return StringAddCalculator.splitAndSum(input);
    }

    private void displayResult(long result) {
        outputView.printResult(result);
    }
}
