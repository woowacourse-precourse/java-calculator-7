package calculator.controller;

import calculator.domain.Calculator;
import calculator.view.InputView;

public class CalculatorController {
    private final Calculator calculator;
    private final InputView view;

    public CalculatorController(Calculator calculator, InputView view) {
        this.calculator = calculator;
        this.view = view;
    }

    public void run() {
        try {
            String input = view.getInput();
            int result = calculator.add(input);
            view.printResult(result);
        } catch (IllegalArgumentException e) {
            view.printError(e.getMessage());
        }
    }
}
