package calculator.controller;

import calculator.validator.Validator;
import calculator.view.InputView;

public class CalculatorController {
    InputView inputView = new InputView();
    Validator validator = new Validator();

    public void run() {
        String input = inputView.readSentence();
        boolean isEmpty = validator.checkIsEmpty(input);
        validator.checkHasNumber(input);
    }
}
