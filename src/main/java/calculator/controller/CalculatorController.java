package calculator.controller;

import calculator.calculator.Calculator;
import calculator.input.InputView;
import calculator.output.OutputView;

public class CalculatorController {
    private final Calculator calculator = new Calculator();

    public void run() {
        String input = InputView.getInput();
        try {
            int result = calculator.add(input);
            OutputView.printResult(result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
