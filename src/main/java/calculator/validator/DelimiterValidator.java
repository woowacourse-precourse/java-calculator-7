package calculator.validator;

import calculator.global.exception.CalculatorException;
import calculator.global.message.ErrorMessage;

public class DelimiterValidator {

    private DelimiterValidator() {
    }

    public static void validateDelimiterFormat(int prefixIndex, int suffixIndex) {
        if ((prefixIndex == -1 && suffixIndex != -1) || (prefixIndex != -1 && suffixIndex == -1)) {
            throw CalculatorException.from(ErrorMessage.INVALID_CUSTOM_DELIMITER_FORMAT);
        }

        if (prefixIndex > suffixIndex) {
            throw CalculatorException.from(ErrorMessage.INVALID_CUSTOM_DELIMITER_ORDER);
        }
    }

    public static void validateCustomDelimiter(String customDelimiter) {
        if (customDelimiter.isEmpty()) {
            throw CalculatorException.from(ErrorMessage.EMPTY_CUSTOM_DELIMITER);
        }

        if (customDelimiter.length() != 1) {
            throw CalculatorException.from(ErrorMessage.INVALID_CUSTOM_DELIMITER_LENGTH);
        }

        if (Character.isDigit(customDelimiter.charAt(0))) {
            throw CalculatorException.from(ErrorMessage.CUSTOM_DELIMITER_IS_NUMBER);
        }
    }
}
