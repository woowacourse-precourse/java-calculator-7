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
        try {
            String input = InputView.requestInput();
            int result = delimiterCalculator.calculate(input);
            OutputView.printResult(result);
        } catch (Exception e) {
            OutputView.printError(UNDEFINED_ERROR);
        }
    }
}
