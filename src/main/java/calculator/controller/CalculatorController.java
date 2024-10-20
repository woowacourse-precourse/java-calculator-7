package calculator.controller;

import calculator.domain.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    private final InputView inputView;
    private final OutputView outputView;

    public CalculatorController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void runCalculator() {
        Calculator calculator = new Calculator(inputView.inputNumber());
        int result = calculator.sum();
        outputView.printResult(result);
    }
}
