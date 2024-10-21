package calculator.controller;

import calculator.model.StringCalculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    private final StringCalculator calculator;

    public CalculatorController() {
        this.calculator = new StringCalculator();
    }

    public void run() {
        try {
            OutputView.printInputPrompt();
            String input = InputView.readInput();
            int result = calculator.add(input);
            OutputView.printResult(result);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
        }
    }
}
