package calculator.controller;

import calculator.domain.StringCalculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final StringCalculator calculator;
    private final InputView inputView;
    private final OutputView outputView;

    public CalculatorController() {
        this.calculator = new StringCalculator();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void calculatorString() {
        try {
            String input = inputView.getString();

            int result = calculator.calculateSum(input);

            outputView.printResult(result);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
        }
    }
}
