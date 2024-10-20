package calculator.controller;

import static calculator.common.Constants.DELIMITER;
import static calculator.common.Constants.FIRST_IDX;
import static calculator.common.Constants.FOURTH_IDX;
import static calculator.common.Constants.INVALID_INPUT_FORMAT;
import static calculator.common.Constants.SLASH;

import calculator.view.InputView;

public class Calculator {
    private final InputView inputView;

    public Calculator(InputView inputView) {
        this.inputView = inputView;
    }

    public void run () {
        String input = inputView.getInput();
        handleInput(input);
    }

    public void handleInput (String input) {
        validateInput(input);
    }

    private void validateInput (String input) {
        if (!input.isBlank() && !isCustomSeparator(input) && !startNumber(input)) {
            throw new IllegalArgumentException(INVALID_INPUT_FORMAT);
        }
    }

    private Boolean isCustomSeparator (String input) {
        return input.startsWith(SLASH) && input.charAt(FOURTH_IDX) == DELIMITER;
    }

    private Boolean startNumber (String input) {
        return Character.isDigit(input.charAt(FIRST_IDX));
    }
}
