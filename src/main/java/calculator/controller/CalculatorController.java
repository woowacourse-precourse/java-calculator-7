package calculator.controller;

import calculator.domain.Calculator;
import calculator.domain.InputSplitter;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final InputSplitter inputSplitter = new InputSplitter();
    private final Calculator calculator = new Calculator();

    public void operatePlusCalculator() {
        String[] numbers = inputSplitter.splitByDelimeter(InputView.inputString());
        int sum = calculator.calculateSum(numbers);
        OutputView.printResult(sum);
    }
}
