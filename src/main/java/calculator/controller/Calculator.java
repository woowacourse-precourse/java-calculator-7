package calculator.controller;

import static calculator.common.Constants.INVALID_INPUT_FORMAT;
import static calculator.common.InputValidator.isCustomSeparator;
import static calculator.common.InputValidator.startNumber;

import calculator.domain.Number;
import calculator.domain.Numbers;
import calculator.view.InputView;

public class Calculator {
    private final InputView inputView;

    public Calculator(InputView inputView) {
        this.inputView = inputView;
    }

    public void run () {
        String input = inputView.getInput();
        Numbers numbers = handleInput(input);
    }

    public Numbers handleInput (String input) {
        validateInput(input);

        return new Numbers(input);

    }

    private void validateInput (String input) {
        if (!input.isBlank() && !isCustomSeparator(input) && !startNumber(input)) {
            throw new IllegalArgumentException(INVALID_INPUT_FORMAT);
        }
    }

}
