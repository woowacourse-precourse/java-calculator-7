package calculator.controller;

import calculator.model.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final Calculator calculator;

    public CalculatorController() {
        this.calculator = new Calculator();
    }

    public void run() {
        String input = InputView.getInput();
        int result = calculator.calculate(input);
        OutputView.printResult(result);
    }
}
