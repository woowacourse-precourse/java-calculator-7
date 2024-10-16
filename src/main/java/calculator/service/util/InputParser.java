package calculator.service.util;

import calculator.domain.exception.CalculatorException;
import calculator.domain.exception.ErrorMessage;

public final class InputParser {
    private static String[] splitByDelimiters(String input, String delimiters) {
        return input.split(delimiters);
    }

    private static int parseToInt(String numberString) {
        try {
            return Integer.parseInt(numberString.trim());
        } catch (NumberFormatException e) {
            throw CalculatorException.from(ErrorMessage.NOT_NUMBER_ERROR);
        }
    }
}