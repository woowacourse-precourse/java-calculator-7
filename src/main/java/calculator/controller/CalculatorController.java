package calculator.controller;

import calculator.model.DelimiterCalculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    private final DelimiterCalculator delimiterCalculator;

    public CalculatorController() {
        this.delimiterCalculator = new DelimiterCalculator();
    }

    public void run() {
        try {
            OutputView.printInput();
            String input = InputView.requestInput();
            int result = delimiterCalculator.calculate(input);
            OutputView.printResult(result);

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
