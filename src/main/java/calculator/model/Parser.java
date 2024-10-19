package calculator.model;

import static calculator.controller.ExceptionMessage.INVALID_DELIMITER;

public class Parser {
    public int toInt(String value) {
        if (value.trim().isEmpty()) {
            return 0;
        }
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_DELIMITER.format());
        }
    }
}
