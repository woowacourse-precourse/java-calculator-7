package calculator.controller;

import calculator.model.Calculator;
import calculator.model.InputValidator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Calculator calculator;
    private final InputValidator validator;

    public CalculatorController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.calculator = new Calculator();
        this.validator = InputValidator.getInstance();
    }
    public void start() {
        String input = inputView.getInput();
        try {
            validator.validate(input);
            int result = calculator.add(input);
            outputView.displayResult(result);
        } catch (Exception e) {
            outputView.displayErrorMessage(e.getMessage());
        }
    }
}
