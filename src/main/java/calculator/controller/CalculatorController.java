package calculator.controller;

import calculator.model.Calculator;
import calculator.model.InputValidator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Calculator calculator;

    public CalculatorController() {
        inputView = new InputView();
        outputView = new OutputView();
        calculator = new Calculator();
    }
    public void start() {
        String input = inputView.getInput();
        try {
            InputValidator validator = new InputValidator();
            validator.validate(input);
            int result = calculator.add(input);
            outputView.displayResult(result);
        } catch (Exception e) {
            outputView.displayErrorMessage(e.getMessage());
        }
    }
}
