package calculator.model;

import static calculator.controller.ExceptionMessage.INVALID_DELIMITER;

import calculator.validation.InputValidator;

public class Parser {
    public int toInt(String value) {
        if (value.trim().isEmpty()) {
            return 0;
        }
        InputValidator.isContainZero(value);
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_DELIMITER.format());
        }
    }
}