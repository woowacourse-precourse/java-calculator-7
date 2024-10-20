package calculator.controller;

import calculator.domain.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculationController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Calculator calculator;

    public CalculationController() {
        inputView = new InputView();
        outputView = new OutputView();
        calculator = new Calculator();
    }

    public void startCalculation() {
        String input = inputView.getInputStringForAddition();
        int result = calculator.calculateSumFromString(input);
        outputView.printResult(result);
    }
}
