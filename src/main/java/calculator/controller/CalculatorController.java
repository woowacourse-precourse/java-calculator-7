package calculator.controller;

import calculator.view.InputView;
import calculator.view.OutputView;
import calculator.model.Calculator;
import calculator.util.InputValidator;
public class CalculatorController {
    public void run() {
        try {
            String input = InputView.getInput();

            InputValidator.validateStringFormat(input);

            int result = Calculator.calculate(input);

            OutputView.printResult(result);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
        }
    }
}
