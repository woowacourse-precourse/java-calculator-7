package calculator.controller;


import calculator.model.ValidationUtils;
import calculator.view.InputView;


public class CalculatorController {
    private final InputView inputview = new InputView();
    private final ValidationUtils validationUtils = new ValidationUtils();

    public void run() {
        try {
            String input = inputview.input();
            validationUtils.validateInput(input);

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
