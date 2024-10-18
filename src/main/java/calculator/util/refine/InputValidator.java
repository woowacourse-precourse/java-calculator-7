package calculator.util.refine;

import static calculator.util.exception.CalculatorValidationException.validateDelimiterAfterNewLinePresenceException;
import static calculator.util.exception.CalculatorValidationException.validateEmptyInputException;
import static calculator.util.exception.CalculatorValidationException.validateIsIntegerException;
import static calculator.util.exception.CalculatorValidationException.validateNonNegativeNumberException;
import static calculator.util.exception.CalculatorValidationException.validateSingleCharacterDelimiterException;

public class InputValidator {

    static void validateDelimiterAfterNewLinePresence(int delimiterIndex) {
        if (delimiterIndex == -1) {
            throw new validateDelimiterAfterNewLinePresenceException();
        }
    }

    static void validateNonNegativeNumber(int number) {
        if (number < 0) {
            throw new validateNonNegativeNumberException();
        }
    }

    static void validateSingleCharacterDelimiter(String delimiter) {
        if (delimiter.length() != 1) {
            throw new validateSingleCharacterDelimiterException();
        }
    }

    static void validateIsInteger(String token) {
        if (!token.matches("-?\\d+")) {
            throw new validateIsIntegerException();
        }
    }

    static void validateIsEmptyInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new validateEmptyInputException();
        }
    }
}
