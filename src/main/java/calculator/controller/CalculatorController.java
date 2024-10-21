package calculator.controller;

import calculator.domain.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    private final Calculator calculator = new Calculator();

    public void run() {
        String input = InputView.getInput();
        int result = calculator.splitAndSum(input);
        OutputView.printResult(result);
    }
}
