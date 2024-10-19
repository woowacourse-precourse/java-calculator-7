package calculator.dto;

import calculator.global.exception.CalculatorException;
import calculator.global.message.ErrorMessage;

public record AdditionInput(String input) {

    public AdditionInput {
        validateInput(input);
    }

    private void validateInput(String input) {
        if (input == null) {
            throw CalculatorException.from(ErrorMessage.NULL_INPUT_ERROR);
        }
    }
}