package calculator.controller;

import static calculator.exception.ErrorMessage.UNDEFINED_ERROR;

import calculator.model.DelimiterCalculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    private final DelimiterCalculator delimiterCalculator;

    public CalculatorController() {
        this.delimiterCalculator = new DelimiterCalculator();
    }

    public void run() {
        boolean isRunning = true;

        while (isRunning) {
            try {
                OutputView.printInput();
                String input = InputView.requestInput();
                int result = delimiterCalculator.calculate(input);
                OutputView.printResult(result);

                OutputView.printRepeat();
                String repeatInput = InputView.requestInput();
                if ("2".equals(repeatInput)) {
                    isRunning = false;
                }
            } catch (Exception e) {
                OutputView.printError(UNDEFINED_ERROR);
            }
        }
    }
}
