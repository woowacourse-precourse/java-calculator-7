package calculator.controller;

import static calculator.common.Constants.INVALID_INPUT_FORMAT;
import static calculator.common.InputValidator.isCustomSeparator;
import static calculator.common.InputValidator.startNumber;

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

        if (input.isBlank()) {

        }
    }

    private void validateInput (String input) {
        if (!input.isBlank() && !isCustomSeparator(input) && !startNumber(input)) {
            throw new IllegalArgumentException(INVALID_INPUT_FORMAT);
        }
    }

}
